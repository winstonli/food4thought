package com.food4thought.food4thought.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.GridView;

import com.food4thought.food4thought.R;

/**
 * Created by Nicole on 29/08/2014.
 */

public class AlpacaMakerBottomView extends GridView {

    private final GridViewAdapter adapter;

    private static final int[] themeIds = {

            R.drawable.school_bottomview,
            R.drawable.space_bottomview

    };
    private Drawable[] theme;
    private int themeIndex = 0;

    public AlpacaMakerBottomView(Context context) {
        super(context);
        loadTheme();
        setBackground(theme[themeIndex]);
        setPaddingRelative(10, 10, 10, 10);
        setNumColumns(AUTO_FIT);
        adapter = new GridViewAdapter(context);
        setAdapter(adapter);


    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setColumnWidth(right/5);


    }

    public void setDelegate(AlpacaMakerBottomViewDelegate delegate) {
        adapter.setDelegate(delegate);
    }


    public void showPage(int index) {
        adapter.showPage(index);
        invalidateViews();

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
