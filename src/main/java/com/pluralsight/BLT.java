package com.pluralsight;

public class BLT extends Sandwich {

    public BLT() {
        super("BLT", "8", "white", true);
        setBasePrice(10.50);

        addTopping(new Regular("bacon"));
        addTopping(new Regular("cheddar"));
        addTopping(new Regular("lettuce"));
        addTopping(new Regular("tomato"));
        addTopping(new Regular("ranch"));
    }
}