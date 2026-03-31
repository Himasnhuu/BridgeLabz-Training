package marker_interfaces.cloning_prototype_objects;

public class ProductPrototype {
    
    public static void main(String[] args) {
        Product original = new Product("Laptop", 999.99);
        Product cloned = original.clone();
        
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        System.out.println("Are they the same object? " + (original == cloned));
    }
}
