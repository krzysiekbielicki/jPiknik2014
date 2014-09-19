package com.example.fragment;

import com.example.dagger.module.RootModule;
import com.example.transaction.RandomAmount;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Random;

import static org.mockito.Mockito.mock;

@Module(
        includes = RootModule.class,
        injects = {
                BaseFragmentTest.class,
                FirstFragment.class

        },
        overrides = true
)
public class RandomAmountMockModule {

    @Singleton
    @Provides
    public RandomAmount provideRandomAmount(Random random) {
        return mock(RandomAmount.class);
    }
}
