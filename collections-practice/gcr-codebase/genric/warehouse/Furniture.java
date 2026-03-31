package week4collections.javagenerics.warehouse;

/**
 * Furniture item type
 */
public class Furniture extends WarehouseItem {
    private String material;
    private double weight;

    public Furniture(String name, String id, double price, String material, double weight) {
        super(name, id, price);
        this.material = material;
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material + ", Weight: " + weight + "kg";
    }
}
