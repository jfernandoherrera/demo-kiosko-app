package com.jeduca.plantilla.activities;


import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.jeduca.plantilla.R;
import com.jeduca.plantilla.activities.utils.common.ScrollHandler;
import com.jeduca.plantilla.activities.utils.common.views.AccordionListView;
import com.shockwave.pdfium.PdfDocument;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, AccordionListView.OnButtonPressed, AccordionListView.OnItemSelected {

    PDFView pdfView;
    AccordionListView accordionListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pdfView = (PDFView) findViewById(R.id.pdfView);

        accordionListView = (AccordionListView) findViewById(R.id.accordion);

        ArrayList<String> objects = new ArrayList<>();

        String pdf1Name = "COMUNICACIÓN EN VISITA MÉDICA";

        String pdf2Name = "VISITA MÉDICA PROFESIONAL";

        String pdf4Name = "MEDICO CIENTIFICO";

        String pdf3Name = "MERCADEO FARMACÉUTICO";

        objects.add(pdf1Name);

        objects.add(pdf2Name);

        objects.add(pdf3Name);

        objects.add(pdf4Name);

        accordionListView.setListeners( this, this);

        accordionListView.setObjects(objects);


    }

    public void loadPDF1(View view) {

        pdfView.fromAsset("config.pdf")

                .defaultPage(0)

                .onPageChange(this)

                .enableAnnotationRendering(true)

                .onLoad(this)

                .scrollHandle(new DefaultScrollHandle(this))

                .load();

    }

    public void loadPDF2(View view) {

        pdfView.fromAsset("config2.pdf")

                .defaultPage(0)

                .onPageChange(this)

                .enableAnnotationRendering(true)

                .onLoad(this)

                .scrollHandle(new DefaultScrollHandle(this))

                .load();

    }

    public void loadPDF4(View view) {

        pdfView.fromAsset("config3.pdf")

                .defaultPage(0)

                .onPageChange(this)

                .enableAnnotationRendering(true)

                .onLoad(this)

                .scrollHandle(new DefaultScrollHandle(this))

                .load();

    }

    public void loadPDF3(View view) {

        pdfView.fromAsset("config4.pdf")

                .defaultPage(0)

                .onPageChange(this)

                .enableAnnotationRendering(true)

                .onLoad(this)

                .scrollHandle(new DefaultScrollHandle(this))

                .load();

    }

    @Override
    public void loadComplete(int nbPages) {

        PdfDocument.Meta meta = pdfView.getDocumentMeta();

        accordionListView.setButtonVisibility(true);

        String TAG = "pdf";

        Log.e(TAG, "author = " + meta.getAuthor());

        Log.e(TAG, "subject = " + meta.getSubject());

        Log.e(TAG, "keywords = " + meta.getKeywords());

        Log.e(TAG, "creator = " + meta.getCreator());

        Log.e(TAG, "producer = " + meta.getProducer());

        Log.e(TAG, "creationDate = " + meta.getCreationDate());

        Log.e(TAG, "modDate = " + meta.getModDate());
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

      getSupportActionBar().setTitle("Modulos");

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onItemSelected(int position) {

        switch (position) {

            case 0:

                loadPDF1(null);

                break;

            case 1:

                loadPDF2(null);

                break;

            case 2:

                loadPDF3(null);

                break;

            case 3:

                loadPDF4(null);

                break;

            default:

                loadPDF1(null);

        }

    }

    @Override
    public void onButtonPressed() {


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus) {
            Log.d("Focus debug", "Lost focus !");

            Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            sendBroadcast(closeDialog);
        }
    }
}
