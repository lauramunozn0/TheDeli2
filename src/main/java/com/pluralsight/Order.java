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
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("What would you like to add?");
            System.out.println("1) Sandwich");
            System.out.println("2) Drink");
            System.out.println("3) Chip");
            System.out.println("0) Back");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addSandwich(scanner);
                case 2 -> addDrink(scanner);
                case 3 -> addChip(scanner);
                case 0 -> System.out.println("Returning to order menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
    private void addDrink(Scanner scanner) {
        System.out.print("Enter drink name (Coke or Sprite): ");
        String name = scanner.nextLine();
        System.out.print("Enter size (Small / Medium / Large): ");
        String size = scanner.nextLine();

        Drink drink = new Drink(name, 0, size);
        products.add(drink);

        System.out.println(drink + " added to order.");
    }
    private void addSandwich(Scanner scanner) { System.out.println("Sandwich"); }
    private void addChip(Scanner scanner) { System.out.println("Chip"); }

    private double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

}
