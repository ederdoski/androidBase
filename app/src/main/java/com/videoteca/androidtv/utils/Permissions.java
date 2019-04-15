package com.videoteca.androidtv.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.videoteca.androidtv.interfaces.PermissionsResponse;


/**
 * Created by ederdoski on 10/04/2018.
 */

public class Permissions {

    public static boolean checkPermisionStatus(Activity act, String permission){
        return ActivityCompat.checkSelfPermission(act, permission) == PackageManager.PERMISSION_GRANTED;
    }


    public static void getSimplePermission(Activity act, String permision, final PermissionsResponse callback){
        Dexter.withActivity(act)
                .withPermission(permision)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        callback.onSuccess();
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                        callback.onDefuse();}
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) { token.continuePermissionRequest();}
                }).check();
    }

}
