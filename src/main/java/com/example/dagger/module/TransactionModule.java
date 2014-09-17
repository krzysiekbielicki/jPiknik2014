package com.example.dagger.module;

import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.transaction.AccountTransactionPerformer;
import com.example.transaction.PayUAccountTransactionPerformer;
import com.example.transaction.WireAccountTransactionPerformer;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module(
        injects = {
                FirstFragment.class,
                SecondFragment.class
        },
        complete = false,
        library = true
)
public class TransactionModule {

    @Provides
    @Named("payu")
    public AccountTransactionPerformer providePayUAccountTransactionPerformer(Bus bus) {
        return new PayUAccountTransactionPerformer(bus);
    }

    @Provides
    @Named("wire")
    public AccountTransactionPerformer provideWireAccountTransactionPerformer(Bus bus) {
        return new WireAccountTransactionPerformer(bus);
    }
}
