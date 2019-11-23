package com.example.todaywallet.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class Alert {
    public static Context context;

    public static void build(Context context){
        Alert.context = context;
    }

    public static void makeText(String s){
        try {
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("ALERT_EXCEPTION",e.toString());
        }
    }

    public static void terminate(){
        context = null;
    }
}
