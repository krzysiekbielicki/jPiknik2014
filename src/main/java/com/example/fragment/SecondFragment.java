package com.example.fragment;

import com.example.transaction.AccountTransactionPerformer;

import javax.inject.Inject;
import javax.inject.Named;

public class SecondFragment extends BaseFragment {

    @Inject
    @Named("wire")
    AccountTransactionPerformer wireAccountTransactionPerformer;

    @Override
    protected AccountTransactionPerformer getAccountTransactionPerformer() {
        return wireAccountTransactionPerformer;
    }
}
