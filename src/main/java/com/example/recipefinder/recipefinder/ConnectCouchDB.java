//package com.example.recipefinder.recipefinder;
//
//import com.example.recipefinder.recipefinder.controller.RecipeInfo;
//import com.example.recipefinder.recipefinder.controller.Unit;
//import org.ektorp.CouchDbConnector;
//import org.ektorp.CouchDbInstance;
//import org.ektorp.http.StdHttpClient;
//import org.ektorp.impl.StdCouchDbConnector;
//import org.ektorp.impl.StdCouchDbInstance;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import sun.net.www.http.HttpClient;
//
//import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ConnectCouchDB {
//    HttpClient httpClient;
//    CouchDbInstance dbInstance;
//    CouchDbConnector dbConnector;
//    JSONArray resultBefore=new JSONArray();
//    Map<String, String> map = new HashMap<String, String>();
//    public void insert(String DBname, RecipeInfo recipeInfo) throws MalformedURLException {
//        org.ektorp.http.HttpClient HttpClient = new StdHttpClient.Builder().url("http://127.0.0.1:5984").username("ning").password("19940215").build();
//        CouchDbInstance dbInstance = new StdCouchDbInstance(HttpClient);
//        CouchDbConnector dbConnector = new StdCouchDbConnector(DBname, dbInstance);
//        dbConnector.createDatabaseIfNotExists();
//        Map<String, Object> doc = new HashMap<String, Object>();
//        doc.put("name", recipeInfo.getName());
//        JSONObject jsonObject = new JSONObject(recipeInfo);
//        System.out.println("recipe name" + recipeInfo.getName());
//        JSONArray jsonArray = (JSONArray) jsonObject.get("ingredients");
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject jsonObject1 = new JSONObject(jsonArray.get(i).toString());
//            Unit unit = Unit.valueOf(recipeInfo.getIngredients().get(i).getUnit().toString());
//            System.out.println("item:" + jsonObject1.get("item"));
//            System.out.println("amount" + jsonObject1.get("amount").toString());
//            System.out.println(unit);
//        }
//        dbConnector.create(doc);
//
//    }
//}
