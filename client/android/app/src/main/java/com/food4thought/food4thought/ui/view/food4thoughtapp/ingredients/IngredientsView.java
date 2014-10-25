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
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.CYAN);

        friendlyTextView = new FriendlyTextView(context);
        addView(friendlyTextView);
        ingredientSearchView = new IngredientSearchView(context);
        addView(ingredientSearchView);
        ingredientOptionsView = new IngredientOptionsView(context);
        addView(ingredientOptionsView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        friendlyTextView.setLayoutParams(new LayoutParams(right, (int) (0.10 * bottom)));
        ingredientSearchView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        ingredientOptionsView.setLayoutParams(new LayoutParams(right, (int) (0.70 * bottom)));
    }
}
