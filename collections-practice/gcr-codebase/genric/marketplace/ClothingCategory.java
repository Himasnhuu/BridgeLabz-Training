package week4collections.javagenerics.marketplace;

/**
 * Clothing category with specific price range and size information
 */
public class ClothingCategory {
    private String type;
    private String size;
    private double minPrice;
    private double maxPrice;

    public ClothingCategory(String type, String size, double minPrice, double maxPrice) {
        this.type = type;
        this.size = size;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    @Override
    public String toString() {
        return "Clothing (" + type + ", Size: " + size + ", $" + minPrice + "-$" + maxPrice + ")";
    }
}
