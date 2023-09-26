package com.example.repository;

import com.example.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select distinct m from Movie m left join fetch m.actors a left join fetch m.director d")
    List<Movie> findAllJpqlFetch();

    List<Movie> findByProductionYear(LocalDateTime productionYear);
}
