package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedRecipes implements JSONSource {

    public Publisher<SuggestedRecipes> publisher;

    private JSONSourceList<Recipe> recipes;

    public SuggestedRecipes() {
        publisher = new Publisher<SuggestedRecipes>(this);
        recipes = new JSONSourceList<Recipe>();
        recipes.add(new Recipe());
    }

    @Override
    public void updateFromJSON() {
        recipes.updateFromJSON();
        publisher.publishWithCode(PublishCode.SUGGESTED_RECIPES_UPDATED);
    }

}
