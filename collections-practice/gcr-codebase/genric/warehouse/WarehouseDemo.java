package week4collections.javagenerics.warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class for Smart Warehouse Management System
 */
public class WarehouseDemo {
    public static void main(String[] args) {
        // Create storage for different item types
        Storage<Electronics> electronicsStorage = new Storage<>("Electronics Section");
        Storage<Groceries> groceriesStorage = new Storage<>("Groceries Section");
        Storage<Furniture> furnitureStorage = new Storage<>("Furniture Section");

        // Add electronics
        electronicsStorage.addItem(new Electronics("Laptop", "E001", 899.99, 24));
        electronicsStorage.addItem(new Electronics("Smartphone", "E002", 699.99, 12));
        electronicsStorage.addItem(new Electronics("Headphones", "E003", 149.99, 6));

        // Add groceries
        groceriesStorage.addItem(new Groceries("Milk", "G001", 3.99, LocalDate.of(2026, 1, 25)));
        groceriesStorage.addItem(new Groceries("Bread", "G002", 2.49, LocalDate.of(2026, 1, 22)));

        // Add furniture
        furnitureStorage.addItem(new Furniture("Desk", "F001", 299.99, "Wood", 25.5));
        furnitureStorage.addItem(new Furniture("Chair", "F002", 149.99, "Metal", 8.2));

        // Display using wildcard method
        System.out.println("\n--- Electronics Storage ---");
        Storage.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\n--- Groceries Storage ---");
        Storage.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\n--- Furniture Storage ---");
        Storage.displayAllItems(furnitureStorage.getAllItems());

        // Display all items from all storages using wildcard
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.getAllItems());
        allItems.addAll(groceriesStorage.getAllItems());
        allItems.addAll(furnitureStorage.getAllItems());

        System.out.println("\n--- All Warehouse Items ---");
        Storage.displayAllItems(allItems);
    }
}
