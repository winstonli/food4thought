package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipename;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeNameView extends TextView {

    public SimpleRecipeNameView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
        setText("Slow Roasted Alpaca Steak");
    }

}
