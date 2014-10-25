package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe;

import android.content.Context;
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
    }

}
