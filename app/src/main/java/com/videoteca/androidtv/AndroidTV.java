package com.videoteca.androidtv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.videoteca.androidtv.utils.Dialogs;

import io.realm.Realm;

public class AndroidTV extends AppCompatActivity {

    protected Realm mRealm;


    @Override
    protected void onResume() {
        super.onResume();
        new Dialogs(this);
        mRealm = Realm.getDefaultInstance();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Dialogs(this);

        mRealm = Realm.getDefaultInstance();

    }


}