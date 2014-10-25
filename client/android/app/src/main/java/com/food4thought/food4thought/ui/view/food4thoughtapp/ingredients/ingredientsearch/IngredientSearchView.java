package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch.ingredientsearchbutton.IngredientSearchButtonView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientsearch.ingredientsearchinput.IngredientSearchInputView;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientSearchView extends LinearLayout {

    private IngredientSearchInputView ingredientSearchInputView;
    private IngredientSearchButtonView ingredientSearchButtonView;

    public IngredientSearchView(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        setBackgroundColor(Color.DKGRAY);

        ingredientSearchInputView = new IngredientSearchInputView(context);
        addView(ingredientSearchInputView);
        ingredientSearchButtonView = new IngredientSearchButtonView(context);
        addView(ingredientSearchButtonView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ingredientSearchInputView.setLayoutParams(new LayoutParams((int) (right * 0.70), bottom));
        ingredientSearchButtonView.setLayoutParams(new LayoutParams((int) (right * 0.30), bottom));
    }

}
