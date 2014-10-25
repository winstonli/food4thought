package com.example.myfirstapp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FoodForThoughtAPI {

  public static void getState(FFTHandler currentState, 
                       List<Integer> ingredientIds,
                       String meal_type,
                       String cuisine_type) {
    final FFTHandler state = currentState;
    
    List<HashMap<String,Integer>> listOfIdMappings = new LinkedList<>();
    for (Integer i : ingredientIds) {
      HashMap<String,Integer> idMapping = new HashMap<>();
      idMapping.put("id", i);
      listOfIdMappings.add(idMapping);
    }
    Map<String,Object> map = new HashMap<>();
    map.put("selected_ingredients", listOfIdMappings);
    map.put("meal_type", meal_type);
    map.put("cuisine_type", cuisine_type);
    Gson gson = new Gson();
    //Creates string in JSON form for query
    final String jsonString = gson.toJson(map);
    
    AsyncRequestDelegate delegate = new AsyncRequestDelegate() {
      
      @Override
      public void success(String result) {
        Gson gson = new Gson();
        JsonObject j = gson.fromJson(result, JsonObject.class);
        j = (JsonObject)j.get("success");
        j = (JsonObject)j.get("data");
        state.jsonReceived(j);
      }
      
      @Override
      public void failure() {
        state.failed();
      }     
    };
    
    AsyncExample async = new AsyncExample(jsonString, delegate);
    
    async.execute();
    
  }
  
  //api call for search
}
