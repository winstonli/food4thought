package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.model.SuggestedIngredients;
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
    private SuggestedIngredients suggestedIngredients;

    public IngredientsView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);

        friendlyTextView = new FriendlyTextView(context);
        addView(friendlyTextView);
        ingredientSearchView = new IngredientSearchView(context);
//        ingredientSearchView.setGravity(Gravity.CENTER);
        addView(ingredientSearchView);
        ingredientOptionsView = new IngredientOptionsView(context);
        addView(ingredientOptionsView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        friendlyTextView.setLayoutParams(new LayoutParams(right, (int) (0.12 * bottom)));
        LayoutParams params = new LayoutParams((int) (right * 0.85), (int) (0.10 * bottom));
        params.setMargins((int) (0.075 * right), 0, 0, 0);
        ingredientSearchView.setLayoutParams(params);
        ingredientOptionsView.setLayoutParams(new LayoutParams(right, (int) (0.78 * bottom)));
    }

    public void setSuggestedIngredients(SuggestedIngredients suggestedIngredients) {
        ingredientOptionsView.setSuggestedIngredients(suggestedIngredients);
    }
}
