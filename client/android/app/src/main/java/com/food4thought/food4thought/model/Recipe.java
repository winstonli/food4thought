package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class Recipe {

    public Publisher<Recipe> publisher;

    private boolean selected;

    public Recipe() {
        publisher = new Publisher<Recipe>(this);
        selected = false;
    }

}
