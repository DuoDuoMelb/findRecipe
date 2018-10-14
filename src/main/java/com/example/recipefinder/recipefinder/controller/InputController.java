package com.example.recipefinder.recipefinder.controller;

import com.example.recipefinder.recipefinder.RecipefinderApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.beans.binding.ObjectExpression;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class InputController {

    @RequestMapping({"/fridge", "/"})
    public String fridge(@RequestBody(required = true) FridgeInfo[] fridgeInfos) {
        RecipefinderApplication recipefinderApplication = new RecipefinderApplication();
        recipefinderApplication.setFridge(fridgeInfos);
        return "fridge";}
//        for (FridgeInfo fridgeInfo : fridgeInfos) {
//            System.out.println("fridegItem:"+fridgeInfo.getItem());
//            System.out.println("fridegAmount:"+fridgeInfo.getAmount());
//            System.out.println("fridegUnit:"+fridgeInfo.getUnit());
//            System.out.println("fridegUseBy:"+fridgeInfo.getUseBy());
//        }


    @RequestMapping({"/recipe", "/"})
    public String test(@RequestBody(required = true) RecipeInfo[] recipeInfos) throws MalformedURLException, ParseException {
        RecipefinderApplication recipefinderApplication = new RecipefinderApplication();
        recipefinderApplication.setRecipe(recipeInfos);
        return "recipe";
    }
}


//        String replace=map.get("ingredients").toString().replace("["," ");
//        replace=replace.replace("]"," ");
//        JSONArray jsonArray=new JSONArray(map.get("ingredients").toString());
//        JSONObject jsonObject=new JSONObject(jsonArray.get(0));
//        String string=jsonObject.getString("item");
//        JSONObject jsonObject=new JSONObject(jsonArray.get(0));
//        JSONObject jsonObject1=new JSONObject(jsonObject.get("item"));
//        JSONObject jsonObject=new JSONObject(map.get("ingredients"));
//            JSONObject jsonObject=new JSONObject(map);
//            JSONArray ingredientArray=new JSONArray(strings);

//        for (RecipeInfo recipeInfo : recipeInfos) {
////            ConnectCouchDB connectCouchDB=new ConnectCouchDB();
////            connectCouchDB.insert("recipe",recipeInfo);
//            System.out.println(recipeInfo.getName());
//            JSONObject jsonObject = new JSONObject(recipeInfo);
//            System.out.println("recipe name" + recipeInfo.getName());
//            JSONArray jsonArray = (JSONArray) jsonObject.get("ingredients");
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject1 = new JSONObject(jsonArray.get(i).toString());
//                Unit unit = Unit.valueOf(recipeInfo.getIngredients().get(i).getUnit().toString());
//                System.out.println("item:" + jsonObject1.get("item"));
//                System.out.println("amount" + jsonObject1.get("amount").toString());
//                System.out.println(unit);
//            }
//        }
//            for(int i=0;i<ingredientArray.length();i++){
//                System.out.println(ingredientArray.get(i).toString());
//                JSONObject ingredient=new JSONObject(ingredientArray.get(i).toString());
//            }

//        JSONObject jsonObject = new JSONObject(map);
//        JSONArray ingredientsArray = (JSONArray) jsonObject.get("ingredients");
//        System.out.println(jsonObject.get("name").toString());
//        for (int i = 0; i < ingredientsArray.length(); i++) {
//            JSONObject jsonObject1 = new JSONObject(ingredientsArray.get(i).toString());
//            System.out.println(jsonObject1.get("item").toString());
//        }


//    @RequestMapping({"/test", "/"})
//    public String test(HttpServletRequest request) {
//        String name = request.getParameter("name");
////        String amount = request.getParameter("amount");
////        String unit = request.getParameter("unit");
////        String useBy = request.getParameter("useBy");
////        FridgeInfo fridgeInfo = new FridgeInfo();
////        fridgeInfo.setFridgeItem(name);
////        fridgeInfo.setFridgeUnit(unit);
//        System.out.println(name);
//        return "test";
//    }

//    }




