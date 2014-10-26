package com.food4thought.food4thought.model;

import android.util.Log;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class Recipe implements JSONSource {

    private static String[] names = {
            "Fried alpaca Meat",
            "Fried alpaca Feet",
            "Fried alpaca Hands",
            "Fried alpaca legs",
            "Fried alpaca head",
            "Fried alpaca eyes",
            "Fried alpaca pick",
            "Fried alpaca fingers",
            "Fried alpaca hair",
            "Fried alpaca nose",
            "Fried alpaca mouth"
    };

    public Publisher<Recipe> publisher;

    private boolean selected;

    int id;
    private String name;

    public JSONSourceList<Ingredient> getIngredients() {
        return ingredients;
    }

    private JSONSourceList<Ingredient> ingredients;

    public String getDescription() {
        return description;
    }

    private String description;

    public int getTime() {
        return time;
    }

    private int time;

    public Recipe() {
        publisher = new Publisher<Recipe>(this);
        selected = false;
        ingredients = new JSONSourceList<Ingredient>();
    }

    @Override
    public void updateFromJSON(JsonElement json) {
        JsonObject jsonObject = (JsonObject) json;
        id = jsonObject.get("id").getAsInt();
        name = jsonObject.get("name").getAsString();
        ingredients.updateFromJSON(json);
        description = jsonObject.get("description").getAsString();
        publisher.publishWithCode(PublishCode.RECIPE_UPDATED);
        time = jsonObject.get("time").getAsInt();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }
}
