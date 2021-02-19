package io.github.petriankin.speedcam.service.impl;

import io.github.petriankin.speedcam.service.SpeedCameraDataProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class SpeedCameraDataProducerServiceImplTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public TestKafkaConsumer testKafkaConsumer() {
            return new TestKafkaConsumer();
        }
    }

    @Autowired
    private TestKafkaConsumer consumer;

    @Autowired
    private SpeedCameraDataProducerService producer;

    @Test
    void whenSendDataToKafkaTestConsumerCanReadIt() throws InterruptedException {
        producer.produce();
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumer.getLatch().getCount()).isZero();
        assertThat(consumer.getPayload())
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }
}
