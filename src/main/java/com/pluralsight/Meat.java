package com.pluralsight;

public class Meat extends Toppings {

    private boolean isExtra;

    public Meat(String name, boolean isExtra, String size) {
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
            case "4" -> { base = 1.00; extraPrice = 0.50; }
            case "8" -> { base = 2.00; extraPrice = 1.00; }
            case "12" -> { base = 3.00; extraPrice = 1.50; }
            default -> { base = 0; extraPrice = 0; }
        }

        return isExtra ? base + extraPrice : base;
    }
}

