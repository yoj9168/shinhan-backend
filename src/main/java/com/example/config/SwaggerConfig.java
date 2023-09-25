package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.webmvc.api.OpenApiActuatorResource;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI swagger(){
        Info info = new Info();
        info.title("spring boot lecture api")
                .version("1.0.0")
                .description("HI~");

        return new OpenAPI().info(info);
    }
}
