package com.food4thought.food4thought.ui.view.food4thoughtapp;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.IngredientsView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.SimpleRecipesView;

/**
 * Created by Roxy on 25/10/14.
 */
public class Food4ThoughtAppView extends LinearLayout {

    private IngredientsView ingredientsView;
    private SimpleRecipesView simpleRecipesView;

    public Food4ThoughtAppView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.BLUE);

        ingredientsView = new IngredientsView(context);
        addView(ingredientsView);
        simpleRecipesView = new SimpleRecipesView(context);
        addView(simpleRecipesView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        simpleRecipesView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));

    }

}
