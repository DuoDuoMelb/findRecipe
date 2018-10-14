package com.example.recipefinder.recipefinder.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.beans.binding.ObjectExpression;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class InputController {
//		@RequestMapping("/")
//		@ResponseBody
//		public String index(){
//
//    			return "Hello World!";
//		}
//    @RequestMapping("/index")
//		@ResponseBody
//    public String index(String name) {
//        System.out.println(name);
//        return "index";
//    }

//
    @RequestMapping({"/recipe", "/"})
    public String test(@RequestBody(required = true) RecipeInfo[] recipeInfos) {
        System.out.println("aaaaaaaa");
        //context.put("username", username);
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
        for(RecipeInfo recipeInfo:recipeInfos){
//            JSONObject jsonObject=new JSONObject(ingredient);
//            System.out.println(jsonObject.get("name"));
            System.out.println(recipeInfo.getName());
//            Ingredient ingredient=new Ingredient(recipeInfo.getIngredients());
            JSONObject jsonObject=new JSONObject(recipeInfo);
            System.out.println("recipe name"+recipeInfo.getName());
            JSONArray jsonArray=(JSONArray) jsonObject.get("ingredients");
            Unit unit;
            for (int i = 0; i < jsonArray.length(); i++) {
//                System.out.println(jsonArray.get(i).toString());
                JSONObject jsonObject1 = new JSONObject(jsonArray.get(i).toString());
                unit=Unit.valueOf(recipeInfo.getIngredients().get(i).getUnit().toString());
                System.out.println("item:"+jsonObject1.get("item"));
                System.out.println("amount"+jsonObject1.get("amount").toString());
                System.out.println(unit);
            }
//            JSONObject jsonObject1 = new JSONObject(jsonArray.get(i).toString());
//            System.out.println(jsonObject1.get("item").toString());
//        }
//            System.out.println(jsonArray.get(0).toString());
        }
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
        return "recipe";
    }
}


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

//    public String index(String name, String pwd){
//        String s1=name;
//        String s2=pwd;
//        return s1+s2;
//        return "index";


//        @RequestMapping(value = "/test6")
////		@ResponseBody
//        public String test6(@ModelAttribute("kkk") String s){
//            return "test";
//
//        }



