package ru.balmukanov.palantir.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.balmukanov.palantir.application.api.SearchGate;
import ru.balmukanov.palantir.application.api.SearchCollector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SearchCollectorImpl implements SearchCollector {
    private final List<SearchGate> gateImplementations;
    @Override
    public Map<String, String> collect(String username) {
        Map<String, CompletableFuture<String>> gateCallMap = new HashMap<>();

        for (SearchGate gate : gateImplementations) {
            gateCallMap.put(
                gate.gatName(),
                CompletableFuture.supplyAsync(() -> gate.find(username))
            );
        }

        Map<String, String> map = new HashMap<>();
        for (String gateName : gateCallMap.keySet()) {
            String link = gateCallMap.get(gateName).join();
            if (link != null) {
                map.put(gateName, link);
            }
        }

        return map;
    }
}