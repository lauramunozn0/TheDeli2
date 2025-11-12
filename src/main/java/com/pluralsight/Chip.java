package com.pluralsight;

public class Chip extends Product {

    public Chip() {
        super("Chips", 1.50);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips - $" + String.format("%.2f", getPrice());
    }
}
