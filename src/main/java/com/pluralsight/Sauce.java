package com.pluralsight;

public class Sauce extends Toppings {

    public Sauce(String name) {
        super(name, 0.00);
    }

    @Override
    public String toString() {
        return getName() + " (included)";
    }
}