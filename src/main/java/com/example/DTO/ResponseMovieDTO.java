package com.example.DTO;

import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ResponseMovieDTO {
    private final long id;
    private final String name;
    private final Integer productionYear;

    public static ResponseMovieDTO of(Movie movie){
        return ResponseMovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .productionYear(movie.getProductionYear())
                .build();
    }
}
