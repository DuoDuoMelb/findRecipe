package com.example.recipefinder.recipefinder.controller;

import java.util.Date;

public class Ingredient {
    private String ingredientItem;
    private int ingredientAmount;
    private Unit ingredientUnit;

    public String getIngredientItem() {
        return ingredientItem;
    }

    public void setIngredientItem(String ingredientItem) {
        this.ingredientItem = ingredientItem;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public Unit getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(Unit ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }
}
