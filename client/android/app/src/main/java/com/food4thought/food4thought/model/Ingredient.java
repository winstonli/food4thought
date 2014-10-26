package com.food4thought.food4thought.model;

import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Publisher;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
            "Alpaca pick",
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
    public void updateFromJSON(JsonElement json) {
        JsonObject jsonObject = (JsonObject) json;
        id = jsonObject.get("id").getAsInt();
        name = jsonObject.get("name").getAsString();
        publisher.publishWithCode(PublishCode.INGREDIENT_UPDATED);
    }

    public String getName() {
        return name;
    }

    public int getId() {return id; }

    public void setSelected(boolean selected) {
        this.selected = selected;
        publisher.publishWithCode(PublishCode.INGREDIENT_SELECTED_UPDATED);
    }

    public boolean isSelected() {
        return selected;
    }

    public void invertSelected() {
        setSelected(!selected);
    }
}
