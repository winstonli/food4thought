package com.food4thought.food4thought.ui;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerAppView extends LinearLayout {

    private AlpacaMakerView alpacaMakerView;
    private AlpacaMakerFooterView alpacaMakerFooterView;

    public AlpacaMakerAppView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        alpacaMakerView = new AlpacaMakerView(context);
        addView(alpacaMakerView);
        alpacaMakerFooterView = new AlpacaMakerFooterView(context);
        addView(alpacaMakerFooterView);
        alpacaMakerFooterView.setDelegate(new AlpacaMakerSaveViewDelegate() {
            @Override
            public void saveToGalleryButtonPressed() {
                alpacaMakerView.saveToGallery();
            }

            @Override
            public void sendToEmailButtonPressed() {
                alpacaMakerView.sendToEmail();

            }
        });
        alpacaMakerFooterView.setDelegate(new AlpacaMakerRandomViewDelegate() {
            @Override
            public void randomButtonPressed() {
                alpacaMakerView.randomise();
            }

            @Override
            public void themeButtonPressed() {
                alpacaMakerView.changeTheme();
                alpacaMakerFooterView.changeTheme();
            }
        });

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        alpacaMakerView.setLayoutParams(new LayoutParams(right, (int) (0.85 * bottom)));
        alpacaMakerFooterView.setLayoutParams(new LayoutParams(right, (int) (0.15 * bottom)));

    }

}
