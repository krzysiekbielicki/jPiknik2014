package com.example.fragment;

import com.example.dagger.PayU;
import com.example.transaction.AccountTransactionPerformer;

import javax.inject.Inject;

public class FirstFragment extends BaseFragment {

    @Inject
    @PayU
    AccountTransactionPerformer payuAccountTransactionPerformer;

    @Override
    protected AccountTransactionPerformer getAccountTransactionPerformer() {
        return payuAccountTransactionPerformer;
    }
}
