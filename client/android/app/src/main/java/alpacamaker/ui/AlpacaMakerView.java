package alpacamaker.ui;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerView extends LinearLayout {

    private AlpacaMakerTopView alpacaMakerTopView;
    private AlpacaMakerBottomView alpacaMakerBottomView;

    public AlpacaMakerView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        alpacaMakerTopView = new AlpacaMakerTopView(context);
        addView(alpacaMakerTopView);
        alpacaMakerBottomView = new AlpacaMakerBottomView(context);
        addView(alpacaMakerBottomView);
        alpacaMakerTopView.setDelegate(new AlpacaMakerButtonViewDelegate() {
            @Override
            public void buttonPressedAtIndex(int index) {
                alpacaMakerBottomView.showPage(index);

            }
        });
        alpacaMakerBottomView.setDelegate(new AlpacaMakerBottomViewDelegate() {
            @Override
            public void iconPressedOnPageAtIndex(int page, int index) {
                alpacaMakerTopView.updateViewForPageAtIndex(page, index);
            }
        });

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        alpacaMakerTopView.setLayoutParams(new LayoutParams(right, (int) (0.65 * bottom)));
        alpacaMakerBottomView.setLayoutParams(new LayoutParams(right, (int) (0.35 * bottom)));

    }

    public void saveToGallery() {
        alpacaMakerTopView.saveToGallery();

    }

    public void sendToEmail() {
        alpacaMakerTopView.sendToEmail();

    }

    public void randomise() {
        alpacaMakerTopView.randomise();
    }

    public void changeTheme() {
        alpacaMakerTopView.changeTheme();
        alpacaMakerBottomView.changeTheme();
    }
}
