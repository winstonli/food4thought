package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionView extends Button {

    //public static final int FUD_ID = 1;

    private final int fudId;

   /* public IngredientOptionView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
    }*/


    public IngredientOptionView(Context context, String fudName, int fudId) {
        super(context);
        setText(fudName);
        this.fudId = fudId;
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public int getFudId(){
        return fudId;
    }

    public String getFudName() {
        return getText().toString();
    }

}
