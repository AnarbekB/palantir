package ru.balmukanov.palantir.adapter.kafka.telegram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserRequestDto {
    private String requestId;
    private String query;
}
