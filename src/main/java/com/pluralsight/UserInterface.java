package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("~~~ Welcome to DELI-cious ~~~");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please Enter your choice: ");


            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    Order order = new Order();
                    order.startOrder();
                }
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }
}
