package com.pluralsight;
import java.util.Scanner;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private String phoneNumber;
    private boolean isMember;
    private ArrayList<Product> products = new ArrayList<>();
    public void startOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Are you a member? (Y/N): ");
        String memberResponse = scanner.nextLine();
        isMember = memberResponse.equalsIgnoreCase("Y");

        int choice;
        do {
            System.out.print("Please Enter choice: ");
            System.out.println("1) Add Item");
            System.out.println("2) Get Total");
            System.out.println("0) Finish Order");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addItem();
                case 2 -> System.out.println("Total so far: $" + getTotal());
                case 0 -> System.out.println("Order complete!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void addItem() {
        System.out.println("Item added (placeholder).");
    }

    private double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}
