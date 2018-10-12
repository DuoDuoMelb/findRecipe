package com.example.recipefinder.recipefinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputController {
//		@RequestMapping("/")
//		@ResponseBody
//		public String index(){

    //			return "Hello World!";
//		}
    @RequestMapping("/index.html")
//		@ResponseBody
    public String index() {
        return "index";
    }
//    public String index(String name, String pwd){
//        String s1=name;
//        String s2=pwd;
//        return s1+s2;
//        return "index";

    }
//        @RequestMapping(value = "/test6")
////		@ResponseBody
//        public String test6(@ModelAttribute("kkk") String s){
//            return "test";
//
//        }



