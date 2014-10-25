package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption.IngredientOptionView;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionsView extends LinearLayout {

    private IngredientOptionView ingredientOptionView;

    public IngredientOptionsView(Context context) {
        super(context);
        setBackgroundColor(Color.GRAY);

        ingredientOptionView = new IngredientOptionView(context);
        addView(ingredientOptionView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ingredientOptionView.setLayoutParams(new LayoutParams(right, (int) (1 * bottom)));
    }

}
