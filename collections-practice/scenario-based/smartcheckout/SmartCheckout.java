package smartcheckout;

import java.util.*;

public class SmartCheckout {
    private Queue<Customer> customerQueue;
    private Map<String, Item> itemMap;

    public SmartCheckout() {
        customerQueue = new LinkedList<>();
        itemMap = new HashMap<>();
    }

    // Add item to inventory
    public void addItemToInventory(String name, double price, int stock) {
        itemMap.put(name, new Item(name, price, stock));
        System.out.println("Added to inventory: " + itemMap.get(name));
    }

    // Add customer to queue
    public void addCustomer(Customer customer) {
        customerQueue.offer(customer);
        System.out.println("Customer added to queue: " + customer.getName());
    }

    // Process next customer in queue
    public void processNextCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }

        Customer customer = customerQueue.poll();
        System.out.println("\nProcessing: " + customer.getName());
        double total = 0;

        for (String itemName : customer.getItemNames()) {
            Item item = itemMap.get(itemName);
            if (item != null && item.getStock() > 0) {
                System.out.println("  " + itemName + " - $" + item.getPrice());
                total += item.getPrice();
                item.updateStock(1); // Reduce stock by 1
            } else {
                System.out.println("  " + itemName + " - Out of stock!");
            }
        }

        System.out.println("Total: $" + total);
    }

    // Show current queue
    public void showQueue() {
        System.out.println("\nCustomers in queue:");
        if (customerQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (Customer customer : customerQueue) {
                System.out.println("  " + customer);
            }
        }
    }

    // Show inventory
    public void showInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Item item : itemMap.values()) {
            System.out.println("  " + item);
        }
    }
}
