package com.example.recipefinder.recipefinder.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FridgeInfo {
    private String item;
    private int amount;
    private String useBy;
    private Unit unit;

    public FridgeInfo() {
        super();
    }

    public void setItem(String fridgeItem) {
        this.item = fridgeItem;
    }

    public String getItem() {
        return item;
    }

    public void setAmount(int fridgeAmount) {
        this.amount = fridgeAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void setUseBy(String useBy) {
        this.useBy = useBy;
    }

    public String getUseBy() {
        return useBy;
    }

    public void setUnit(Unit fridgeUnit) {
        this.unit = fridgeUnit;
    }

    public Unit getUnit() {
        return unit;
    }
}
