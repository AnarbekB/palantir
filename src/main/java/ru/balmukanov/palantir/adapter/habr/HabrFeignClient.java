package ru.balmukanov.palantir.adapter.habr;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "habr", url = "${service.habr.url}")
public interface HabrFeignClient {
    @GetMapping("/ru/users/{username}/")
    Response user(@PathVariable("username") String username);
}