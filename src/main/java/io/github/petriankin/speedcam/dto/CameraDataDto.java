package io.github.petriankin.speedcam.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CameraDataDto {
    private Long cameraId;
    private Integer speed;
    private String licensePlate;
    private String dateTime;

}
