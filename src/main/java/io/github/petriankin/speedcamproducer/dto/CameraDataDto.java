package io.github.petriankin.speedcamproducer.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CameraDataDto {
    Long cameraId;
    Integer speed;
    String licensePlate;
    String dateTime;
}
