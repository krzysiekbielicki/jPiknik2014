package com.example.transaction;

import java.util.Random;

public class RandomAmount {

    private static final double MAX_AMOUNT = 200d;

    private final double amount;

    public RandomAmount(Random random) {
        amount = generateAmount(random);
    }

    private double generateAmount(Random random) {
        return random.nextDouble() * MAX_AMOUNT + 1;
    }

    public double getAmount() {
        return amount;
    }
}
