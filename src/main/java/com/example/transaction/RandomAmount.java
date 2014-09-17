package com.example.transaction;

import java.math.BigDecimal;
import java.util.Random;

public class RandomAmount {

    private static final double MAX_AMOUNT = 200d;
    public static final int PRECISION = 2;

    private final double amount;

    public RandomAmount(Random random) {
        amount = generateAmount(random);
    }

    private double generateAmount(Random random) {
        double value = random.nextDouble() * MAX_AMOUNT + 1;
        return round(value);
    }

    public double getAmount() {
        return amount;
    }

    public double round(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(PRECISION, BigDecimal.ROUND_HALF_EVEN);
        return rounded.doubleValue();
    }
}
