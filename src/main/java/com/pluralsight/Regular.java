package com.pluralsight;

public class Regular extends Toppings{
    private boolean isExtra;

    public Regular(String name, boolean isExtra) {
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
