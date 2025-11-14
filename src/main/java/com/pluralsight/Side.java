package com.pluralsight;

public class Side extends Toppings {

    public Side(String name) {
        super(name, 0.00);
    }

    @Override
    public String toString() {
        return getName() + " (included)";
    }
}

