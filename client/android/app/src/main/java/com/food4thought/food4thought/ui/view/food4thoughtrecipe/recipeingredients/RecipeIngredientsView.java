package com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.recipeingredient.RecipeIngredientView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeIngredientsView extends LinearLayout {

    private RecipeIngredientView recipeIngredientView;

    public RecipeIngredientsView(Context context) {
        super(context);

        setBackgroundColor(Color.DKGRAY);

        recipeIngredientView = new RecipeIngredientView(context);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeIngredientView.setLayoutParams(new LayoutParams(right, (int) (1 * bottom)));
    }

}
