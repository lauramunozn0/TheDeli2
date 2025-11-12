package com.pluralsight;

public class Sandwich extends Product {

    private String size;
    private String breadType;
    private boolean toasted;

    public Sandwich(String name, double basePrice, String size, String breadType, boolean toasted) {
        super(name, basePrice);
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;

    }

    @Override
    public double getPrice() {
        switch (size) {
            case "4":
                return 5.50;
            case "8":
                return 7.00;
            case "12":
                return 8.50;
            default:
                return getBasePrice();
        }

    }
    @Override
    public String toString() {
        return "Sandwich: " + getName() +
                " (" + size + " inch, " + breadType +
                (toasted ? ", toasted" : ", not toasted") +
                ") - $" + String.format("%.2f", getPrice());
    }
}