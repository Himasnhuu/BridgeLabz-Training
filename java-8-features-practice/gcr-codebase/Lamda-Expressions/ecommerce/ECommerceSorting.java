package ecommerce;

import java.util.*;

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 999.99, 4.5, 10));
        products.add(new Product("Smartphone", 699.99, 4.7, 15));
        products.add(new Product("Headphones", 199.99, 4.3, 20));
        products.add(new Product("Tablet", 499.99, 4.6, 5));
        products.add(new Product("Smartwatch", 299.99, 4.4, 25));
        
        System.out.println("=== E-Commerce Custom Sorting ===\n");
        
        // Original list
        System.out.println("Original Product List:");
        products.forEach(System.out::println);
        
        // Sort by price (ascending)
        System.out.println("\n--- Sorted by Price (Low to High) ---");
        List<Product> byPrice = new ArrayList<>(products);
        byPrice.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        byPrice.forEach(System.out::println);
        
        // Sort by rating (descending)
        System.out.println("\n--- Sorted by Rating (High to Low) ---");
        List<Product> byRating = new ArrayList<>(products);
        byRating.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        byRating.forEach(System.out::println);
        
        // Sort by discount (descending)
        System.out.println("\n--- Sorted by Discount (High to Low) ---");
        List<Product> byDiscount = new ArrayList<>(products);
        byDiscount.sort((p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
        byDiscount.forEach(System.out::println);
        
        // Sort by final price after discount (ascending)
        System.out.println("\n--- Sorted by Final Price After Discount (Low to High) ---");
        List<Product> byFinalPrice = new ArrayList<>(products);
        byFinalPrice.sort((p1, p2) -> Double.compare(p1.getFinalPrice(), p2.getFinalPrice()));
        byFinalPrice.forEach(p -> 
            System.out.println(p + " -> Final: $" + String.format("%.2f", p.getFinalPrice())));
    }
}
