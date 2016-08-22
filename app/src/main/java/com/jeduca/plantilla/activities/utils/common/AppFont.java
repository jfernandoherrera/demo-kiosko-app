package com.jeduca.plantilla.activities.utils.common;

import android.content.Context;
import android.graphics.Typeface;

public class AppFont {


    public Typeface getAppFont(Context context){

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "century_gotic.ttf");

        return typeface;

    }

}
