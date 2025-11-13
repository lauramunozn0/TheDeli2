package com.pluralsight;

public class Sauce extends Toppings{
    private boolean isExtra;

    public Sauce(String name, boolean isExtra) {

        super(name, 0.00);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String toString() {
        return getName() + (isExtra ? " (extra)" : "") + " (included)";
    }
}