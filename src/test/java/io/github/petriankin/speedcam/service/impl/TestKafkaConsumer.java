package io.github.petriankin.speedcam.service.impl;

import io.github.petriankin.speedcam.dto.CameraDataDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
@Getter
public class TestKafkaConsumer {

    private final CountDownLatch latch = new CountDownLatch(1);
    private CameraDataDto payload = null;

    @KafkaListener(topics = "${test.topic}")
    public void receive(CameraDataDto consumerRecord) {
        log.info("received payload='{}'", consumerRecord.toString());
        payload = consumerRecord;
        latch.countDown();
    }
}
