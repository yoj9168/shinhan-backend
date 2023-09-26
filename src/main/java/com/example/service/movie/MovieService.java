package com.example.service.movie;

import com.example.DTO.movie.PostMovieDTO;
import com.example.DTO.movie.ResponseMovieDTO;
import com.example.DTO.movie.UpdateMovieDTO;
import com.example.domain.entity.Director;
import com.example.domain.entity.Log;
import com.example.domain.entity.Movie;
import com.example.repository.DirectorRepository;
import com.example.repository.LogRepository;
import com.example.repository.MovieRepository;
import com.example.service.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogService logService;
    private final DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    public List<ResponseMovieDTO> getMovies(){
        return movieRepository.findByProductionYear(LocalDateTime.of(2019, 11, 12, 12, 32,22)).stream().map(ResponseMovieDTO::of).toList();
    }
    @Transactional(readOnly = true)
    public ResponseMovieDTO getMovie(long id) {
        return ResponseMovieDTO.of(movieRepository.findById(id).orElseThrow());
    }
    @Transactional
    public void saveMovie(PostMovieDTO postMovieDTO) {
        Director director = directorRepository.findById(postMovieDTO.getDirectorId()).orElseThrow();
        Movie movie = new Movie(postMovieDTO.getName(), postMovieDTO.getProductionYear(), director);
        logService.saveLog();

        movieRepository.save(movie);
//        throw new RuntimeException("뭔가 에러가 있어");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = entityManager.getTransaction();
//        try{
//            tx.begin();
//            Movie movie = new Movie(postMovieDTO.getName(), postMovieDTO.getProductionYear(), postMovieDTO.getDirectorId());
//
//            entityManager.persist(movie);
//            entityManager.flush();
//
//            tx.commit();
//
//            throw new RuntimeException("롤백");
//        }
//        catch (Exception e){
//            tx.rollback();
//        }
    }
    @Transactional
    public void updateMovie(long id, UpdateMovieDTO updateMovieDTO) {
        movieRepository.findById(id).orElseThrow().update(updateMovieDTO.getName(), updateMovieDTO.getProductionYear());
    }
    @Transactional
    public void deleteMovie(long id) {
        movieRepository.delete(movieRepository.findById(id).orElseThrow());
    }

}
