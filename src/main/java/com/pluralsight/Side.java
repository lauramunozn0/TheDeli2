package com.pluralsight;

public class Side extends Toppings{
    private boolean isExtra;

    public Side(String name, boolean isExtra) {
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
