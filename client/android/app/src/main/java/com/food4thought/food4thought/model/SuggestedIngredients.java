package com.food4thought.food4thought.model;

import android.util.Log;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedIngredients implements JSONSource {

    public Publisher<SuggestedIngredients> publisher;

    private JSONSourceList<Ingredient> ingredients;

    public SuggestedIngredients() {
        publisher = new Publisher<SuggestedIngredients>(this);
        ingredients = new JSONSourceList<Ingredient>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Integer> getIDs() {
        List<Integer> ids = new LinkedList<Integer>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isSelected()) {
                ids.add(ingredient.getId());
            }
        }
        Log.wtf("miaow", "Selected recipes: " + ids);
        return ids;
    }

    @Override
    public void updateFromJSON(JsonElement json) {
        Log.wtf("miaow", "ingredients recipes: " + json.toString());

        ingredients = new JSONSourceList<Ingredient>();
        for (int i = 0; i < ((JsonArray) json).size(); i++) {
            ingredients.add(new Ingredient());
        }
        ingredients.updateFromJSON(json);
        publisher.publishWithCode(PublishCode.SUGGESTED_INGREDIENTS_UPDATED);
    }

}
