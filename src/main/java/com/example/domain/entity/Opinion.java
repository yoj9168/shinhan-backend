package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum Opinion {
    SELL("매도"),
    BUY("매수");
    @Getter
    private final String opinion;
    Opinion(String opinion) {
        this.opinion = opinion;
    }
}
