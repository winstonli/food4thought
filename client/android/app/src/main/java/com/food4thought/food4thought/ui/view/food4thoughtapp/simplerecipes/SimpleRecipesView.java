package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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

    private int recipeSize = 0;

    private SimpleRecipeView s1;
    private SimpleRecipeView s2;

    private ArrayList<SimpleRecipeView> recipes = new ArrayList<SimpleRecipeView>();

    public SimpleRecipesView(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);

        setBackgroundColor(Color.YELLOW);

        s1 = new SimpleRecipeView(context);
        s2 = new SimpleRecipeView(context);

        addView(s1);
        addView(s2);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        s1.setLayoutParams(new LayoutParams((int) (right * 0.5), ViewGroup.LayoutParams.MATCH_PARENT));
        s2.setLayoutParams(new LayoutParams((int) (right * 0.5), ViewGroup.LayoutParams.MATCH_PARENT));

    }







}
