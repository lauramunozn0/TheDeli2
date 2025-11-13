package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Product {

    private String size;
    private String breadType;
    private boolean toasted;
    private ArrayList<Toppings> toppings = new ArrayList<>();

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


    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double total = 0;

        // Base price based on size
        switch (size) {
            case "4" -> total = 5.50;
            case "8" -> total = 7.00;
            case "12" -> total = 8.50;
            default -> total = getBasePrice();
        }

        // Add topping prices
        for (Toppings t : toppings) {
            total += t.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sandwich: ")
                .append(getName())
                .append(" (")
                .append(size)
                .append(" inch, ")
                .append(breadType)
                .append(toasted ? ", toasted" : ", not toasted")
                .append(") - $")
                .append(String.format("%.2f", getPrice()));

        if (!toppings.isEmpty()) {
            sb.append("\n  Toppings:");
            for (Toppings t : toppings) {
                sb.append("\n    - ").append(t.toString());
            }
        }

        return sb.toString();
    }


}