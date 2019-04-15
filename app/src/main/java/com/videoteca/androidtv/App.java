package com.videoteca.androidtv;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.marcinorlowski.fonty.Fonty;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends MultiDexApplication {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();

        //---- Base de datos

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        //---- Loggers

        Logger.addLogAdapter(new AndroidLogAdapter());

        //----Fuentes

        Fonty.context(this)
                .regularTypeface("default.otf")
                .boldTypeface("bold.otf")
                .done();

    }

    public static Context getAppContext() {
        return context;
    }

}
