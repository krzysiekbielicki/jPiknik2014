package com.example.dagger.module;

import com.example.MainActivity;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
        injects = {
                MainActivity.class,
                FirstFragment.class,
                SecondFragment.class
        },
        complete = false,
        library = true
)
public class OttoModule {

    @Singleton
    @Provides
    public Bus provideBus() {
        return new Bus();
    }
}
