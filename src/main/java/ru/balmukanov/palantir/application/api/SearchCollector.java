package ru.balmukanov.palantir.application.api;

import java.util.Map;

public interface SearchCollector {
    Map<String, String> collect(String username);
}