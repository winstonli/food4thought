package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.SimpleRecipeView;

import java.util.ArrayList;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipesView extends LinearLayout {

    private SimpleRecipeView simpleRecipeView;
    private HorizontalScrollView scrollView;
    private LinearLayout recipeList;

    private ArrayList<SimpleRecipeView> recipes = new ArrayList<SimpleRecipeView>();

    public SimpleRecipesView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);

        setBackgroundColor(Color.YELLOW);
        recipes.add(new SimpleRecipeView(context));
        recipes.add(new SimpleRecipeView(context));

        scrollView = new HorizontalScrollView(context);
        addView(scrollView);
        scrollView.setBackgroundColor(Color.BLUE);
        recipeList = new LinearLayout(context);
        recipeList.setOrientation(LinearLayout.HORIZONTAL);


      // recipeList.addView(simpleRecipeView);

        scrollView.addView(recipeList);

    for (SimpleRecipeView s : recipes) {
        recipeList.addView(s);
        //s.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        scrollView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //recipeList.setLayoutParams(new ViewGroup.LayoutParams(right, bottom));
       // recipeList.setLayoutParams(new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
    }

}
