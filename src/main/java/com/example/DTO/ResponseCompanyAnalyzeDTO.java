package com.example.DTO;

import com.example.domain.entity.CompanyAnalyze;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class ResponseCompanyAnalyzeDTO {
    private final long id;
    private final String name;
    private final String opinion;
    private final String explanation;
    private final String author;
    private final LocalDateTime createdAt;
    private final int views;

    public static ResponseCompanyAnalyzeDTO of(CompanyAnalyze companyAnalyze){
        return ResponseCompanyAnalyzeDTO.builder()
                .id(companyAnalyze.getId())
                .name(companyAnalyze.getName())
                .explanation(companyAnalyze.getExplanation())
                .author(companyAnalyze.getAuthor())
                .createdAt(companyAnalyze.getCreatedAt())
                .opinion(companyAnalyze.getOpinion().getOpinion())
                .views(companyAnalyze.getViews())
                .build();
    }
}
