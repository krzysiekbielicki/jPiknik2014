package com.example.transaction;

import com.squareup.otto.Bus;

public class WireAccountTransactionPerformer extends AccountTransactionPerformer {
    public WireAccountTransactionPerformer(Bus bus) {
        super(bus);
    }

    @Override
    public void transfer(double amount) {
        bus.post(new TransactionPerformedEvent(TransactionPerformedEvent.Status.FAILED, amount));
    }
}
