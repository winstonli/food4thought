package com.food4thought.food4thought.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Roxy on 25/10/14.
 */
public class JSONSourceMap<K, V extends JSONSource> extends HashMap<K, V> implements JSONSource {

    @Override
    public void updateFromJSON() {
        for (Entry<K, V> t : this.entrySet()) {
            t.getValue().updateFromJSON();
        }
    }

}
