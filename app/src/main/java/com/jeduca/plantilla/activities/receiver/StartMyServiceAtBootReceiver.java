package com.jeduca.plantilla.activities.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jeduca.plantilla.activities.SplashActivity;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    boolean ya;

    public StartMyServiceAtBootReceiver() {

        super();

        ya = false;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()) && ! ya ) {

            ya = true;

            Intent serviceIntent = new Intent(context, SplashActivity.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(serviceIntent);

        }
    }
}