package ru.balmukanov.palantir.framework;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("ru.balmukanov.palantir")
public class FeignConfig {
}