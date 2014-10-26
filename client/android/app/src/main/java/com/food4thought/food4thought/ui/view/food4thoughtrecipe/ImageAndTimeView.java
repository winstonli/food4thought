package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeimage.RecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.time.TimeView;

/**
 * Created by Roxy on 26/10/14.
 */
public class ImageAndTimeView extends LinearLayout {

    private RecipeImageView recipeImageView;
    private TextView timeView;

    public ImageAndTimeView(Context context) {
        super(context);
        recipeImageView = new RecipeImageView(context);
        timeView = new TextView(context);
        setOrientation(VERTICAL);
        addView(recipeImageView);
        addView(timeView);
        recipeImageView.setBackgroundColor(Color.CYAN);
        timeView.setBackgroundColor(Color.RED);
        recipeImageView.setImageDrawable(getResources().getDrawable(R.drawable.base));
        timeView.setText("60 Minutes");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeImageView.setLayoutParams(new LayoutParams(right, right));
        timeView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));

    }

    public void setRecipeImageView(String imgURL) {

    }

    public void setTimeView(int time) {
        timeView.setText(time + " minutes");
    }
}
