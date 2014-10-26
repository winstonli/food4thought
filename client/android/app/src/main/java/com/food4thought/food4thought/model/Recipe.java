package com.food4thought.food4thought.model;

import android.util.Log;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

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
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
    }

    @Override
    public void updateFromJSON() {
        name = names[(int) (names.length * Math.random())];
        ingredients.updateFromJSON();
        description = "Put Fried alpaca in poo";
        publisher.publishWithCode(PublishCode.RECIPE_UPDATED);
        time = 60;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }
}
