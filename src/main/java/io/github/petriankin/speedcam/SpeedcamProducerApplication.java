package io.github.petriankin.speedcam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpeedcamProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeedcamProducerApplication.class, args);
    }
}
