package com.example.transaction;

import com.squareup.otto.Bus;

public class PayUAccountTransactionPerformer extends AccountTransactionPerformer {
    public PayUAccountTransactionPerformer(Bus bus) {
        super(bus);
    }

    @Override
    public void transfer(double amount) {
        bus.post(new TransactionPerformedEvent(TransactionPerformedEvent.Status.SUCCESS, amount));
    }
}
