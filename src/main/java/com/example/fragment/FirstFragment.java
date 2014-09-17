package com.example.fragment;

import com.example.transaction.AccountTransactionPerformer;

import javax.inject.Inject;
import javax.inject.Named;

public class FirstFragment extends BaseFragment {

    @Inject
    @Named("payu")
    AccountTransactionPerformer payuAccountTransactionPerformer;

    @Override
    protected AccountTransactionPerformer getAccountTransactionPerformer() {
        return payuAccountTransactionPerformer;
    }
}
