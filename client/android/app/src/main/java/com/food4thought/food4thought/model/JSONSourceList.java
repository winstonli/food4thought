package com.food4thought.food4thought.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class JSONSourceList<T extends JSONSource> extends ArrayList<T> implements JSONSource {

    @Override
    public void updateFromJSON(JsonElement json) {
        for (int i = 0; i < size(); i++) {
            get(i).updateFromJSON(((JsonArray) json).get(i));
        }
    }

}
