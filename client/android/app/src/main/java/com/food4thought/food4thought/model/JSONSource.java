package com.food4thought.food4thought.model;

import com.google.gson.JsonElement;

/**
 * Created by Roxy on 25/10/14.
 */
public interface JSONSource {

    public void updateFromJSON(JsonElement json);

}
