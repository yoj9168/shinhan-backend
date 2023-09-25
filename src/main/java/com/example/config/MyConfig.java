package com.example.config;

import com.example.controller.MyController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component()
@RequiredArgsConstructor
public class MyConfig {
    @Bean
    public void config(){}
}
