package com.example.DTO.movie;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
public class ResponseMovieDTO {
    private final long id;
    private final String name;
    private final LocalDateTime productionYear;
    private final String directorName;
    private final List<String> actorNames;

    public static ResponseMovieDTO of(Movie entity){
        return ResponseMovieDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productionYear(entity.getProductionYear())
                .directorName(entity.getDirector().getName())
                .actorNames(entity.getActors().stream().map(Actor::getName).toList())
                .build();
    }
}
