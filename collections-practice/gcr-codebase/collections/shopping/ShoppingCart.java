package shopping;

import java.util.*;

public class ShoppingCart {
    
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cartItems;
    
    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
    }
    
    // Add product with price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }
    
    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }
    
    // Remove item from cart
    public void removeFromCart(String product) {
        cartItems.remove(product);
    }
    
    // Display items in order added
    public void displayCartInOrder() {
        System.out.println("Cart Items (in order added):");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            double price = productPrices.get(entry.getKey());
            System.out.println(entry.getKey() + " x " + entry.getValue() + 
                             " = $" + (price * entry.getValue()));
        }
    }
    
    // Display items sorted by price
    public void displayCartByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            double price = productPrices.get(entry.getKey());
            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(entry.getKey());
        }
        
        System.out.println("Cart Items (sorted by price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                int quantity = cartItems.get(product);
                System.out.println(product + " x " + quantity + 
                                 " = $" + (entry.getKey() * quantity) + 
                                 " (@$" + entry.getKey() + " each)");
            }
        }
    }
    
    // Get total price
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // Add products
        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Mouse", 25.50);
        cart.addProduct("Keyboard", 75.00);
        cart.addProduct("Monitor", 299.99);
        
        // Add to cart
        cart.addToCart("Mouse", 2);
        cart.addToCart("Laptop", 1);
        cart.addToCart("Keyboard", 1);
        
        cart.displayCartInOrder();
        System.out.println();
        cart.displayCartByPrice();
        System.out.println("\nTotal: $" + cart.getTotalPrice());
    }
}
