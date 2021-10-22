package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.adapter.kafka.ChannelBinding;
import ru.balmukanov.palantir.application.api.SearchService;
import ru.balmukanov.palantir.application.api.request.SearchUserRequest;

@Component
@Slf4j
@RequiredArgsConstructor
public class TelegramListener {
    private final SearchService searchService;
    private final TelegramDtoMapper mapper;

    @StreamListener(ChannelBinding.CHANNEL_USER_SEARCH_RQ)
    public void findUsers(SearchUserRequestDto request) {
        log.info("Received request for user {}", request.getQuery());
        if (log.isTraceEnabled()) {
            log.trace("Request: {}", request);
        }

        SearchUserRequest searchRequest = mapper.matToDto(request);
        searchService.findUser(searchRequest);
    }
}
