package com.example.dagger.module;

import com.example.BarcodeScanner;
import com.example.MainActivity;
import com.example.fragement.FirstFragment;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
        injects = {
                MainActivity.class,
                FirstFragment.class
        },
        complete = false,
        library = true
)
public class BarcodeModule {

    @Singleton
    @Provides
    public BarcodeScanner provideBarcodeScanner() {
        return new BarcodeScanner();
    }
}
