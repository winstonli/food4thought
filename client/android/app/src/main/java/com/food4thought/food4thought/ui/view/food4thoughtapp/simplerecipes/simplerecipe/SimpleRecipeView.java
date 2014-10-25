package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.ingredientnumber.IngredientNumberView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipeimage.SimpleRecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipename.SimpleRecipeNameView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.timeindicator.TimeIndicatorView;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeView extends RelativeLayout {

    private ImageView simpleRecipeImageView;
    private TimeIndicatorView timeIndicatorView;
    private IngredientNumberView ingredientNumberView;
    private SimpleRecipeNameView simpleRecipeNameView;


    //private LinearLayout containerView;
   // private ImageView imgView;

    //private LinearLayout imgView;
    //private LinearLayout textView;

    public SimpleRecipeView(Context context, Drawable img) {
        super(context);
        //setOrientation(LinearLayout.VERTICAL);
        setPadding(10, 10, 10, 10);

        setClickable(true);
        setGravity(Gravity.CENTER);
        simpleRecipeNameView = new SimpleRecipeNameView(context);
        simpleRecipeNameView.setText("Steamed Alpaca Buns");

        simpleRecipeImageView = new ImageView(context);
        //simpleRecipeImageView.setBackgroundColor(Color.CYAN);
        //simpleRecipeImageView.setText("Hi");
        simpleRecipeImageView.setImageDrawable(img);
        simpleRecipeImageView.setBackgroundColor(Color.BLACK);
        addView(simpleRecipeImageView);
        addView(simpleRecipeNameView);
        //setBackground(getResources().getDrawable(R.drawable.base));
        //setText("Fried Alpaca Dumplings");

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //Log.wtf("wut", left + " " + top + " " + right + " " + bottom);
        //containerView.setLayoutParams(new ViewGroup.LayoutParams(right, bottom));
        simpleRecipeImageView.setLayoutParams(new LayoutParams(right, (int) (0.80 * bottom)));
        simpleRecipeNameView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));

    }

}
