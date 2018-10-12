package com.example.recipefinder.recipefinder.controller;

import java.util.ArrayList;

public class RecipeInfo {
    private String recipeName;
    private ArrayList<Ingredient> ingredientList;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
