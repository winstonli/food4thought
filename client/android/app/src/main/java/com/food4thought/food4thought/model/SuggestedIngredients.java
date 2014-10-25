package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

import java.util.ArrayList;
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
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
        ingredients.add(new Ingredient());
    }

    @Override
    public void updateFromJSON() {
        ingredients.updateFromJSON();
        publisher.publishWithCode(PublishCode.SUGGESTED_INGREDIENTS_UPDATED);
    }

}
