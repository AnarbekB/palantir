package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.adapter.kafka.ChannelBinding;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;

@Component
@RequiredArgsConstructor
public class SearchUserResponseSender {
    private static final Logger logger = LoggerFactory.getLogger(SearchUserResponseSender.class);
    private final ChannelBinding channelBinding;
    private final SearchResponseDtoMapper dtoMapper;

    @EventListener
    public void sendSearchUserResponse(SearchUserCompletedEvent event) {
        SearchResponseDto response = dtoMapper.mapToDto(event);

        logger.info("Sending search response for user #{} finds={}", response.getQuery(), response.getFinds());
        if (logger.isTraceEnabled()) {
            logger.trace("Response: {}", response);
        }

        boolean published = channelBinding.searchUserResponse().send(MessageBuilder.withPayload(response).build());
        if (!published) {
            throw new MessageDeliveryException(
                    String.format("Channel failed to send response message for user #%s",
                    response.getQuery())
            );
        }
    }
}
