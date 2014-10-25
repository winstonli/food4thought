package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.friendlytext.FriendlyTextView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.IngredientOptionsView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch.IngredientSearchView;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientsView extends LinearLayout {

    private FriendlyTextView friendlyTextView;
    private IngredientSearchView ingredientSearchView;
    private IngredientOptionsView ingredientOptionsView;

    public IngredientsView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
    }
}
