package scenariobased.oops.rideManagementSystem;

public class Ride implements FareCalculator {
    private static int rideCounter = 1000;
    
    private int rideId;
    private User user;
    private Driver driver;
    private String pickup;
    private String destination;
    private double distance;
    private double fare;
    private String pricingType;
    
    public Ride(User user, String pickup, String destination, double distance, String pricingType) {
        this.rideId = ++rideCounter;
        this.user = user;
        this.pickup = pickup;
        this.destination = destination;
        this.distance = distance;
        this.pricingType = pricingType;
        this.fare = calculateFare(distance);
    }
    
    public void assignDriver(Driver driver) {
        this.driver = driver;
    }
    
    @Override
    public double calculateFare(double distance) {
        double baseFare = 50;
        double perKmRate = 12;
        
        double totalFare = baseFare + (distance * perKmRate);
        
        // Polymorphism: Peak pricing
        if (pricingType.equalsIgnoreCase("Peak")) {
            totalFare *= 1.5;
        }
        
        return totalFare;
    }
    
    public String getRideDetails() {
        return String.format(
            "Ride ID: %d\nUser: %s\nDriver: %s (%s)\nPickup: %s\nDestination: %s\nDistance: %.2f km\nFare: ₹%.2f\nPricing: %s",
            rideId, user.getName(), 
            driver != null ? driver.getName() : "Not Assigned",
            driver != null ? driver.getVehicleNumber() : "N/A",
            pickup, destination, distance, fare, pricingType
        );
    }
    
    public int getRideId() {
        return rideId;
    }
    
    public Driver getDriver() {
        return driver;
    }
}
