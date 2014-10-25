package com.food4thought.food4thought.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class JSONSourceList<T extends JSONSource> extends ArrayList<T> implements JSONSource {

    private List<T> internalList;

    public JSONSourceList() {
        internalList = new ArrayList<T>();
    }

    @Override
    public void updateFromJSON() {
        for (T t : internalList) {
            t.updateFromJSON();
        }
    }

}
