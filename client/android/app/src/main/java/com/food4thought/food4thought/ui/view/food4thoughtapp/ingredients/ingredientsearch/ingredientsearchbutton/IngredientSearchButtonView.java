package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch.ingredientsearchbutton;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientSearchButtonView extends Button {

    public IngredientSearchButtonView(Context context) {
        super(context);
        setBackgroundColor(Color.DKGRAY);
        setText("Search");
    }

}
