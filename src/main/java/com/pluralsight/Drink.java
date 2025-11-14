package com.pluralsight;

public class Drink extends Product {

    private String size;

    public Drink(String name, String size) {
        super(name, 0);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Drink: " + getName() + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}
