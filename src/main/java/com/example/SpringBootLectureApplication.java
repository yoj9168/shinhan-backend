package com.example;

import com.example.config.MyConfig;
import com.example.config.MyConfigProto;
import com.example.ioc.Chef;
import com.example.ioc.Ingredient;
import com.example.ioc.IngredientFactory;
import com.example.ioc.PrintBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLectureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLectureApplication.class, args);
//
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
//        System.out.println(chef.cook("chicken"));
    }
}
