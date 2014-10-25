package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.Publisher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class SuggestedRecipes {

    public Publisher<SuggestedRecipes> publisher;

    private List<Recipe> recipes;

    public SuggestedRecipes() {
        publisher = new Publisher<SuggestedRecipes>(this);
        recipes = new ArrayList<Recipe>();
    }

}
