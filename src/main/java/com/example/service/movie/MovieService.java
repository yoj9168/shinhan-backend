package com.example.service.movie;

import com.example.DTO.movie.PostMovieDTO;
import com.example.DTO.movie.ResponseMovieDTO;
import com.example.DTO.movie.UpdateMovieDTO;
import com.example.domain.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private static List<Movie> movies = new ArrayList<>();
    @PostConstruct
    public void init(){
        movies.addAll(List.of(
                new Movie(1,"펄프픽션", 1994, LocalDateTime.now())
                ,new Movie(2,"저수지의 개들", 1992, LocalDateTime.now())
                ,new Movie(3,"장고: 분노의 추적자", 2012, LocalDateTime.now())
        ));
    }
    public List<ResponseMovieDTO> getMovies() {
        return movies.stream().map(ResponseMovieDTO::of).toList();
    }

    public Movie getMovie(long id) {
        return movies.stream().
                filter(movie -> movie.getId() == id).findFirst().orElseThrow();
    }

    public void createMovie(PostMovieDTO postMovieDTO) {
        movies.add(new Movie(movies.size() + 1, postMovieDTO.getName(), postMovieDTO.getProductionYear(), LocalDateTime.now()));
    }

    public void updateMovie(long id, UpdateMovieDTO updateMovieDTO) {
        Movie movie = getMovie(id);
        movie.update(updateMovieDTO.getName(), updateMovieDTO.getProductionYear());
    }
    public void deleteMovie(long id) {
        Movie movie = getMovie(id);
        movies.remove(movie);
    }

}
