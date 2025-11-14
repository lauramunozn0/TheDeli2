package com.pluralsight;

public class Toppings {

    protected String name;
    protected double price;

    public Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}


