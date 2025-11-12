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


}