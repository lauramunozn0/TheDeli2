package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order order) {

        File receiptFolder = new File("Receipts");
        if (!receiptFolder.exists()) {
            receiptFolder.mkdir();
        }

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        String fileName = "receipt-" + timestamp + ".txt";

        File file = new File(receiptFolder, fileName);

        System.out.println("Saving receipt to: " + file.getAbsolutePath());

        try (FileWriter writer = new FileWriter(file)) {

            writer.write("==============================\n");
            writer.write("        DELI-cious Receipt\n");
            writer.write("==============================\n");

            writer.write("Customer: " + order.getCustomerName() + "\n");
            writer.write("Phone: " + order.getPhoneNumber() + "\n");
            writer.write("------------------------------\n\n");

            writer.write("Items Ordered:\n");

            for (Product p : order.getProducts()) {
                writer.write(p.toString() + "\n");

                if (p instanceof Sandwich sandwich) {
                    if (!sandwich.getToppings().isEmpty()) {
                        writer.write("   Toppings:\n");
                        for (Toppings t : sandwich.getToppings()) {
                            writer.write("      - " + t.toString() + "\n");
                        }
                    }
                }

                writer.write("\n");
            }

            writer.write("------------------------------\n");
            writer.write("TOTAL: $" + String.format("%.2f", order.getTotal()) + "\n");
            writer.write("==============================\n");
            writer.write("   Thank you for choosing\n");
            writer.write("         DELI-cious!\n");
            writer.write("==============================\n");

            System.out.println("Receipt saved as: Receipts/" + fileName);

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
