package com.example.transaction;

public class TransactionPerformedEvent {

    private final Status status;
    private final double amount;

    public TransactionPerformedEvent(Status status, double amount) {
        this.status = status;
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public enum Status {
        SUCCESS, FAILED;
    }
}
