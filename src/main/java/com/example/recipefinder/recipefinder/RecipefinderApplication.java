package com.example.recipefinder.recipefinder;

import com.example.recipefinder.recipefinder.controller.FridgeInfo;
import com.example.recipefinder.recipefinder.controller.Ingredient;
import com.example.recipefinder.recipefinder.controller.RecipeInfo;
import com.example.recipefinder.recipefinder.controller.Unit;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONObject;

@SpringBootApplication
@EnableAutoConfiguration
public class RecipefinderApplication {
    public static String fridgeItem, recipeItem, recipeName;
    public static int fridgeAmount, recipeAmount;
    public static Date useBy;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<FridgeInfo> fridgeList = null;
    public static ArrayList<RecipeInfo> recipeList = null;
    private static FridgeInfo[] fridgeInfos = null;
    private static RecipeInfo[] recipeInfos = null;
    private static ArrayList<RecipeInfo> generatedRecipe = new ArrayList<RecipeInfo>();
    private static RecipeInfo finalRecipe = new RecipeInfo();

    public static void main(String[] args) {
        SpringApplication.run(RecipefinderApplication.class, args);

    }

    public void setFridge(FridgeInfo[] fridge) {
        fridgeInfos = fridge;
        for (FridgeInfo fridgeInfo : fridgeInfos) {
            System.out.println("fridegItem: " + fridgeInfo.getItem());
            System.out.println("fridegAmount: " + fridgeInfo.getAmount());
            System.out.println("fridegUnit: " + fridgeInfo.getUnit());
            System.out.println("fridegUseBy: " + fridgeInfo.getUseBy());
        }

    }

    public void setRecipe(RecipeInfo[] recipe) throws ParseException {
        recipeInfos = recipe;
        for (RecipeInfo recipeInfo : recipeInfos) {
            JSONObject jsonObject = new JSONObject(recipeInfo);
            System.out.println("recipe name:" + recipeInfo.getName());
            JSONArray jsonArray = (JSONArray) jsonObject.get("ingredients");
            System.out.println("Ingredient of " + recipeInfo.getName() + " is:");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = new JSONObject(jsonArray.get(i).toString());
                Unit unit = Unit.valueOf(recipeInfo.getIngredients().get(i).getUnit().toString());
                System.out.println("item:" + jsonObject1.get("item"));
                System.out.println("amount:" + jsonObject1.get("amount").toString());
                System.out.println("unit:" + unit);
            }
        }
        recipeFinder(fridgeInfos, recipeInfos);

    }

    public static void recipeFinder(FridgeInfo[] fridgeInfos, RecipeInfo[] recipeInfos) throws ParseException {
        if (fridgeInfos.length == 0) {
            System.out.println("Please enter fridge items");
        } else if (recipeInfos.length == 0) {
            System.out.println("Please enter recipe items");
        } else {
            finalRecipe = recipeGenerator(fridgeInfos, recipeInfos);
            System.out.println("final recipe:" + finalRecipe.getName().toString());
        }

    }

    public static RecipeInfo recipeGenerator(FridgeInfo[] fridgeInfos, RecipeInfo[] recipeInfos) throws ParseException {
        Date currentDate = new Date();
        for (RecipeInfo recipeInfo : recipeInfos) {
            int ingredientInFridge = 0;
            int ingredientInRecipe = recipeInfo.getIngredients().size();
            for (Ingredient ingredient : recipeInfo.getIngredients()) {
                for (FridgeInfo fridgeInfo : fridgeInfos) {
                    if (fridgeInfo.getItem().equals(ingredient.getItem()) && fridgeInfo.getAmount() >= ingredient.getAmount() &&
                            fridgeInfo.getUnit().equals(ingredient.getUnit()) && dateFormatter.parse(fridgeInfo.getUseBy()).after(currentDate)) {
                        ingredientInFridge++;
                    }
                }
            }
            if (ingredientInFridge == ingredientInRecipe) {
                generatedRecipe.add(recipeInfo);
            }
        }
        return generatedRecipeProcess(generatedRecipe, fridgeInfos);
    }


    public static RecipeInfo generatedRecipeProcess(ArrayList<RecipeInfo> generatedRecipe, FridgeInfo[] fridgeInfos) throws ParseException {
        ArrayList<Date> sortedItemDate = new ArrayList<Date>();
        Date current = new Date();
//        System.out.println("size:"+generatedRecipe.size());
        for (FridgeInfo fridgeInfo : fridgeInfos) {
            sortedItemDate.add(dateFormatter.parse(fridgeInfo.getUseBy()));
        }
        Collections.sort(sortedItemDate);
        if (generatedRecipe.size() == 1) {
            finalRecipe = generatedRecipe.get(0);
        } else if (generatedRecipe.size() == 0) {
            finalRecipe.setName("Order TakeOut");
        } else {
            for (Date date : sortedItemDate) {
                if (date.compareTo(current) > 0) {
                    for (RecipeInfo recipeInfo : generatedRecipe) {
                        for (Ingredient ingredient : recipeInfo.getIngredients()) {
                            for (FridgeInfo fridgeInfo : fridgeInfos) {
                                if (fridgeInfo.getItem().equals(ingredient.getItem())) {
                                    if (dateFormatter.parse(fridgeInfo.getUseBy()).compareTo(date) == 0) {
                                        finalRecipe = recipeInfo;
                                        return finalRecipe;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return finalRecipe;

    }

//    public RecipeInfo recipeProcess(JSONObject recipe) {
//
//        RecipeInfo recipeInfo = new RecipeInfo();
//        recipeInfo.setName((String) recipe.get("name"));
//        JSONArray ingredientJson = (JSONArray) (recipe.get("ingredient"));
//        ArrayList<Ingredient> ingredientDetail = new ArrayList<Ingredient>();
//        for (int i = 0; i < ingredientJson.length(); i++) {
//            ingredientDetail.add(ingredientProcess((JSONObject) ingredientJson.get(i)));
//        }
//
//        return recipeInfo;
//    }

//    public FridgeInfo fridgeProcess(String fridge) throws ParseException {
//        String[] detail = fridge.split(",");
//        FridgeInfo fridgeInfo = new FridgeInfo();
//
//        Date useBy = dateFormatter.parse(detail[3]);
//
//        fridgeInfo.setItem(detail[0]);
//        fridgeInfo.setAmount(Integer.parseInt(detail[1]));
//        fridgeInfo.setUnit(Unit.valueOf(detail[2]));
//        fridgeInfo.setUseBy(useBy.toString());
//        return fridgeInfo;
//    }

//    public Ingredient ingredientProcess(JSONObject ingredient) {
//
//        Ingredient ingredient1 = new Ingredient();
//        ingredient1.setItem((String) ingredient.get("item"));
//        ingredient1.setAmount(Integer.parseInt((String) ingredient.get("amount")));
//        ingredient1.setUnit(Unit.valueOf((String) ingredient.get("unit")));
//        return ingredient1;
//    }


}
