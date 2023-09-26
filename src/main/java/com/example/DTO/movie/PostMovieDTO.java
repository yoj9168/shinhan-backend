package com.example.DTO.movie;

import com.example.domain.entity.Director;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class PostMovieDTO {
    private final String name;
    private final LocalDateTime productionYear;
    private final long directorId;
}
