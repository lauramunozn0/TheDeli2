package com.pluralsight;

public class Chip extends Product {

    public Chip() {
        super("Chips", 1.50);
    }

    @Override
    public double getPrice() {
        return getBasePrice();
    }

    @Override
    public String toString() {
        return getName() + " - $" + String.format("%.2f", getPrice());
    }
}
