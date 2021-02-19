package io.github.petriankin.speedcam.service.impl;

import io.github.petriankin.speedcam.dto.CameraDataDto;
import io.github.petriankin.speedcam.service.SpeedCameraDataProducerService;
import io.github.petriankin.speedcam.util.DataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpeedCameraDataProducerServiceImpl implements SpeedCameraDataProducerService {

    private final KafkaTemplate<Long, CameraDataDto> kafkaTemplate;

    @Value("${kafka.topic:test}")
    private String topicName;

    @Override
    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void produce() {
        CameraDataDto dto = DataGenerator.generateCameraData();
        log.info("sending {} to the topic {}", dto, topicName);
        kafkaTemplate.send(topicName, dto);
    }
}
