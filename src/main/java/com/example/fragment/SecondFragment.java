package com.example.fragment;

import com.example.dagger.Wire;
import com.example.transaction.AccountTransactionPerformer;

import javax.inject.Inject;

public class SecondFragment extends BaseFragment {

    @Inject
    @Wire
    AccountTransactionPerformer wireAccountTransactionPerformer;

    @Override
    protected AccountTransactionPerformer getAccountTransactionPerformer() {
        return wireAccountTransactionPerformer;
    }
}
