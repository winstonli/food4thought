package com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.JSONSourceList;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption.IngredientOptionView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.recipeingredient.RecipeIngredientView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeIngredientsView extends LinearLayout {

    private RecipeIngredientView recipeIngredientView;

    private ScrollView scroll;
    private LinearLayout ll;

    public RecipeIngredientsView(Context context) {
        super(context);

        setOrientation(VERTICAL);
        scroll = new ScrollView(context);
        ll = new LinearLayout(context);
        ll.setOrientation(VERTICAL);
        addView(scroll);
        scroll.addView(ll);
//        ll.addView(new IngredientOptionView(context, "jelly kid", 1));


        //recipeIngredientView = new RecipeIngredientView(context);
        //addView(recipeIngredientView);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //recipeIngredientView.setLayoutParams(new LayoutParams(right, (int) (1 * bottom)));
    }

    public void setIngredients(JSONSourceList<Ingredient> ingredients) {
        for(Ingredient i: ingredients) {
            RecipeIngredientView ingView = new RecipeIngredientView(getContext(), i.getName());
            ll.addView(ingView);
            if (Ingredient.selectedIngredients.contains(i)) {
                ingView.setTextColor(Color.GREEN);
            } else {
                ingView.setTextColor(Color.BLACK);
            }

        }
    }
}
