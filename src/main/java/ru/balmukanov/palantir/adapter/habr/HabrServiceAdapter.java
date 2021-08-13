package ru.balmukanov.palantir.adapter.habr;

import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.UserNotFoundException;
import ru.balmukanov.palantir.application.api.SearchGate;

@Service
@RequiredArgsConstructor
public class HabrServiceAdapter implements SearchGate {
    private final HabrFeignClient habrFeignClient;

    public String find(String username) {
        Response response;
        try {
            response = habrFeignClient.user(username);
            if (response.status() == HttpStatus.NOT_FOUND.value()) {
                throw new UserNotFoundException();
            }

            return response.request().url();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public String gateName() {
        return "habr";
    }
}