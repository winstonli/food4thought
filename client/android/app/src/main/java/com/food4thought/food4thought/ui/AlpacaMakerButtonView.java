package com.food4thought.food4thought.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.food4thought.food4thought.R;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerButtonView extends LinearLayout {

    private static final String[] BUTTON_STRINGS = {
            "Fleece",
            "Eyes",
            "Eyebrows",
            "Mouth",
            "Head",
            "Neck",
            "Speech"

    };

    private AlpacaMakerButtonViewDelegate delegate;

    private static final int[] themeIds = {

            R.drawable.school_buttonview,
            R.drawable.space_buttonview

    };
    private Drawable[] theme;
    private int themeIndex = 0;

    private Button[] buttons;

    public AlpacaMakerButtonView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        loadTheme();
        setBackground(theme[themeIndex]);

        int numberOfButtons = BUTTON_STRINGS.length;
        buttons = new Button[numberOfButtons];

        for (int i = 0; i < numberOfButtons; i++) {
            final int currentIndex = i;
            Button button = new Button(context);
            button.setText(BUTTON_STRINGS[i]);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (delegate != null) {
                        delegate.buttonPressedAtIndex(currentIndex);
                    }
                }
            });
            addView(button);
            buttons[i] = button;
        }


    }

    public void setDelegate(AlpacaMakerButtonViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void loadTheme() {
        int length = themeIds.length;
        theme = new Drawable[length];
        for (int i = 0; i < length; i++) {
            theme[i] = getResources().getDrawable(themeIds[i]);
        }

    }

    public void changeTheme() {
        themeIndex++;
        themeIndex %= themeIds.length;
        setBackground(theme[themeIndex]);

    }
}
