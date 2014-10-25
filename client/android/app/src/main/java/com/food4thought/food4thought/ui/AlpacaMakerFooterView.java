package com.food4thought.food4thought.ui;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerFooterView extends LinearLayout {

    private AlpacaMakerSaveView alpacaMakerSaveView;
    private AlpacaMakerRandomView alpacaMakerRandomView;

    public AlpacaMakerFooterView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        alpacaMakerSaveView = new AlpacaMakerSaveView(context);
        addView(alpacaMakerSaveView);
        alpacaMakerRandomView = new AlpacaMakerRandomView(context);
        addView(alpacaMakerRandomView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        alpacaMakerSaveView.setLayoutParams(new LayoutParams((int) (0.5 * right), bottom));
        alpacaMakerRandomView.setLayoutParams(new LayoutParams((int) (0.5 * right), bottom));

    }

    public void setDelegate(AlpacaMakerSaveViewDelegate delegate) {
        alpacaMakerSaveView.setDelegate(delegate);
    }

    public void setDelegate(AlpacaMakerRandomViewDelegate delegate) {
        alpacaMakerRandomView.setDelegate(delegate);
    }

    public void changeTheme() {
        alpacaMakerSaveView.changeTheme();
        alpacaMakerRandomView.changeTheme();
    }
}
