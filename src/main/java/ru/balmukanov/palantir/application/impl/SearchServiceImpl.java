package ru.balmukanov.palantir.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.SearchService;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;
import ru.balmukanov.palantir.application.api.SearchCollector;
import ru.balmukanov.palantir.application.api.request.SearchUserRequest;
import ru.balmukanov.palantir.domain.User;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final ApplicationEventPublisher eventPublisher;
    private final SearchCollector searchCollector;

    @Override
    public void findUser(SearchUserRequest request) {
        Map<String, String> result = searchCollector.collect(request.getQuery());
        eventPublisher.publishEvent(new SearchUserCompletedEvent(new User(request.getQuery(), result)));
    }
}
