package com.pluralsight;

public class PhillyCheesesteak extends Sandwich {

    public PhillyCheesesteak(String breadType, boolean toasted) {
        super("Philly Cheesesteak", "8", breadType, toasted);

        setBasePrice(10.50);

        addTopping(new Meat("steak", false, "8"));
        addTopping(new Cheese("Provolone", false, "8"));
        addTopping(new Regular("peppers"));
        addTopping(new Regular("onions"));
    }
}
