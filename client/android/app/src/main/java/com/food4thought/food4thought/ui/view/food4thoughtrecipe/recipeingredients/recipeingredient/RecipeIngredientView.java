package com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.recipeingredient;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeIngredientView extends TextView {
    public RecipeIngredientView(Context context, String text) {
        super(context);
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        setTypeface(myTypeface);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        setText(text);
    }
}
