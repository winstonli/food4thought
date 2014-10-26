package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.food4thought.food4thought.AlpacaMaker;
import com.food4thought.food4thought.R;
import com.food4thought.food4thought.RecipeActivity;
import com.food4thought.food4thought.model.Recipe;
import com.food4thought.food4thought.model.SuggestedRecipes;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtapp.Food4ThoughtAppView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.SimpleRecipeView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.RecipeView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipesView extends LinearLayout implements Subscriber<SuggestedRecipes> {

    private int recipeSize = 0;

    private SimpleRecipeView s1;
    private SimpleRecipeView s2;

    private ArrayList<SimpleRecipeView> recipes = new ArrayList<SimpleRecipeView>();
    private SuggestedRecipes suggestedRecipes;

    public SimpleRecipesView(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        s1 = new SimpleRecipeView(context, getResources().getDrawable(R.drawable.base));
        s2 = new SimpleRecipeView(context, getResources().getDrawable(R.drawable.base));



        addView(s1);
        addView(s2);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        s1.setLayoutParams(new LayoutParams((int) (right * 0.5), ViewGroup.LayoutParams.MATCH_PARENT));
        s2.setLayoutParams(new LayoutParams((int) (right * 0.5), ViewGroup.LayoutParams.MATCH_PARENT));

    }

    public void setSuggestedRecipes(SuggestedRecipes suggestedRecipes) {
        if (this.suggestedRecipes != null) {
            this.suggestedRecipes.publisher.unsubscribe(this);
        }
        this.suggestedRecipes = suggestedRecipes;
        suggestedRecipes.publisher.subscribe(this);
    }

    @Override
    public void update(PublishCode code, SuggestedRecipes publisher) {
        Log.wtf("miaow", "suggested recipes: " + publisher.getRecipes());
        List<Recipe> recipes = publisher.getRecipeList();

        if (recipes.size() > 0) {
            Recipe recipe1 = recipes.get(0);
            Log.wtf("miaow", "setting recipe to: " + recipe1);
            s1.setRecipe(recipe1);
            Recipe recipe2 = recipes.get(1);
            s2.setRecipe(recipe2);
        }
    }
}
