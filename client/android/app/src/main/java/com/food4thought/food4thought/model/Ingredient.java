package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class Ingredient {

    public Publisher<Ingredient> publisher;

    private boolean selected;

    public Ingredient() {
        publisher = new Publisher<Ingredient>(this);
        selected = false;
    }

}
