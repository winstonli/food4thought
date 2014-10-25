package alpacamaker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

import alpacamaker.R;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerTopView extends LinearLayout {

    private AlpacaMakerDisplayView alpacaMakerDisplayView;
    private AlpacaMakerButtonView alpacaMakerButtonView;

    private static final int[] themeIds = {

            R.drawable.school_topview,
            R.drawable.space_topview

    };
    private Drawable[] theme;
    private int themeIndex = 0;


    public AlpacaMakerTopView(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        loadTheme();
        setBackground(theme[themeIndex]);

        alpacaMakerDisplayView = new AlpacaMakerDisplayView(context);
        addView(alpacaMakerDisplayView);
        alpacaMakerButtonView = new AlpacaMakerButtonView(context);
        addView(alpacaMakerButtonView);

    }

    public void setDelegate(AlpacaMakerButtonViewDelegate delegate) {
        alpacaMakerButtonView.setDelegate(delegate);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        alpacaMakerDisplayView.setLayoutParams(new LayoutParams((int) (0.7 * right), bottom));
        alpacaMakerButtonView.setLayoutParams(new LayoutParams((int) (0.3 * right), bottom));

    }

    public void updateViewForPageAtIndex(int page, int index) {
        alpacaMakerDisplayView.updateViewForPageAtIndex(page, index);
    }

    public void saveToGallery() {
        alpacaMakerDisplayView.saveToGallery();
    }

    public void sendToEmail() {
        alpacaMakerDisplayView.sendToEmail();

    }

    public void randomise() {
        alpacaMakerDisplayView.randomise();
    }

    private void loadTheme() {
        int length = themeIds.length;
        theme = new Drawable[length];
        for (int i = 0; i < length; i++) {
            theme[i] = getResources().getDrawable(themeIds[i]);
        }

    }

    public void changeTheme() {
        alpacaMakerButtonView.changeTheme();
        themeIndex++;
        themeIndex %= themeIds.length;
        setBackground(theme[themeIndex]);

    }
}
