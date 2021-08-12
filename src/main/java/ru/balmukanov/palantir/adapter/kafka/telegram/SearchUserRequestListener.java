package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.adapter.kafka.ChannelBinding;
import ru.balmukanov.palantir.application.api.SearchService;
import ru.balmukanov.palantir.application.api.request.SearchUserRequest;

@Component
@RequiredArgsConstructor
public class SearchUserRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(SearchUserRequestListener.class);
    private final SearchService searchService;

    @StreamListener(ChannelBinding.CHANNEL_USER_SEARCH_RQ)
    public void findUsers(SearchUserRequestDto request) {
        logger.info("Received request for user {}", request.getQuery());
        if (logger.isTraceEnabled()) {
            logger.trace("Request: {}", request);
        }

        //todo mapper here
        searchService.findUser(new SearchUserRequest());
    }
}
