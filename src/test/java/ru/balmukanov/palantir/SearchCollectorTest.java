package ru.balmukanov.palantir;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import ru.balmukanov.palantir.application.api.SearchCollector;
import ru.balmukanov.palantir.application.api.SearchGate;
import ru.balmukanov.palantir.application.impl.SearchCollectorImpl;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchCollectorTest {
	private SearchCollector collector;

	@BeforeEach
	public void setUp() {
		collector = new SearchCollectorImpl(List.of(new SearchGateStubOne(), new SearchGateStubTwo()));
	}

	@Test()
	@Timeout(value = 2)
	void collect() {
		Map<String, String> result = collector.collect("test");

		assertEquals(1, result.size());
		assertEquals(result.get("stub-one"), "https://stub-one/user/test");
	}

	static class SearchGateStubOne implements SearchGate {

		@Override
		public String find(String username) {
			try {
				Thread.sleep(1000);
				return String.format("https://stub-one/user/%s", username);
			} catch (InterruptedException e) {
				return null;
			}
		}

		@Override
		public String gatName() {
			return "stub-one";
		}
	}

	static class SearchGateStubTwo implements SearchGate {

		@Override
		public String find(String username) {
			try {
				Thread.sleep(1000);
				return null;
			} catch (InterruptedException e) {
				return null;
			}
		}

		@Override
		public String gatName() {
			return "stub-two";
		}
	}
}