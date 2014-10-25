package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class Ingredient implements JSONSource {

    public Publisher<Ingredient> publisher;

    private boolean selected;

    private int id;
    private String name;

    public Ingredient() {
        publisher = new Publisher<Ingredient>(this);
        selected = false;
    }

    @Override
    public void updateFromJSON() {
        id = 1;
        name = "Fresh Alpaca Meat";
        publisher.publishWithCode(PublishCode.INGREDIENT_UPDATED);
    }

}
