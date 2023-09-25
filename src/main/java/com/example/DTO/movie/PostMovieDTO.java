package com.example.DTO.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostMovieDTO {
    private final String name;
    private final Integer productionYear;
}
