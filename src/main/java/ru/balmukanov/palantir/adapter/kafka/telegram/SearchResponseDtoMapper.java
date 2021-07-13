package ru.balmukanov.palantir.adapter.kafka.telegram;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;
import ru.balmukanov.palantir.domain.User;

@Component
public class SearchResponseDtoMapper {
    private final ModelMapper modelMapper;

    public SearchResponseDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public SearchResponseDto mapToDto(SearchUserCompletedEvent source) {
        try {
            User user = source.getSource();
            return modelMapper.map(user, SearchResponseDto.class);
        } catch (Exception e) {
            throw new AdapterMappingException(e);
        }
    }
}
