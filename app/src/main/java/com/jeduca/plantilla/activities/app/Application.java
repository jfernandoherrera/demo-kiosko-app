package com.jeduca.plantilla.activities.app;

import android.graphics.Typeface;

import com.jeduca.plantilla.activities.utils.common.AppFont;

public class Application extends android.app.Application {

    Typeface typeface;

    public void onCreate() {

        super.onCreate();

        AppFont appFont = new AppFont();

        typeface = appFont.getAppFont(this);

    }

    public Typeface getTypeface() {

        return typeface;

    }

}
