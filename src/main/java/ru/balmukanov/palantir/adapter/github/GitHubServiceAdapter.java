package ru.balmukanov.palantir.adapter.github;

import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.SearchGate;
import ru.balmukanov.palantir.application.api.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class GitHubServiceAdapter implements SearchGate {
    public final GitHubFeignClient gitHubFeignClient;

    @Override
    public String find(String username) {
        Response response;
        try {
            response = gitHubFeignClient.user(username);
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
        return "github";
    }
}