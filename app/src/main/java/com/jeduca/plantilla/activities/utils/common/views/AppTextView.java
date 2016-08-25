package com.jeduca.plantilla.activities.utils.common.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.jeduca.plantilla.activities.app.Application;

public class AppTextView extends TextView {

    public AppTextView(Context context, AttributeSet attrs) {

        super(context, attrs);

        Typeface typeface = ((Application)context.getApplicationContext()).getTypeface();

        setTypeface(typeface);

    }
}