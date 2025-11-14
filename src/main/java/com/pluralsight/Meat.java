package com.pluralsight;

public class Meat extends Toppings {

    public Meat(String name, boolean isExtra, String size) {
        super(name, calculatePrice(isExtra, size));
    }

    private static double calculatePrice(boolean isExtra, String size) {
        double base;
        double extra;

        switch (size) {
            case "4" -> {
                base = 1.00;
                extra = 0.50;
            }
            case "8" -> {
                base = 2.00;
                extra = 1.00;
            }
            case "12" -> {
                base = 3.00;
                extra = 1.50;
            }
            default -> {
                base = 0;
                extra = 0;
            }
        }

        if (isExtra) {
            base += extra;
        }

        return base;
    }
}
