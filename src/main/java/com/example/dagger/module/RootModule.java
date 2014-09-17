package com.example.dagger.module;

import dagger.Module;

@Module(
        includes = {
                OttoModule.class,
                RandomModule.class,
                TransactionModule.class,
                BarcodeModule.class
        }
)
public class RootModule {

}
