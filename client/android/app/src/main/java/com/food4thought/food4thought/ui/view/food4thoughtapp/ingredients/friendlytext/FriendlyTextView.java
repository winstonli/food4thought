package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.friendlytext;

        import android.content.Context;
        import android.graphics.Color;
        import android.graphics.Typeface;
        import android.util.TypedValue;
        import android.view.Gravity;
        import android.widget.TextView;

/**
 * Created by Roxy on 25/10/14.
 */
public class FriendlyTextView extends TextView{

    private String text = "What's in your kitchen?";

    public FriendlyTextView(Context context) {
        super(context);
        setGravity(Gravity.CENTER);
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        setTypeface(myTypeface);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        setText(text);
    }
}
