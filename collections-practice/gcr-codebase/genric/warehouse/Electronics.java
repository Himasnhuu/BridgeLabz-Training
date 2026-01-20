package week4collections.javagenerics.warehouse;

/**
 * Electronics item type
 */
public class Electronics extends WarehouseItem {
    private int warrantyMonths;

    public Electronics(String name, String id, double price, int warrantyMonths) {
        super(name, id, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months";
    }
}
