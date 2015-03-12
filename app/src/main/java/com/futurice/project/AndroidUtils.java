package com.futurice.project;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;

/**
 */
public class AndroidUtils {

    public static int getVibrantColor(Resources resources, int imageResId, int defaultColor) {
        Bitmap bmp = BitmapFactory.decodeResource(resources, imageResId);
        Palette palette = Palette.generate(bmp);
        return palette.getVibrantColor(defaultColor);
    }

}
