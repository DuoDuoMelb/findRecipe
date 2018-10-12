package com.example.recipefinder.recipefinder;

import com.example.recipefinder.recipefinder.controller.FridgeInfo;
import com.example.recipefinder.recipefinder.controller.Ingredient;
import com.example.recipefinder.recipefinder.controller.RecipeInfo;
import com.example.recipefinder.recipefinder.controller.Unit;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONObject;

@SpringBootApplication
public class RecipefinderApplication {
    public static String fridgeItem, recipeItem, recipeName;
    public static int fridgeAmount, recipeAmount;
    public static Date useBy;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<FridgeInfo> fridgeList;
    public static ArrayList<RecipeInfo> recipeList;
    private static ArrayList<RecipeInfo> generatedRecipe = new ArrayList<RecipeInfo>();
    private static RecipeInfo finalRecipe = new RecipeInfo();

    public static void main(String[] args) {
        SpringApplication.run(RecipefinderApplication.class, args);
        recipeFinder();

    }

    //    @Controller
//    public class HelloController {
//        @RequestMapping("/index.html")
//        public String toIndex(){
//            return "index";
//        }
//    }
    public static void recipeFinder() {
        fridgeList = getFridgelist();
        recipeList = getRecipeList();
        if (fridgeList.size() == 0) {
            System.out.println("Please enter fridge items");
        } else if (recipeList.size() == 0) {
            System.out.println("Please enter recipe items");
        } else {
            finalRecipe = recipeGenerator();
        }

    }

    public static RecipeInfo recipeGenerator() {
        Date currentDate = new Date();
        for (RecipeInfo recipeInfo : recipeList) {
            int ingredientInFridge = 0;
            int ingredientInRecipe = recipeInfo.getIngredientList().size();
            for (Ingredient ingredient : recipeInfo.getIngredientList()) {
                for (FridgeInfo fridgeInfo : fridgeList) {
                    if (fridgeInfo.getFridgeItem().equals(ingredient.getIngredientItem()) && fridgeInfo.getFridgeAmount() <= ingredient.getIngredientAmount() &&
                            fridgeInfo.getFridgeUnit().equals(ingredient.getIngredientUnit()) && fridgeInfo.getUseBy().after(currentDate)) {
                        ingredientInFridge++;
                    }
                }
            }
            if (ingredientInFridge == ingredientInRecipe) {
                generatedRecipe.add(recipeInfo);
            }
        }
        return generatedRecipeProcess(generatedRecipe);
    }

    public static RecipeInfo generatedRecipeProcess(ArrayList<RecipeInfo> generatedRecipe) {
        ArrayList<Date> sortedItemDate=new ArrayList<Date>();
        for(FridgeInfo fridgeInfo:fridgeList){
            sortedItemDate.add(fridgeInfo.getUseBy());
        }
        Collections.sort(sortedItemDate);
        if(generatedRecipe.size()==1){
            finalRecipe=generatedRecipe.get(0);
        }
        else if (generatedRecipe.size() == 0) {
            finalRecipe.setRecipeName("Order TakeOut");
        }
        else{
            for(Date date:sortedItemDate){
                for(RecipeInfo recipeInfo:generatedRecipe){
                    for(Ingredient ingredient:recipeInfo.getIngredientList()){
                        for(FridgeInfo fridgeInfo:fridgeList){
                            if(fridgeInfo.getFridgeItem().equals(ingredient.getIngredientItem())){
                                if(fridgeInfo.getUseBy().compareTo(date)==0){
                                    finalRecipe=recipeInfo;
                                    break;
                                }
                            }
                        }

                    }

                }
            }


        }
        return finalRecipe;

    }

    public ArrayList<FridgeInfo> getFridgelist() {
        fridgeList.add(fridgeProcess());
        return fridgeList;
    }

    public ArrayList<RecipeInfo> getRecipeList() {
        recipeList.add(recipeProcess());
        return recipeList;
    }

    public RecipeInfo recipeProcess(JSONObject recipe) {

        RecipeInfo recipeInfo = new RecipeInfo();
        recipeInfo.setRecipeName((String) recipe.get("name"));
        JSONArray ingredientJson = (JSONArray) (recipe.get("ingredient"));
        ArrayList<Ingredient> ingredientDetail = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredientJson.length(); i++) {
            ingredientDetail.add(ingredientProcess((JSONObject) ingredientJson.get(i)));
        }

        return recipeInfo;
    }

    public FridgeInfo fridgeProcess(String fridge) throws ParseException {
        String[] detail = fridge.split(",");
        FridgeInfo fridgeInfo = new FridgeInfo();

        Date useBy = dateFormatter.parse(detail[3]);

        fridgeInfo.setFridgeItem(detail[0]);
        fridgeInfo.setFridgeAmount(Integer.parseInt(detail[1]));
        fridgeInfo.setFridgeUnit(Unit.valueOf(detail[2]));
        fridgeInfo.setUseBy(useBy);
        return fridgeInfo;
    }

    public Ingredient ingredientProcess(JSONObject ingredient) {

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setIngredientItem((String) ingredient.get("item"));
        ingredient1.setIngredientAmount(Integer.parseInt((String) ingredient.get("amount")));
        ingredient1.setIngredientUnit(Unit.valueOf((String) ingredient.get("unit")));
        return ingredient1;
    }


}
