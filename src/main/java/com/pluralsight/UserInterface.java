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
            System.out.print("Please enter your choice: ");

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
            System.out.println("1) Build Your Own Sandwich");
            System.out.println("2) BLT");
            System.out.println("3) Philly Cheesesteak");
            System.out.println("4) Drink");
            System.out.println("5) Chips");
            System.out.println("6) Get Total / Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCustomSandwich(order);
                case 2 -> addBLT(order);
                case 3 -> addPhilly(order);
                case 4 -> addDrink(order);
                case 5 -> addChip(order);
                case 6 -> {
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

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        order.addDrink(name, size);
        System.out.println("Drink added!");
    }

    private void addChip(Order order) {
        System.out.print("Add chips? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            order.addChip();
            System.out.println("Chips added!");
        } else {
            System.out.println("No chips added.");
        }
    }


    private void addCustomSandwich(Order order) {
        System.out.print("Enter sandwich name: ");
        String name = scanner.nextLine();

        System.out.print("Choose bread type (white/wheat/rye/wrap): ");
        String breadType = scanner.nextLine();

        System.out.print("Choose size (4, 8, 12): ");
        String size = scanner.nextLine();

        System.out.print("Toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        Sandwich sandwich = new Sandwich(name, size, breadType, toasted);

        System.out.print("Add toppings now? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            addToppings(sandwich);
        }

        order.addSandwich(sandwich);
        System.out.println("Custom sandwich added!");
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
                case 0 -> System.out.println("Finished adding toppings.");
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
        String meatName = switch (choice) {
            case 1 -> "steak";
            case 2 -> "ham";
            case 3 -> "salami";
            case 4 -> "roast beef";
            case 5 -> "chicken";
            case 6 -> "bacon";
            default -> null;
        };

        if (meatName == null) {
            System.out.println("Invalid choice.");
            return;
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
        String cheeseName = switch (choice) {
            case 1 -> "American";
            case 2 -> "Provolone";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            default -> null;
        };

        if (cheeseName == null) {
            System.out.println("Invalid choice.");
            return;
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

            choice = Integer.parseInt(scanner.nextLine());

            String reg = switch (choice) {
                case 1 -> "lettuce";
                case 2 -> "peppers";
                case 3 -> "onions";
                case 4 -> "tomatoes";
                case 5 -> "jalapeños";
                case 6 -> "cucumbers";
                case 7 -> "pickles";
                case 8 -> "guacamole";
                case 9 -> "mushrooms";
                case 0 -> null;
                default -> null;
            };

            if (reg != null) {
                sandwich.addTopping(new Regular(reg));
                System.out.println(reg + " added.");
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

            choice = Integer.parseInt(scanner.nextLine());

            String sauce = switch (choice) {
                case 1 -> "mayo";
                case 2 -> "mustard";
                case 3 -> "ketchup";
                case 4 -> "ranch";
                case 5 -> "thousand islands";
                case 6 -> "vinaigrette";
                case 0 -> null;
                default -> null;
            };

            if (sauce != null) {
                sandwich.addTopping(new Sauce(sauce));
                System.out.println(sauce + " added.");
            }

        } while (choice != 0);
    }

    private void addSide(Sandwich sandwich) {
        System.out.println("\nChoose Side:");
        System.out.println("1) Au Jus");
        System.out.println("2) Sauce");
        int choice = Integer.parseInt(scanner.nextLine());

        String side = switch (choice) {
            case 1 -> "Au Jus";
            case 2 -> "Sauce";
            default -> null;
        };

        if (side != null) {
            sandwich.addTopping(new Side(side));
            System.out.println(side + " added.");
        } else {
            System.out.println("Invalid choice.");
        }
    }


    private void modifyToppings(Sandwich sandwich) {
        int choice;
        do {
            System.out.println("\n=== MODIFY TOPPINGS ===");
            System.out.println("1) Add Toppings");
            System.out.println("2) Remove Toppings");
            System.out.println("0) Done");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addToppings(sandwich);
                case 2 -> removeToppings(sandwich);
                case 0 -> System.out.println("Done modifying.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void removeToppings(Sandwich sandwich) {
        if (sandwich.getToppings().isEmpty()) {
            System.out.println("No toppings to remove.");
            return;
        }

        System.out.println("\nSelect topping to remove:");
        for (int i = 0; i < sandwich.getToppings().size(); i++) {
            System.out.println((i + 1) + ") " + sandwich.getToppings().get(i).getName());
        }

        System.out.print("Choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice < 1 || choice > sandwich.getToppings().size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Toppings removed = sandwich.getToppings().remove(choice - 1);
        System.out.println(removed.getName() + " removed.");
    }

    private void addBLT(Order order) {
        System.out.print("Bread type (white/wheat/rye/wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        BLT blt = new BLT(bread, toasted);

        System.out.print("Modify toppings? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            modifyToppings(blt);
        }

        order.addSandwich(blt);
        System.out.println("BLT added!");
    }

    private void addPhilly(Order order) {
        System.out.print("Bread type (white/wheat/rye/wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        PhillyCheesesteak philly = new PhillyCheesesteak(bread, toasted);

        System.out.print("Modify toppings? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            modifyToppings(philly);
        }

        order.addSandwich(philly);
        System.out.println("Philly Cheesesteak added!");
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
                    System.out.println("Returning to item menu...");
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

        ReceiptFileManager.saveReceipt(order);

        System.out.println("Receipt has been saved.");
        System.out.println("Thank you for your order!");
    }
}