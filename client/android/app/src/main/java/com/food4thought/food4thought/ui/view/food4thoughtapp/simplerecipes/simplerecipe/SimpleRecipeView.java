package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.ingredientnumber.IngredientNumberView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipeimage.SimpleRecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipename.SimpleRecipeNameView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.timeindicator.TimeIndicatorView;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeView extends LinearLayout {

    private SimpleRecipeImageView simpleRecipeImageView;
    private TimeIndicatorView timeIndicatorView;
    private IngredientNumberView ingredientNumberView;
    private SimpleRecipeNameView simpleRecipeNameView;

    public SimpleRecipeView(Context context) {
        super(context);

        setBackgroundColor(Color.YELLOW);

        simpleRecipeImageView = new SimpleRecipeImageView(context);
        timeIndicatorView = new TimeIndicatorView(context);
        ingredientNumberView = new IngredientNumberView(context);
        simpleRecipeNameView = new SimpleRecipeNameView(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        simpleRecipeImageView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        timeIndicatorView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));
        ingredientNumberView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        simpleRecipeNameView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));
    }

}
