package com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.recipeingredient;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeIngredientView extends TextView {
    public RecipeIngredientView(Context context, String text) {
        super(context);
        setText(text);
        setBackgroundColor(Color.YELLOW);
    }
}
