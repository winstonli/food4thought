package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.JSONSourceList;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeimage.RecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.RecipeIngredientsView;

/**
 * Created by Roxy on 26/10/14.
 */
public class RecipeProfileView extends LinearLayout {

    private ImageAndTimeView imageAndTimeView;
    private RecipeIngredientsView recipeIngredientsView;

    public RecipeProfileView(Context context) {
        super(context);
        imageAndTimeView = new ImageAndTimeView(context);
        recipeIngredientsView = new RecipeIngredientsView(context);
        setOrientation(HORIZONTAL);
        addView(imageAndTimeView);
        addView(recipeIngredientsView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        imageAndTimeView.setLayoutParams(new LayoutParams((int) (0.50 * right), bottom));
        recipeIngredientsView.setLayoutParams(new LayoutParams((int) (0.50 * right), bottom));

    }

    protected void setData(String imgURL, int time, JSONSourceList<Ingredient> ingredients) {
        //set url
        imageAndTimeView.setTimeView(time);
        recipeIngredientsView.setIngredients(ingredients);
    }

}
