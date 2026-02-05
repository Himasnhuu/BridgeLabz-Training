package marker_interfaces.cloning_prototype_objects;

// Marker interface for cloneable objects
public class Product implements Cloneable {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=$" + price + "}";
    }
}
