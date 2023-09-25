package com.example.ioc;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Chicken implements Ingredient{
    private final String name;
}
