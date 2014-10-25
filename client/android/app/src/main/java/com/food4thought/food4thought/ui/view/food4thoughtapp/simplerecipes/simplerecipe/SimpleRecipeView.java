package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.ingredientnumber.IngredientNumberView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipeimage.SimpleRecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipename.SimpleRecipeNameView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.timeindicator.TimeIndicatorView;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeView extends LinearLayout {

    private SimpleRecipeImageView simpleRecipeImageView;
    private TimeIndicatorView timeIndicatorView;
    private IngredientNumberView ingredientNumberView;
    private SimpleRecipeNameView simpleRecipeNameView;

    private LinearLayout imgView;
    private LinearLayout textView;

    public SimpleRecipeView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.BLACK);

        imgView = new LinearLayout(context);
        imgView.setBackgroundColor(Color.MAGENTA);
        textView = new LinearLayout(context);
        textView.setBackgroundColor(Color.YELLOW);
        addView(imgView);
        addView(textView);

        imgView.addView(new SimpleRecipeImageView(context));
TextView bob = new TextView(context);
        bob.setText("Steamed Alpaca Buns");
    textView.addView(bob);
     /*   imgView = new LinearLayout(context);
        imgView.setOrientation(LinearLayout.HORIZONTAL);
        imgView.setBackgroundColor(Color.BLUE);
        addView(imgView);
        textView = new LinearLayout(context);
        textView.setOrientation(LinearLayout.HORIZONTAL);

        //addView(textView);

        //simpleRecipeImageView = new SimpleRecipeImageView(context);
        //imgView.addView(simpleRecipeImageView);
        timeIndicatorView = new TimeIndicatorView(context);
  /*      ingredientNumberView = new IngredientNumberView(context);
        simpleRecipeNameView = new SimpleRecipeNameView(context);
        tv = new TextView(context);
        tv.setText("Slow Roasted Alpaca Steak Lasagna Fried Rice");
        addView(tv);
*/
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        imgView.setLayoutParams(new LayoutParams(right, (int) (0.70 * bottom)));
        textView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));

        /*simpleRecipeImageView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        timeIndicatorView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));
        ingredientNumberView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));
        simpleRecipeNameView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));*/
    }

}
