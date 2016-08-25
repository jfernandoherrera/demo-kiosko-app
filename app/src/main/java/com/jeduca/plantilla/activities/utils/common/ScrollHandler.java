package com.jeduca.plantilla.activities.utils.common;

import android.content.Context;

import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

/**
 * Created by Admin on 25/08/2016.
 */
public class ScrollHandler extends DefaultScrollHandle {

    boolean scrollable;

    public ScrollHandler(Context context) {
        super(context);
    scrollable = true;
    }

    @Override
    public void setScroll(float position) {

        if (scrollable) {

            super.setScroll(position);

        }

    }

    public void setScrollable(boolean scrollable) {

        this.scrollable = scrollable;

    }

}
