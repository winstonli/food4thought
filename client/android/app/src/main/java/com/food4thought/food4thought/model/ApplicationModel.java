package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class ApplicationModel implements JSONSource {

    public Publisher<ApplicationModel> publisher;

    private CuisineType cuisineType;
    private MealType mealType;
    private SuggestedIngredients suggestedIngredients;
    private SuggestedRecipes suggestedRecipes;

    public ApplicationModel() {

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

    @Override
    public void updateFromJSON() {
        suggestedIngredients.updateFromJSON();
        suggestedRecipes.updateFromJSON();
        publisher.publishWithCode(PublishCode.APPLICATION_MODEL_UPDATE);
    }

}
