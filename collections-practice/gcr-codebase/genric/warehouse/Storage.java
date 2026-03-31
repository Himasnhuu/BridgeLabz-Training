package week4collections.javagenerics.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic storage class to store items safely with type safety
 */
public class Storage<T extends WarehouseItem> {
    private List<T> items;
    private String storageName;

    public Storage(String storageName) {
        this.storageName = storageName;
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added " + item.getName() + " to " + storageName);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    public int getItemCount() {
        return items.size();
    }

    /**
     * Wildcard method to display all items in storage regardless of their type
     */
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("\n=== Displaying All Items ===");
        if (items.isEmpty()) {
            System.out.println("No items in storage");
        } else {
            for (WarehouseItem item : items) {
                System.out.println(item);
            }
        }
        System.out.println("Total items: " + items.size());
    }

    @Override
    public String toString() {
        return "Storage: " + storageName + " [" + items.size() + " items]";
    }
}
