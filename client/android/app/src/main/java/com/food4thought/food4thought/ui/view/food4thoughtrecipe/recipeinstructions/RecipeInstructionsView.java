package com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeinstructions;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeInstructionsView extends ScrollView {

    private TextView text;

    public void setInstructions(String instructions) {
        text.setText(instructions);
    }

    public RecipeInstructionsView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        text = new TextView(context);
        text.setText("cvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weirvvvvvvng I'm already insane I wonder whether anyone will ever read this I'm not sure if you've gotten this far you're so weird");
        addView(text);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //text.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }
}
