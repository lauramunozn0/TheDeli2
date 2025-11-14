package com.pluralsight;

public class Cheese extends Toppings {

    public Cheese(String name, boolean isExtra, String size) {
        super(name, calculatePrice(isExtra, size));
    }

    private static double calculatePrice(boolean isExtra, String size) {
        double base;
        double extra;

        switch (size) {
            case "4" -> {
                base = 0.75;
                extra = 0.30;
            }
            case "8" -> {
                base = 1.50;
                extra = 0.60;
            }
            case "12" -> {
                base = 2.25;
                extra = 0.90;
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
