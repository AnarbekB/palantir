package ru.balmukanov.palantir.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.SearchService;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;
import ru.balmukanov.palantir.application.api.request.SearchUserRequest;
import ru.balmukanov.palantir.domain.User;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void findUser(SearchUserRequest request) {
        var result = new HashMap<String, String>();
        result.put("vk", "https://vk.com/gross_herz");
        eventPublisher.publishEvent(new SearchUserCompletedEvent(new User("test", result)));
    }
}
