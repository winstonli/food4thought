package com.food4thought.food4thought;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicole on 29/08/2014.
 */
public class GridViewAdapter extends BaseAdapter {

    private static final int[][] iconIds = {
            {
                    R.drawable.icon_fleece_red,
                    R.drawable.icon_fleece_babypink,
                    R.drawable.icon_fleece_yellow,
                    R.drawable.icon_fleece_limegreen,
                    R.drawable.icon_fleece_forestgreen,
                    R.drawable.icon_fleece_lightblue,
                    R.drawable.icon_fleece_blue,
                    R.drawable.icon_fleece_purple

            },
            {
                    R.drawable.icon_eyes_dot,
                    R.drawable.icon_eyes_dotlashes,
                    R.drawable.icon_eyes_happyclosed,
                    R.drawable.icon_eyes_oval,
                    R.drawable.icon_eyes_sleepyclosed,
                    R.drawable.icon_eyes_slit,
                    R.drawable.icon_eyes_squee
            },
            {
                    R.drawable.icon_eyebrows_neutral,
                    R.drawable.icon_eyebrows_angry,
                    R.drawable.icon_eyebrows_sad,
                    R.drawable.icon_eyebrows_bushy,
                    R.drawable.icon_blank
            },
            {
                    R.drawable.icon_mouth_neutral,
                    R.drawable.icon_mouth_happy,
                    R.drawable.icon_mouth_superhappy,
                    R.drawable.icon_mouth_sad,
                    R.drawable.icon_mouth_openfrown,
                    R.drawable.icon_mouth_surprised
            },
            {
                    R.drawable.icon_head_bow,
                    R.drawable.icon_head_flowercrown,
                    R.drawable.icon_head_bobblehat,
                    R.drawable.icon_head_poop,
                    R.drawable.icon_head_lightningscar,
                    R.drawable.icon_blank
            },
            {
                    R.drawable.icon_blank
            },
            {

            }

    };

    private List<Drawable[]> pages;

    private int currentPage;

    private Context context;
    private AlpacaMakerBottomViewDelegate delegate;

    public GridViewAdapter(Context context) {
        this.context = context;
        currentPage = 0;
        loadIcons();
    }

    @Override
    public int getCount() {
        return pages.get(currentPage).length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView recycledView = (ImageView) convertView;
        if (recycledView == null) {
            recycledView = new ImageView(context);
        }
        final int page = currentPage;
        final int index = position;
        recycledView.setImageDrawable(getDrawableOnPageAtIndex(page, index));
        recycledView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.iconPressedOnPageAtIndex(page, index);
                }
            }
        });
        return recycledView;

    }

    private Drawable getDrawableOnPageAtIndex(int page, int index) {
        return pages.get(page)[index];
    }

    private void loadIcons() {
        pages = new ArrayList<Drawable[]>(iconIds.length);
        for (int i = 0; i < iconIds.length; i++) {
            final int pageLength = iconIds[i].length;
            Drawable[] page = new Drawable[pageLength];
            pages.add(i, page);
            for (int pageNo = 0; pageNo < pageLength; pageNo++) {
                page[pageNo] = context.getResources().getDrawable(iconIds[i][pageNo]);
            }
        }

    }

    public void setDelegate(AlpacaMakerBottomViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void showPage(int page) {
        currentPage = page;

    }

}
