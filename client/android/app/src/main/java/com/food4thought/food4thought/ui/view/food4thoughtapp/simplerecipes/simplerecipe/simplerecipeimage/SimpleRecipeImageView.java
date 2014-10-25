package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipeimage;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.food4thought.food4thought.R;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeImageView extends ImageView {
    public SimpleRecipeImageView(Context context) {
        super(context);
        setBackgroundColor(Color.DKGRAY);
        setImageDrawable(getResources().getDrawable(R.drawable.base));
    }
}
