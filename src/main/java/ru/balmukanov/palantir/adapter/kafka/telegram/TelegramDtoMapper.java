package ru.balmukanov.palantir.adapter.kafka.telegram;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.balmukanov.palantir.application.api.exception.AdapterMappingException;
import ru.balmukanov.palantir.application.api.request.SearchUserRequest;

@Component
public class TelegramDtoMapper {
	private final ModelMapper mapper;
	public TelegramDtoMapper() {
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		this.mapper.typeMap(SearchUserRequestDto.class, SearchUserRequest.class)
			.addMapping(SearchUserRequestDto::getRequestId, SearchUserRequest::setRequestId)
			.addMapping(SearchUserRequestDto::getQuery, SearchUserRequest::setQuery);
	}

	public SearchUserRequest matToDto(SearchUserRequestDto request) {
		try {
			return mapper.map(request, SearchUserRequest.class);
		} catch (Exception e) {
			throw new AdapterMappingException(e);
		}
	}
}