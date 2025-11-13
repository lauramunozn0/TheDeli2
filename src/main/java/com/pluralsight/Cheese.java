package com.pluralsight;

public class Cheese extends Toppings {
    private boolean isExtra;

    public Cheese(String name, boolean isExtra, String size) {
        super(name, calculatePrice(size, isExtra));
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    private static double calculatePrice(String size, boolean isExtra) {
        double basePrice = 0.0;
        double extraPrice = 0.0;

        // 🧾 Base cheese price by sandwich size (from Capstone page 3)
        switch (size) {
            case "4":
                basePrice = 0.75;
                extraPrice = 0.30;
                break;
            case "8":
                basePrice = 1.50;
                extraPrice = 0.60;
                break;
            case "12":
                basePrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                basePrice = 0.0;
        }

        if (isExtra) {
            basePrice += extraPrice;
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return getName() +
                (isExtra ? " (extra)" : "") +
                " - $" + String.format("%.2f", getPrice());
    }
}
