package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CompanyAnalyze {
    private long id;
    private String name;
    private Opinion opinion;
    private String explanation;
    private String author;
    private LocalDateTime createdAt;
    private int views;
}
