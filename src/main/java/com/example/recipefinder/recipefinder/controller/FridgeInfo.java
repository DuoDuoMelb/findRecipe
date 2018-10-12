package com.example.recipefinder.recipefinder.controller;

import java.util.Date;

public class FridgeInfo {
    private String fridgeItem;
    private int fridgeAmount;
    private Date useBy;
    private Unit fridgeUnit;

    public void setFridgeItem(String fridgeItem){
        this.fridgeItem=fridgeItem;
    }
    public String getFridgeItem(){
        return fridgeItem;
    }

    public void setFridgeAmount(int fridgeAmount){
        this.fridgeAmount=fridgeAmount;
    }

    public int getFridgeAmount() {
        return fridgeAmount;
    }

    public void setUseBy(Date useBy) {
        this.useBy = useBy;
    }

    public Date getUseBy() {
        return useBy;
    }

    public void setFridgeUnit(Unit fridgeUnit) {
        this.fridgeUnit = fridgeUnit;
    }

    public Unit getFridgeUnit() {
        return fridgeUnit;
    }
}
