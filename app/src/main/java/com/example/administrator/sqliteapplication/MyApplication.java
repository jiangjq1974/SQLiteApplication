package com.example.administrator.sqliteapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by lsx on 2016/7/30.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
