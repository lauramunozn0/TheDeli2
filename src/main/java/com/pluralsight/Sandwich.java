package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Product {

    private String size;
    private String breadType;
    private boolean toasted;

    private ArrayList<Toppings> toppings = new ArrayList<>();


    public Sandwich(String name, String size, String breadType, boolean toasted) {
        super(name, 0);
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
    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    @Override
    public double getPrice() {
        double total;

        if (getBasePrice() > 0) {
            total = getBasePrice();
        }
        else {
            switch (size) {
                case "4" -> total = 5.50;
                case "8" -> total = 7.00;
                case "12" -> total = 8.50;
                default -> total = 0;
            }
        }

        for (Toppings t : toppings) {
            total += t.getPrice();
        }

        return total;
    }


    @Override
    public String toString() {
        return "Sandwich: " + getName() +
                " (" + size + " inch, " + breadType +
                (toasted ? ", toasted" : ", not toasted") + ")" +
                " - $" + String.format("%.2f", getPrice());
    }
}