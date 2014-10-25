package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.friendlytext;

        import android.content.Context;
        import android.graphics.Color;
        import android.widget.TextView;

/**
 * Created by Roxy on 25/10/14.
 */
public class FriendlyTextView extends TextView{

    private String text = "What's in your kitchen? :)";

    public FriendlyTextView(Context context) {
        super(context);
        setBackgroundColor(Color.MAGENTA);
        setText(text);
    }
}
