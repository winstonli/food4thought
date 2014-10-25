package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionView extends Button {

    public IngredientOptionView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
    }


    public IngredientOptionView(Context context, String fudName) {
        super(context);
        setText(fudName);
        //setBackgroundColor(Color.RED);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

}
