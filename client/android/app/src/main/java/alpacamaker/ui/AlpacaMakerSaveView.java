package alpacamaker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import alpacamaker.R;

/**
 * Created by Nicole on 30/08/2014.
 */
public class AlpacaMakerSaveView extends LinearLayout {

    private AlpacaMakerSaveViewDelegate delegate;

    private static final int[] themeIds = {

            R.drawable.school_buttonview,
            R.drawable.space_buttonview

    };
    private Drawable[] theme;
    private int themeIndex = 0;

    public AlpacaMakerSaveView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        loadTheme();
        setBackground(theme[themeIndex]);

        Button saveToGalleryButton = new Button(context);
        saveToGalleryButton.setText("Save to Gallery");
        saveToGalleryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.saveToGalleryButtonPressed();
                }
            }
        });
        addView(saveToGalleryButton);

        Button sendToEmailButton = new Button(context);
        sendToEmailButton.setText("Send to Email");
        sendToEmailButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.sendToEmailButtonPressed();
                }
            }
        });
        addView(sendToEmailButton);

    }

    public void setDelegate(AlpacaMakerSaveViewDelegate delegate) {
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
