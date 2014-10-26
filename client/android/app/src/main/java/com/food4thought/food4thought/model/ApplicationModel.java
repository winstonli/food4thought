package com.food4thought.food4thought.model;

import android.util.Log;

import com.food4thought.api.FFTHandler;
import com.food4thought.api.FoodForThoughtAPI;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.LinkedList;

/**
 * Created by Roxy on 25/10/14.
 */
public class ApplicationModel implements JSONSource {

    public static ApplicationModel mainModel = new ApplicationModel();

    public Publisher<ApplicationModel> publisher;

    private CuisineType cuisineType;
    private MealType mealType;
    private SuggestedIngredients suggestedIngredients;
    private SuggestedRecipes suggestedRecipes;

    public ApplicationModel() {

        publisher = new Publisher<ApplicationModel>(this);
        cuisineType = CuisineType.BRITISH;
        mealType = MealType.BREAKFAST;
        suggestedIngredients = new SuggestedIngredients();
        suggestedRecipes = new SuggestedRecipes();

    }

    public SuggestedIngredients getSuggestedIngredients() {
        return suggestedIngredients;
    }

    public SuggestedRecipes getSuggestedRecipes() {
        return suggestedRecipes;
    }

    public void requestState() {
        FoodForThoughtAPI.getState(new FFTHandler() {
            @Override
            public void jsonReceived(JsonElement json) {
                updateFromJSON(json);
            }

            @Override
            public void failed() {
                Log.wtf("miaow", "Json failed");
            }
        }, suggestedIngredients.getIDs(), "Breakfast", "British", "");
    }

    @Override
    public void updateFromJSON(JsonElement json) {
        JsonObject jsonObject = (JsonObject) json;
        suggestedIngredients.updateFromJSON(jsonObject.get("suggested_ingredients"));
        suggestedRecipes.updateFromJSON(jsonObject.get("suggested_recipes"));
        publisher.publishWithCode(PublishCode.APPLICATION_MODEL_UPDATE);
    }

}
