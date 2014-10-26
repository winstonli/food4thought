package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.food4thought.food4thought.R;

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

        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        setTypeface(myTypeface);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
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
