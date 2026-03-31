package week4collections.javagenerics.warehouse;

import java.time.LocalDate;

/**
 * Groceries item type
 */
public class Groceries extends WarehouseItem {
    private LocalDate expiryDate;

    public Groceries(String name, String id, double price, LocalDate expiryDate) {
        super(name, id, price);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiry: " + expiryDate;
    }
}
