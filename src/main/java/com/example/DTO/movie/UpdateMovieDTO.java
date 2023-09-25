package com.example.DTO.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UpdateMovieDTO {
    private final String name;
    private final Integer productionYear;
}
