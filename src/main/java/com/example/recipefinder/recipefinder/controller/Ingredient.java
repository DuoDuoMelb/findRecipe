package com.example.recipefinder.recipefinder.controller;

public class Ingredient {
    private String item;
    private int amount;
    private Unit unit;
    public Ingredient(){
        super();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String ingredientItem) {
        this.item = ingredientItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int ingredientAmount) {
        this.amount = ingredientAmount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit ingredientUnit) {
        this.unit = ingredientUnit;
    }
}
