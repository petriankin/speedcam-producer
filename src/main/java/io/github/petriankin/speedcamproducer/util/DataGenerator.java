package io.github.petriankin.speedcamproducer.util;


import io.github.petriankin.speedcamproducer.dto.CameraDataDto;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public static CameraDataDto generateCameraData() {
        return CameraDataDto.builder()
                .cameraId(generateCameraId())
                .dateTime(Instant.now().toString())
                .licensePlate(generateLicensePlate())
                .speed(generateSpeed())
                .build();
    }

    private static String generateLicensePlate() {
        char letter1 = getRandomChar();
        char letter2 = getRandomChar();
        char letter3 = getRandomChar();

        int number1 = getRandomDigit();
        int number2 = getRandomDigit();
        int number3 = getRandomDigit();

        return String.format("%c%d%d%d%c%c", letter1, number1, number2, number3, letter2, letter3);
    }

    private static int getRandomDigit() {
        return (int) (Math.random() * 10);
    }

    private static char getRandomChar() {
        return (char) (65 + (int) (Math.random() * (90 - 65)));
    }

    private static long generateCameraId() {
        return ThreadLocalRandom.current().nextLong(1, 100);
    }

    private static int generateSpeed() {
        return ThreadLocalRandom.current().nextInt(20, 180);
    }
}
