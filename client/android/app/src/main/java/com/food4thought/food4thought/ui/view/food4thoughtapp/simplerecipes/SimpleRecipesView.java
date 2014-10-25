package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.SimpleRecipeView;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipesView extends LinearLayout {

    private SimpleRecipeView simpleRecipeView;

    public SimpleRecipesView(Context context) {
        super(context);
        setBackgroundColor(Color.CYAN);

        simpleRecipeView = new SimpleRecipeView(context);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        simpleRecipeView.setLayoutParams(new LayoutParams(right, (int) (1 * bottom)));
    }

}
