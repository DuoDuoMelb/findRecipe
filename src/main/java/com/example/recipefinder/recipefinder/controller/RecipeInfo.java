package com.example.recipefinder.recipefinder.controller;

import java.util.ArrayList;

public class RecipeInfo {
    private String name;
    private ArrayList<Ingredient> ingredients;
    public RecipeInfo(){
        super();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredientList) {
        this.ingredients = ingredientList;
    }
}
