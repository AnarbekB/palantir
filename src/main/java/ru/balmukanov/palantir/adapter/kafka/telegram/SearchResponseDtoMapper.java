package ru.balmukanov.palantir.adapter.kafka.telegram;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import ru.balmukanov.palantir.application.api.event.SearchUserCompletedEvent;
import ru.balmukanov.palantir.application.api.exception.AdapterMappingException;
import ru.balmukanov.palantir.domain.User;

public class SearchResponseDtoMapper {
    private final ModelMapper modelMapper;

    public SearchResponseDtoMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public SearchUserResponseDto mapToDto(SearchUserCompletedEvent source) {
        try {
            User user = source.getSource();
            SearchUserResponseDto dto = modelMapper.map(user, SearchUserResponseDto.class);
            if (!dto.finds.isEmpty()) {
                dto.setFind(true);
            }

            return dto;
        } catch (Exception e) {
            throw new AdapterMappingException(e);
        }
    }
}
