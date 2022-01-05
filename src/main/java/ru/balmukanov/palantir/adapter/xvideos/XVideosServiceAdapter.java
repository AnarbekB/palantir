package ru.balmukanov.palantir.adapter.xvideos;

import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.SearchGate;
import ru.balmukanov.palantir.application.api.UserNotFoundException;

@Service
@AllArgsConstructor
public class XVideosServiceAdapter implements SearchGate {
	private final XVideosFeignClient xVideosFeignClient;

	@Override
	public String find(String username) {
		try {
			Response response = xVideosFeignClient.user(username);
			if (response.status() == HttpStatus.NOT_FOUND.value()) {
				throw new UserNotFoundException(username);
			}

			return response.request().url();
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public String gatName() {
		return "xvideos(18+)";
	}
}