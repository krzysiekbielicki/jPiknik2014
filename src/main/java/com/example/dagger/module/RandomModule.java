package com.example.dagger.module;

import com.example.fragement.FirstFragment;
import com.example.fragement.SecondFragment;
import com.example.transaction.RandomAmount;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Random;

@Module(
        injects = {
                FirstFragment.class,
                SecondFragment.class
        },
        complete = false,
        library = true
)
public class RandomModule {

    @Singleton
    @Provides
    public Random provideRandom() {
        return new Random();
    }

    @Provides
    public RandomAmount provideRandomAmount(Random random) {
        return new RandomAmount(random);
    }
}
