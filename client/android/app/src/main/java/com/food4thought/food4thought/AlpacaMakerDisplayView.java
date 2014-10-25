package com.food4thought.food4thought;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by Nicole on 29/08/2014.
 */
public class AlpacaMakerDisplayView extends ImageView {

    private final Alpaca alpaca;

    public AlpacaMakerDisplayView(Context context) {
        super(context);
        alpaca = new Alpaca(context.getResources());
        setImageDrawable(alpaca.reset());
        setDrawingCacheEnabled(true);
    }

    public void updateViewForPageAtIndex(int page, int index) {
        setImageDrawable(alpaca.updateForPageAtIndex(page, index));
        buildDrawingCache();

    }

    public void randomise() {
        setImageDrawable(alpaca.random());
        buildDrawingCache();
    }

    public Uri saveToGallery() {
        Bitmap bitmap = getDrawingCache();
        ContentValues contentValues = new ContentValues();
        long now = new Date().getTime() / 1000;
        contentValues.put(MediaStore.Images.Media.DATE_ADDED, now);
        contentValues.put(MediaStore.Images.Media.DATE_TAKEN, now);
        contentValues.put(MediaStore.Images.Media.DATE_MODIFIED, now);
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/png");

        ContentResolver contentResolver = getContext().getContentResolver();
        Uri path = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream stream = contentResolver.openOutputStream(path);
            bitmap.setHasAlpha(true);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.flush();
            stream.close();
            Toast.makeText(getContext(), "Alpaca saved. :)", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getContext(), "Alpaca save was unsuccessful. :(", Toast.LENGTH_SHORT).show();
        }
        return path;
    }

    public void sendToEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("application/image");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "An Alpaca Just For You");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "An alpaca from Alpaca Maker");
        emailIntent.putExtra(Intent.EXTRA_STREAM, saveToGallery());
        getContext().startActivity(Intent.createChooser(emailIntent, "Send email"));


    }
}
