package ru.balmukanov.palantir.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.UserNotFoundException;
import ru.balmukanov.palantir.application.api.SearchGate;
import ru.balmukanov.palantir.application.api.SearchCollector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchCollectorImpl implements SearchCollector {
    private final List<SearchGate> gateImplementations;
    @Override
    public Map<String, String> collect(String username) {
        Map<String, String> map = new HashMap<>();
        for (SearchGate gate : gateImplementations) {
            try {
                String link = gate.find(username);
                if (link != null) {
                    map.put(gate.gateName(), link);
                }
            } catch (UserNotFoundException ignored) {
            }
        }

        return map;
    }
}