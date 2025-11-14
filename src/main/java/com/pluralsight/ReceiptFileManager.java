package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

                    ArrayList<Toppings> included = new ArrayList<>();
                    ArrayList<Toppings> extra = new ArrayList<>();

                    for (Toppings t : sandwich.getToppings()) {

                        if (t instanceof Meat meat) {
                            if (meat.isExtra())
                                extra.add(t);
                            else
                                included.add(t);
                        }
                        else if (t instanceof Cheese cheese) {
                            if (cheese.isExtra())
                                extra.add(t);
                            else
                                included.add(t);
                        }
                        else {
                            included.add(t);
                        }
                    }

                    if (!included.isEmpty()) {
                        writer.write("   Included Toppings:\n");
                        for (Toppings t : included) {
                            writer.write("      - " + t.getName() + "\n");
                        }
                    }

                    if (!extra.isEmpty()) {
                        writer.write("   Extra Toppings:\n");
                        for (Toppings t : extra) {
                            writer.write("      - " + t.getName() +
                                    " ($" + String.format("%.2f", t.getPrice()) + ")\n");
                        }
                    }

                    writer.write("\n");
                }
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
