package com.example.dagger.module;

import com.example.BarcodeScanner;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                FirstFragment.class,
                SecondFragment.class
        },
        complete = false,
        library = true
)
public class BarcodeModule {

    @Provides
    public BarcodeScanner provideBarcodeScanner() {
        return new BarcodeScanner();
    }
}
