package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeimage.RecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.RecipeIngredientsView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeinstructions.RecipeInstructionsView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.time.TimeView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeView extends LinearLayout {

    private RecipeImageView recipeImageView;
    private TimeView timeView;
    private RecipeIngredientsView recipeIngredientsView;
    private RecipeInstructionsView recipeInstructionsView;

    public RecipeView(Context context) {
        super(context);

        setBackgroundColor(Color.MAGENTA);

        recipeImageView = new RecipeImageView(context);
        timeView = new TimeView(context);
        recipeIngredientsView = new RecipeIngredientsView(context);
        recipeInstructionsView = new RecipeInstructionsView(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeImageView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));
        timeView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        recipeIngredientsView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));
        recipeInstructionsView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
    }


}
