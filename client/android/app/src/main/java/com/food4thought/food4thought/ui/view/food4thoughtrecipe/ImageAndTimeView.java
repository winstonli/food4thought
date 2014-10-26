package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
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
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        timeView.setTypeface(myTypeface);
        timeView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        setOrientation(VERTICAL);
        addView(recipeImageView);
        addView(timeView);
        recipeImageView.setImageDrawable(getResources().getDrawable(R.drawable.base));
        timeView.setText("60 Minutes");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeImageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        timeView.setLayoutParams(new LayoutParams(right, (int) (0.1 * bottom)));

    }

    public void setRecipeImageView(String imgURL) {

    }

    public void setTimeView(int time) {
        timeView.setText(time + " minutes");
    }
}
