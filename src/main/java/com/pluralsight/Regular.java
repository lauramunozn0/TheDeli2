package com.pluralsight;

public class Regular extends Toppings {

    public Regular(String name) {
        super(name, 0.00);
    }

    @Override
    public String toString() {
        return getName() + " (included)";
    }
}
