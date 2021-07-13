package ru.balmukanov.palantir.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    protected String query;

    protected Map<String, String> finds;
}
