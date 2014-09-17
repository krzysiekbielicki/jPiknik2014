package com.example.transaction;

import com.squareup.otto.Bus;

public abstract class AccountTransactionPerformer {

    protected final Bus bus;

    protected AccountTransactionPerformer(Bus bus) {
        this.bus = bus;
    }

    public abstract void transfer(double amount);
}
