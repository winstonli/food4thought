package com.food4thought.food4thought;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/**
 * Created by Nicole on 24/08/2014.
 */
public class Alpaca {

    private Resources resources;

    private Drawable base;

    private static final int[] fleeceIds = {

            R.drawable.fleece_red,
            R.drawable.fleece_babypink,
            R.drawable.fleece_yellow,
            R.drawable.fleece_limegreen,
            R.drawable.fleece_forestgreen,
            R.drawable.fleece_lightblue,
            R.drawable.fleece_blue,
            R.drawable.fleece_purple


    };
    private Drawable[] fleece;
    private int fleeceIndex;

    private static final int[] eyesIds = {

            R.drawable.eyes_dot,
            R.drawable.eyes_dotlashes,
            R.drawable.eyes_happyclosed,
            R.drawable.eyes_oval,
            R.drawable.eyes_sleepyclosed,
            R.drawable.eyes_slit,
            R.drawable.eyes_squee

    };
    private Drawable[] eyes;
    private int eyesIndex;

    private static final int[] eyebrowsIds = {
            R.drawable.eyebrows_neutral,
            R.drawable.eyebrows_angry,
            R.drawable.eyebrows_sad,
            R.drawable.eyebrows_bushy,
            R.drawable.blank
    };
    private Drawable[] eyebrows;
    private int eyebrowsIndex;

    private static final int[] mouthIds = {

            R.drawable.mouth_neutral,
            R.drawable.mouth_happy,
            R.drawable.mouth_superhappy,
            R.drawable.mouth_sad,
            R.drawable.mouth_openfrown,
            R.drawable.mouth_surprised
    };
    private Drawable[] mouth;
    private int mouthIndex;

    private static final int[] headIds = {
            R.drawable.head_bow,
            R.drawable.head_flowercrown,
            R.drawable.head_bobblehat,
            R.drawable.head_poop,
            R.drawable.head_lightningscar,
            R.drawable.blank
    };
    private Drawable[] head;
    private int headIndex;

    private static final int[] neckIds = {
            R.drawable.blank
    };
    private Drawable[] neck;
    private int neckIndex;

    public Alpaca(Resources resources) {
        this.resources = resources;
        resetIndices();
        loadBackground();
        loadEyes();
        loadEyebrows();
        loadFleece();
        loadMouth();
        loadHead();
        loadNeck();

    }

    public Drawable reset() {
        resetIndices();
        return make();
    }

    public Drawable random() {
        randomiseIndices();
        return make();
    }

    private void randomiseIndices() {
        eyebrowsIndex = (int) (Math.random() * eyebrowsIds.length);
        eyesIndex = (int) (Math.random() * eyesIds.length);
        fleeceIndex = (int) (Math.random() * fleeceIds.length);
        mouthIndex = (int) (Math.random() * mouthIds.length);
        headIndex = (int) (Math.random() * headIds.length);
        neckIndex = (int) (Math.random() * neckIds.length);
    }


    private void resetIndices() {
        eyebrowsIndex = 0;
        eyesIndex = 0;
        fleeceIndex = 0;
        mouthIndex = 0;
        headIndex = 0;
        neckIndex = 0;
    }

    private void loadBackground() {
        base = resources.getDrawable(R.drawable.base);
    }

    private void loadFleece() {
        int length = fleeceIds.length;
        fleece = new Drawable[length];
        for (int i = 0; i < length; i++) {
            fleece[i] = resources.getDrawable(fleeceIds[i]);
        }

    }

    private void loadEyes() {
        int length = eyesIds.length;
        eyes = new Drawable[length];
        for (int i = 0; i < length; i++) {
            eyes[i] = resources.getDrawable(eyesIds[i]);
        }

    }

    private void loadEyebrows() {
        int length = eyebrowsIds.length;
        eyebrows = new Drawable[length];
        for (int i = 0; i < length; i++) {
            eyebrows[i] = resources.getDrawable(eyebrowsIds[i]);
        }

    }

    private void loadMouth() {
        int length = mouthIds.length;
        mouth = new Drawable[length];
        for (int i = 0; i < length; i++) {
            mouth[i] = resources.getDrawable(mouthIds[i]);
        }

    }

    private void loadHead() {
        int length = headIds.length;
        head = new Drawable[length];
        for (int i = 0; i < length; i++) {
            head[i] = resources.getDrawable(headIds[i]);
        }

    }

    private void loadNeck() {
        int length = neckIds.length;
        neck = new Drawable[length];
        for (int i = 0; i < length; i++) {
            neck[i] = resources.getDrawable(neckIds[i]);
        }

    }


    private Drawable getCurrentFleece() {
        return this.fleece[fleeceIndex];
    }

    private Drawable getCurrentEyes() {
        return eyes[eyesIndex];
    }

    private Drawable getCurrentEyebrows() {
        return eyebrows[eyebrowsIndex];
    }

    private Drawable getCurrentMouth() {
        return this.mouth[mouthIndex];
    }

    private Drawable getCurrentHead() {
        return this.head[headIndex];
    }

    private Drawable getCurrentNeck() {
        return this.neck[neckIndex];
    }

    private Drawable make() {
        Drawable[] drawables = {
                base,
                getCurrentFleece(),
                getCurrentEyes(),
                getCurrentEyebrows(),
                getCurrentMouth(),
                getCurrentHead(),
                getCurrentNeck()

        };

        return new LayerDrawable(drawables);

    }

    public Drawable updateForPageAtIndex(int page, int index) {
        switch (page) {
            case 0:
                fleeceIndex = index;
                break;
            case 1:
                eyesIndex = index;
                break;
            case 2:
                eyebrowsIndex = index;
                break;
            case 3:
                mouthIndex = index;
                break;
            case 4:
                headIndex = index;
                break;
            case 5:
                neckIndex = index;
                break;
            case 6:
                break;
            default:
                break;
        }
        return make();
    }
}
