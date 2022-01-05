package ru.balmukanov.palantir.adapter.xvideos;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "xvideos", url = "${service.xvideos.url}")
public interface XVideosFeignClient {
	@GetMapping("/profiles/{username}")
	Response user(@PathVariable("username") String username);
}