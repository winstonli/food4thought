package com.food4thought.food4thought.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.food4thought.food4thought.R;

/**
 * Created by Nicole on 30/08/2014.
 */
public class AlpacaMakerRandomView extends LinearLayout {


    private AlpacaMakerRandomViewDelegate delegate;

    private static final int[] themeIds = {

            R.drawable.school_buttonview,
            R.drawable.space_buttonview

    };
    private Drawable[] theme;
    private int themeIndex = 0;

    public AlpacaMakerRandomView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        loadTheme();
        setBackground(theme[themeIndex]);

        Button randomButton = new Button(context);
        randomButton.setText("Randomise");
        addView(randomButton);

        randomButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.randomButtonPressed();
                }
            }
        });

        final Button themeButton = new Button(context);
        themeButton.setText("Theme" + " (" + getThemeIndex() + "/" + themeIds.length + ")");
        addView(themeButton);

        themeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.themeButtonPressed();
                    themeButton.setText("Theme" + " (" + getThemeIndex() + "/" + themeIds.length + ")");
                }
            }
        });

    }

    public void setDelegate(AlpacaMakerRandomViewDelegate delegate) {
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

    public int getThemeIndex() {
        return (themeIndex + 1);
    }
}
