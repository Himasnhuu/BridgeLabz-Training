package ecommerce;

class Product {
    private String name;
    private double price;
    private double rating;
    private double discount;
    
    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getRating() {
        return rating;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public double getFinalPrice() {
        return price - (price * discount / 100);
    }
    
    @Override
    public String toString() {
        return String.format("%s - Price: $%.2f, Rating: %.1f, Discount: %.0f%%", 
                           name, price, rating, discount);
    }
}
