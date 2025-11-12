package com.pluralsight;

public class Drink extends Product {

    private String size;

    public Drink(String name, double basePrice, String size) {
        super(name, basePrice);
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
                return getBasePrice();
        }
    }

    @Override
    public String toString() {
        return "Drink: " + getName() + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}
