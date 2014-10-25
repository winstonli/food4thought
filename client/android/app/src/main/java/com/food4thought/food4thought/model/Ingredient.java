package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;

/**
 * Created by Roxy on 25/10/14.
 */
public class Ingredient implements JSONSource {

    private static String[] names = {
            "Alpaca Meat",
            "Alpaca Feet",
            "Alpaca Hands",
            "Alpaca legs",
            "Alpaca head",
            "Alpaca eyes",
            "Alpaca dick",
            "Alpaca fingers",
            "Alpaca hair",
            "Alpaca nose",
            "Alpaca mouth"
    };

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
        System.exit(0);

        id = (int) (500 * Math.random());
        name = names[(int) (names.length * Math.random())];
        publisher.publishWithCode(PublishCode.INGREDIENT_UPDATED);
    }

    public String getName() {
        return name;
    }
}
