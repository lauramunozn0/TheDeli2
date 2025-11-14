package com.pluralsight;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private String phoneNumber;

    private ArrayList<Product> products = new ArrayList<>();

    public void setCustomerInfo(String name, String phone) {
        this.customerName = name;
        this.phoneNumber = phone;
    }

    public void addDrink(String name, String size) {
        products.add(new Drink(name, size));
    }

    public void addChip() {
        products.add(new Chip());
    }

    public void addSandwich(Sandwich s) {
        products.add(s);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}
