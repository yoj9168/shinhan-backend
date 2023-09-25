package com.example.controller;

import com.example.DTO.PostMovieDTO;
import com.example.DTO.ResponseMovieDTO;
import com.example.DTO.UpdateMovieDTO;
import com.example.common.Response;
import com.example.domain.entity.Movie;
import com.example.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name= "무비 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/v2/movies")
    public Response<List<ResponseMovieDTO>>getMovies(){
        return Response.of(movieService.getMovies());
    }
    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable(value = "id") long id)
    {
        return movieService.getMovie(id);
    }
    @PostMapping("/movies")
    public void createMovie(@RequestBody PostMovieDTO postMovieDTO){
        movieService.createMovie(postMovieDTO);
    }
    @PutMapping("/movies/{id}")
    public void updateMovie(@PathVariable(value = "id") long id, @RequestBody UpdateMovieDTO updateMovieDTO){
        movieService.updateMovie(id, updateMovieDTO);
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable(value = "id") long id){
        movieService.deleteMovie(id);
    }
}
