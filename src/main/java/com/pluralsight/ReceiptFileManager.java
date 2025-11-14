package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order order) {


        java.io.File folder = new java.io.File("receipts");
        if (!folder.exists()) {
            folder.mkdirs();
        }


        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        String filename = "receipts/receipt-" + timestamp + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            writer.println("===== DELI-cious Receipt =====");
            writer.println("Customer: " + order.getCustomerName());
            writer.println("Phone: " + order.getPhoneNumber());
            writer.println();
            writer.println("----- ITEMS -----");

            for (Product p : order.getProducts()) {

                writer.println(p.toString());


                if (p instanceof Sandwich sand) {
                    if (!sand.getToppings().isEmpty()) {
                        writer.println("   Toppings:");
                        for (Toppings t : sand.getToppings()) {
                            writer.println("      - " + t.toString());
                        }
                    }
                }

                writer.println();
            }

            writer.println("-----------------------------");
            writer.println("TOTAL: $" + String.format("%.2f", order.getTotal()));
            writer.println("-----------------------------");
            writer.println("Thank you for ordering!");

            System.out.println("Receipt saved to: " + filename);

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
