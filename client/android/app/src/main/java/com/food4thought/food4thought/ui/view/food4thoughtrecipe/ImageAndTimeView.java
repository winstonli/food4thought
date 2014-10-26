package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeimage.RecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.time.TimeView;

/**
 * Created by Roxy on 26/10/14.
 */
public class ImageAndTimeView extends LinearLayout {

    private RecipeImageView recipeImageView;
    private TimeView timeView;

    public ImageAndTimeView(Context context) {
        super(context);
        recipeImageView = new RecipeImageView(context);
        timeView = new TimeView(context);
        setOrientation(VERTICAL);
        addView(recipeImageView);
        addView(timeView);
        recipeImageView.setBackgroundColor(Color.CYAN);
        timeView.setBackgroundColor(Color.RED);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeImageView.setLayoutParams(new LayoutParams(right, right));
        timeView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));

    }


}
