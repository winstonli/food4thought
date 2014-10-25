package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.Publisher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedIngredients {

    public Publisher<SuggestedIngredients> publisher;

    private List<Ingredient> ingredients;

    public SuggestedIngredients() {
        publisher = new Publisher<SuggestedIngredients>(this);
        ingredients = new ArrayList<Ingredient>();
    }

}
