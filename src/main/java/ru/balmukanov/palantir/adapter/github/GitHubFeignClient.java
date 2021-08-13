package ru.balmukanov.palantir.adapter.github;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github", url = "${service.github.url}")
public interface GitHubFeignClient {
    @GetMapping("/{username}/")
    Response user(@PathVariable("username") String username);
}