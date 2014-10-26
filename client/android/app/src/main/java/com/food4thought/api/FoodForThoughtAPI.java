package com.food4thought.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodForThoughtAPI {

  public static void getState(FFTHandler currentState,
                       List<Integer> ingredientIds,
                       String meal_type,
                       String cuisine_type,
                       String search) {
    final FFTHandler state = currentState;
    
    List<HashMap<String,Integer>> listOfIdMappings = new LinkedList<HashMap<String, Integer>>();
    for (Integer i : ingredientIds) {
      HashMap<String,Integer> idMapping = new HashMap<String, Integer>();
      idMapping.put("id", i);
      listOfIdMappings.add(idMapping);
    }
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("selected_ingredients", listOfIdMappings);
    map.put("meal_type", meal_type);
    map.put("cuisine_type", cuisine_type);
    map.put("search", search);
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
  
}
