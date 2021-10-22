package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.adapter.kafka.ChannelBinding;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class TelegramServiceAdapter {
    private final ChannelBinding channelBinding;
    private final SearchResponseDtoMapper dtoMapper;

    @EventListener
    public void send(SearchUserCompletedEvent event) {
        SearchUserResponseDto response = dtoMapper.mapToDto(event);

        log.info("Sending search response for user #{} finds={}", response.getQuery(), response.getFinds());
        if (log.isTraceEnabled()) {
            log.trace("Response: {}", response);
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
