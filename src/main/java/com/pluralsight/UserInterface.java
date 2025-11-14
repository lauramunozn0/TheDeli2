package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;

        do {
            System.out.println("~~~ Welcome to DELI-cious ~~~");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> startOrder();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);
    }


    public void startOrder() {
        Order order = new Order();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        order.setCustomerInfo(name, phone);

        addItem(order);
    }


    private void addItem(Order order) {
        int choice;

        do {
            System.out.println("\n=== ADD ITEM ===");
            System.out.println("1) Sandwich");
            System.out.println("2) Drink");
            System.out.println("3) Chip");
            System.out.println("4) Get Total");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addChip(order);

                case 4 -> {
                    showTotalMenu(order);
                    return;
                }

                case 0 -> {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }


    private void addDrink(Order order) {
        System.out.print("Enter drink name (Coke or Sprite): ");
        String name = scanner.nextLine();

        System.out.print("Enter size (Small / Medium / Large): ");
        String size = scanner.nextLine();

        order.addDrink(name, size);

        System.out.println("Drink added.");
    }


    private void addChip(Order order) {
        System.out.print("Would you like to add chips? (Y/N): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            order.addChip();
            System.out.println("Chips added.");
        } else {
            System.out.println("No chips added.");
        }
    }


    private void addSandwich(Order order) {
        System.out.print("Enter sandwich name: ");
        String name = scanner.nextLine();

        System.out.print("Choose bread type (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();

        System.out.print("Choose size (4, 8, 12): ");
        String size = scanner.nextLine();

        System.out.print("Toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        Sandwich sandwich = new Sandwich(name, size, breadType, toasted);

        System.out.print("Add toppings? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            addToppings(sandwich);
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added.");
    }


    private void addToppings(Sandwich sandwich) {
        int choice;

        do {
            System.out.println("\n=== ADD TOPPINGS ===");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular");
            System.out.println("4) Sauce");
            System.out.println("5) Side");
            System.out.println("0) Done");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addMeat(sandwich);
                case 2 -> addCheese(sandwich);
                case 3 -> addRegular(sandwich);
                case 4 -> addSauce(sandwich);
                case 5 -> addSide(sandwich);
                case 0 -> System.out.println("Finished toppings.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void addMeat(Sandwich sandwich) {
        System.out.println("\nChoose Meat:");
        System.out.println("1) steak");
        System.out.println("2) ham");
        System.out.println("3) salami");
        System.out.println("4) roast beef");
        System.out.println("5) chicken");
        System.out.println("6) bacon");
        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        String meatName = null;

        switch (choice) {
            case 1 -> meatName = "steak";
            case 2 -> meatName = "ham";
            case 3 -> meatName = "salami";
            case 4 -> meatName = "roast beef";
            case 5 -> meatName = "chicken";
            case 6 -> meatName = "bacon";
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.print("Add extra meat? (Y/N): ");
        boolean isExtra = scanner.nextLine().equalsIgnoreCase("Y");

        sandwich.addTopping(new Meat(meatName, isExtra, sandwich.getSize()));
        System.out.println(meatName + " added.");
    }

    private void addCheese(Sandwich sandwich) {
        System.out.println("\nChoose Cheese:");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        String cheeseName = null;

        switch (choice) {
            case 1 -> cheeseName = "American";
            case 2 -> cheeseName = "Provolone";
            case 3 -> cheeseName = "Cheddar";
            case 4 -> cheeseName = "Swiss";
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.print("Add extra cheese? (Y/N): ");
        boolean isExtra = scanner.nextLine().equalsIgnoreCase("Y");

        sandwich.addTopping(new Cheese(cheeseName, isExtra, sandwich.getSize()));
        System.out.println(cheeseName + " added.");
    }

    private void addRegular(Sandwich sandwich) {

        int choice;
        do {
            System.out.println("\nChoose Regular Topping:");
            System.out.println("1) lettuce");
            System.out.println("2) peppers");
            System.out.println("3) onions");
            System.out.println("4) tomatoes");
            System.out.println("5) jalapeños");
            System.out.println("6) cucumbers");
            System.out.println("7) pickles");
            System.out.println("8) guacamole");
            System.out.println("9) mushrooms");
            System.out.println("0) Done");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());
            String regName = null;

            switch (choice) {
                case 1 -> regName = "lettuce";
                case 2 -> regName = "peppers";
                case 3 -> regName = "onions";
                case 4 -> regName = "tomatoes";
                case 5 -> regName = "jalapeños";
                case 6 -> regName = "cucumbers";
                case 7 -> regName = "pickles";
                case 8 -> regName = "guacamole";
                case 9 -> regName = "mushrooms";
                case 0 -> System.out.println("Done with regular toppings.");
                default -> System.out.println("Invalid choice.");
            }

            if (regName != null) {
                sandwich.addTopping(new Regular(regName));
                System.out.println(regName + " added.");
            }

        } while (choice != 0);
    }

    private void addSauce(Sandwich sandwich) {

        int choice;
        do {
            System.out.println("\nChoose Sauce:");
            System.out.println("1) mayo");
            System.out.println("2) mustard");
            System.out.println("3) ketchup");
            System.out.println("4) ranch");
            System.out.println("5) thousand islands");
            System.out.println("6) vinaigrette");
            System.out.println("0) Done");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());
            String sauceName = null;

            switch (choice) {
                case 1 -> sauceName = "mayo";
                case 2 -> sauceName = "mustard";
                case 3 -> sauceName = "ketchup";
                case 4 -> sauceName = "ranch";
                case 5 -> sauceName = "thousand islands";
                case 6 -> sauceName = "vinaigrette";
                case 0 -> System.out.println("Done with sauces.");
                default -> System.out.println("Invalid choice.");
            }

            if (sauceName != null) {
                sandwich.addTopping(new Sauce(sauceName));
                System.out.println(sauceName + " added.");
            }

        } while (choice != 0);
    }

    private void addSide(Sandwich sandwich) {
        System.out.println("\nChoose Side:");
        System.out.println("1) Au Jus");
        System.out.println("2) Sauce");
        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        String sideName = null;

        switch (choice) {
            case 1 -> sideName = "Au Jus";
            case 2 -> sideName = "Sauce";
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        sandwich.addTopping(new Side(sideName));
        System.out.println(sideName + " added.");
    }

    private void showTotalMenu(Order order) {
        System.out.println("\n=== CURRENT TOTAL ===");
        System.out.println("Total so far: $" + String.format("%.2f", order.getTotal()));

        int choice;

        do {
            System.out.println("\n1) Checkout");
            System.out.println("2) Add More Items");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    checkout(order);
                    return;
                }
                case 2 -> {
                    System.out.println("Returning to Add Item menu...");
                    return;
                }
                case 0 -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void checkout(Order order) {
        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Phone: " + order.getPhoneNumber());
        System.out.println("Final Total: $" + String.format("%.2f", order.getTotal()));


        System.out.println("Thank you for your order!");
    }
}
