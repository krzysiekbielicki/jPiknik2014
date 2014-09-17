package com.example;

import android.app.Application;
import com.example.dagger.Injector;
import com.example.dagger.module.RootModule;

public class DaggerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.init(new RootModule());
    }
}
