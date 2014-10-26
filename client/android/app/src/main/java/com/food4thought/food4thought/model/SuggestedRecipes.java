package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedRecipes implements JSONSource {

    public Publisher<SuggestedRecipes> publisher;

    private JSONSourceMap<Integer, Recipe> recipes;

    public SuggestedRecipes() {
        publisher = new Publisher<SuggestedRecipes>(this);
        recipes = new JSONSourceMap<Integer, Recipe>();
        Recipe recipe1 = new Recipe();
        recipe1.id = 0;
        recipes.put(0, recipe1);
        Recipe recipe2 = new Recipe();
        recipe2.id = 1;
        recipes.put(1, recipe2);
    }

    public JSONSourceMap<Integer, Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void updateFromJSON() {
        recipes.updateFromJSON();
        publisher.publishWithCode(PublishCode.SUGGESTED_RECIPES_UPDATED);
    }

}
