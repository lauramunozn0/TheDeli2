package com.pluralsight;

public class Cheese extends Toppings {

    private boolean isExtra;

    public Cheese(String name, boolean isExtra, String size) {
        super(name, calculatePrice(isExtra, size));
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    private static double calculatePrice(boolean isExtra, String size) {
        double base;
        double extraPrice;

        switch (size) {
            case "4" -> { base = 0.75; extraPrice = 0.30; }
            case "8" -> { base = 1.50; extraPrice = 0.60; }
            case "12" -> { base = 2.25; extraPrice = 0.90; }
            default -> { base = 0; extraPrice = 0; }
        }

        return isExtra ? base + extraPrice : base;
    }
}
