package com.example.DTO.companyAnalyze;

import com.example.domain.entity.Opinion;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UpdateCompanyAnalyzeDTO {
    private final String name;
    private final Opinion opinion;
    private final String explanation;
    private final String author;
    private final LocalDateTime createdAt;
    private final int views;
}