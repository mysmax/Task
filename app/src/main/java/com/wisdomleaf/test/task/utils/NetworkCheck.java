package com.wisdomleaf.test.task.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by chethan on 30-12-2015.
 */
public class NetworkCheck {
    boolean isConnected;
    Context context;

    public NetworkCheck(Context context) {
        this.context = context;
    }

    public boolean onReceive() {
        ConnectivityManager conn = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            // Network signal is up.
            isConnected = true;
        } else {
            // Network signal is down.
            isConnected = false;
        }
        return isConnected;
    }
}
