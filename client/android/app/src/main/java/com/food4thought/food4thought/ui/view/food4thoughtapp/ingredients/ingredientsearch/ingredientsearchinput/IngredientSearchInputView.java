package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch.ingredientsearchinput;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientSearchInputView extends EditText {

    public IngredientSearchInputView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
        setText("Add ingredient");
    }

}
