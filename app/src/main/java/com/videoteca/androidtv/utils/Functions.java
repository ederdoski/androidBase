package com.videoteca.androidtv.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by Eder on 20-10-2016.
 */
public class Functions {


    //  <!-- ............... Movements between activities ................. -->


    public static void changeActivity(Context ctx, Class newActivity) {
        Intent mainIntent = new Intent().setClass(
                ctx, newActivity);
        ctx.startActivity(mainIntent);
    }

    public static void closeActivitys(Activity act, Class newClass) {
        Intent intent = new Intent(act.getApplicationContext(), newClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        act.startActivity(intent);
    }

    public static void changeActivity(Context ctx, Class newActivity, String extra) {
        Intent mainIntent = new Intent().setClass(
                ctx, newActivity);
        mainIntent.putExtra(Constants.EXTRA, extra);
        ctx.startActivity(mainIntent);
    }

    public static void changeActivity(Context ctx, Class newActivity, String extra, String extra2) {
        Intent mainIntent = new Intent().setClass(
                ctx, newActivity);
        mainIntent.putExtra(Constants.EXTRA, extra);
        mainIntent.putExtra(Constants.EXTRA2, extra2);
        ctx.startActivity(mainIntent);
    }

    public static void changeActivity(Context ctx, Class newActivity, String[] extra) {
        Intent mainIntent = new Intent().setClass(
                ctx, newActivity);
        mainIntent.putExtra(Constants.EXTRA, extra);
        ctx.startActivity(mainIntent);
    }

    public static void changeActivity(Context ctx, Class newActivity, Integer extra) {
        Intent mainIntent = new Intent().setClass(
                ctx, newActivity);
        mainIntent.putExtra(Constants.EXTRA, extra);
        ctx.startActivity(mainIntent);
    }

    public static String getIntent(Activity act, Integer position) {
        return act.getIntent().getStringArrayExtra(Constants.EXTRA)[position];
    }

    public static String getIntent(Activity act) {
        return act.getIntent().getStringExtra(Constants.EXTRA);
    }

    public static String getIntent(Activity act, String field) {
        return act.getIntent().getStringExtra(field);
    }

    public static String[] getIntentArray(Activity act) {
        return act.getIntent().getStringArrayExtra(Constants.EXTRA) ;
    }


    //  <!-- ............... Network ................. -->

    public static boolean isOnline(Context ctx){
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo    = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }


}
