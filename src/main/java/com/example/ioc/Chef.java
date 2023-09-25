package com.example.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    private final IngredientFactory ingredientFactory;
    public String cook(String menu){
        Ingredient ingredient = ingredientFactory.getIngredient(menu);

        return ingredient.getName() + "으로 만든 "+ menu;
    }
}
