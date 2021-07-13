package ru.balmukanov.palantir.application.api;

import ru.balmukanov.palantir.application.api.request.SearchUserRequest;

public interface SearchService {
    void findUser(SearchUserRequest request);
}
