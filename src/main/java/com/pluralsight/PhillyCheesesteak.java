package com.pluralsight;

public class PhillyCheesesteak extends Sandwich {

    public PhillyCheesesteak() {
        super("Philly Cheesesteak", "8", "white", true);
        setBasePrice(10.50);

        addTopping(new Regular("steak"));
        addTopping(new Regular("American"));
        addTopping(new Regular("peppers"));
        addTopping(new Regular("mayo"));
    }
}
