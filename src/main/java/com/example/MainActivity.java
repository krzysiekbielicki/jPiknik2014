package com.example;

import android.app.Activity;
import android.os.Bundle;
import com.example.dagger.Injector;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    Bus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Injector.inject(this);
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}

