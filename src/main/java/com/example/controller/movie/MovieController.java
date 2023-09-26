package com.example.controller.movie;

import com.example.DTO.movie.PostMovieDTO;
import com.example.DTO.movie.ResponseMovieDTO;
import com.example.DTO.movie.UpdateMovieDTO;
import com.example.common.Response;
import com.example.domain.entity.Movie;
import com.example.service.movie.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseMovieDTO getMovie(@PathVariable(value = "id") long id)
    {
        return movieService.getMovie(id);
    }
    @PostMapping("/movies")
    public void saveMovie(@RequestBody PostMovieDTO postMovieDTO){
        movieService.saveMovie(postMovieDTO);
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
