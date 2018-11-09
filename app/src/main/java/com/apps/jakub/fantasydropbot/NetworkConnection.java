package com.apps.jakub.fantasydropbot;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConnection {
    Context context;

    public NetworkConnection(Context context) {
        this.context = context;
    }
    public boolean isConnectingtoInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity != null){
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if(info != null){
                for(int i =0;i<info.length;i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
