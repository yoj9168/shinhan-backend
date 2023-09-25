package com.example.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private long id;
    private String name;
    private Integer productionYear;
    private LocalDateTime createdAt;

    public void update(String name, Integer productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }
}
