package com.food4thought.food4thought.model;

/**
 * Created by Roxy on 25/10/14.
 */
public class ApplicationModel {

    private Country country;
    private MealType mealType;
    private SuggestedIngredients suggestedIngredients;
    private SuggestedRecipes suggestedRecipes;

    public ApplicationModel() {

        country = new Country();
        mealType = MealType.BREAKFAST;
        suggestedIngredients = new SuggestedIngredients();
        suggestedRecipes = new SuggestedRecipes();

    }

    public void updateFromJSON() {

    }









}
