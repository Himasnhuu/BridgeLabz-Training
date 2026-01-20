package week4collections.javagenerics.warehouse;

/**
 * Abstract base class for all warehouse items
 */
public abstract class WarehouseItem {
    private String name;
    private String id;
    private double price;

    public WarehouseItem(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + " [ID: " + id + ", Name: " + name + ", Price: $" + price + "]";
    }
}
