package com.pluralsight;

public class BLT extends Sandwich {

    public BLT(String breadType, boolean toasted) {
        super("BLT", "8", breadType, toasted);

        setBasePrice(10.50);

        addTopping(new Meat("bacon", false, "8"));
        addTopping(new Regular("lettuce"));
        addTopping(new Regular("tomatoes"));
        addTopping(new Sauce("mayo"));
    }
}
