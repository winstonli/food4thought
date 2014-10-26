package com.food4thought.food4thought.model;

import android.util.Log;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedRecipes implements JSONSource {

    public Publisher<SuggestedRecipes> publisher;

    private JSONSourceMap<Integer, Recipe> recipes;

    public SuggestedRecipes() {
        publisher = new Publisher<SuggestedRecipes>(this);
        recipes = new JSONSourceMap<Integer, Recipe>();
    }

    public JSONSourceMap<Integer, Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void updateFromJSON(JsonElement json) {
        Log.wtf("mioaw", json.toString());
        recipes = new JSONSourceMap<Integer, Recipe>();
        JsonArray jsonArray = (JsonArray) json;
        Log.wtf("miaow", "recipes: " + jsonArray.toString());
        for (int i = 0; i < jsonArray.size(); i++) {
            recipes.put(((JsonObject) jsonArray.get(i)).get("id").getAsInt(), new Recipe());
        }
        recipes.updateFromJSON(json);
        publisher.publishWithCode(PublishCode.SUGGESTED_RECIPES_UPDATED);
    }

}
