package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserResponseDto {
    private boolean isFind = false;
    protected String query;
    protected Map<String, String> finds;
}
