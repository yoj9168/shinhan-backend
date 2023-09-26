package com.example.DTO.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UpdateMovieDTO {
    private final String name;
    private final LocalDateTime productionYear;
}
