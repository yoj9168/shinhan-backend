package com.example.service.movie;

import com.example.DTO.movie.PostMovieDTO;
import com.example.DTO.movie.ResponseMovieDTO;
import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.repository.MovieRepository;
import com.example.service.log.LogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void 영화단건조회_정상_테스트(){
        // given
        long movieId = 1;
        Movie movie = new Movie();
        movie.update("HI~", LocalDateTime.now());
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        // when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        // then
        ResponseMovieDTO responseMovieDTO = movieService.getMovie(movieId);
        assertNotNull(responseMovieDTO);
    }
    @Test
    public void 영화단건조회_불가_테스트(){
        // given
        long movieId = 1;

        // when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        // then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }
    @Test
    public void 영화복수조회_정상_테스트(){
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        movie1.setDirector(new Director());
        movie1.setActors(List.of(new Actor()));

        movie2.setDirector(new Director());
        movie2.setActors(List.of(new Actor()));

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);


        when(movieRepository.findAllJpqlFetch()).thenReturn(movies);

        List<ResponseMovieDTO> responseMovieDTOs = movieService.getMovies();
        assertNotNull(responseMovieDTOs);
    }

    @Test
    public void 영화복수조회_불가_테스트(){
        when(movieRepository.findAllJpqlFetch()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> movieService.getMovies());

    }

//    @Test
//    public void 영화저장_정상_테스트(){
//        PostMovieDTO movieDTO = new PostMovieDTO("HI",LocalDateTime.now(), 1L);
//        Movie movie = new Movie("hi", LocalDateTime.now(), new Director());
//
//        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
//        doNothing().when(logService).saveLog();
//
//        movieService.saveMovie(movieDTO);
//    }
}
