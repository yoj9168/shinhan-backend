package com.example.domain.entity;

import com.example.repository.DirectorRepository;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="movie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_year")
    private LocalDateTime productionYear;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER
    ,cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Actor> actors;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public void update(String name, LocalDateTime productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }
    public Movie(String name, LocalDateTime productionYear, Director director){
        this.name = name;
        this.productionYear = productionYear;
        this.director = director;
    }
}
