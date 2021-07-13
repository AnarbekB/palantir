package ru.balmukanov.palantir.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.balmukanov.palantir")
public class PalantirApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalantirApplication.class, args);
    }

}
