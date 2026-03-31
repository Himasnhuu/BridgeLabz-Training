package week2.oops.encapsulation;

/*8. Ride-Hailing Application
Description: Develop a ride-hailing application:
Define an abstract class Vehicle with fields like vehicleId, driverName, and ratePerKm.
Add abstract methods calculateFare(double distance) and a concrete method getVehicleDetails().
Create subclasses Car, Bike, and Auto, overriding calculateFare() based on type-specific rates.
Use an interface GPS with methods getCurrentLocation() and updateLocation().
Secure driver and vehicle details using encapsulation.
Demonstrate polymorphism by creating a method to calculate fares for different vehicle types dynamically.*/

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private String driverContact;
    private double ratePerKm;
    private String currentLocation;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }
    
    public abstract double calculateFare(double distance);
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + getDriverInitials());
        System.out.println("Rate Per Km: $" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
    
    // Encapsulated method - only shows driver initials
    private String getDriverInitials() {
        if (driverName != null && !driverName.isEmpty()) {
            String[] parts = driverName.split(" ");
            StringBuilder initials = new StringBuilder();
            for (String part : parts) {
                if (!part.isEmpty()) {
                    initials.append(part.charAt(0)).append(".");
                }
            }
            return initials.toString();
        }
        return "N/A";
    }
    
    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }
    
    protected void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    protected void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    protected void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }
    
    protected String getDriverContact() {
        return driverContact;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
    
    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }
    
    protected String getLocation() {
        return currentLocation;
    }
}

// Car class
class Car extends Vehicle implements GPS {
    private static final double BASE_FARE = 5.0;
    private static final double SERVICE_CHARGE = 2.0;
    
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (getRatePerKm() * distance) + SERVICE_CHARGE;
    }
    
    @Override
    public String getCurrentLocation() {
        return getLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
    
    @Override
    public void getVehicleDetails() {
        System.out.println("\n--- Car Details ---");
        super.getVehicleDetails();
        System.out.println("Base Fare: $" + BASE_FARE);
        System.out.println("Service Charge: $" + SERVICE_CHARGE);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private static final double BASE_FARE = 2.0;
    
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (getRatePerKm() * distance);
    }
    
    @Override
    public String getCurrentLocation() {
        return getLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
    
    @Override
    public void getVehicleDetails() {
        System.out.println("\n--- Bike Details ---");
        super.getVehicleDetails();
        System.out.println("Base Fare: $" + BASE_FARE);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private static final double BASE_FARE = 3.0;
    private static final double NIGHT_CHARGE = 1.5;
    private boolean isNightTime;
    
    public Auto(String vehicleId, String driverName, double ratePerKm, boolean isNightTime) {
        super(vehicleId, driverName, ratePerKm);
        this.isNightTime = isNightTime;
    }
    
    @Override
    public double calculateFare(double distance) {
        double fare = BASE_FARE + (getRatePerKm() * distance);
        if (isNightTime) {
            fare += NIGHT_CHARGE;
        }
        return fare;
    }
    
    @Override
    public String getCurrentLocation() {
        return getLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
    
    @Override
    public void getVehicleDetails() {
        System.out.println("\n--- Auto Details ---");
        super.getVehicleDetails();
        System.out.println("Base Fare: $" + BASE_FARE);
        if (isNightTime) {
            System.out.println("Night Charge: $" + NIGHT_CHARGE);
        }
    }
}

// Main class
public class RideHailingApplication {
    
    // Polymorphic method to process rides
    public static void processRide(Vehicle vehicle, double distance, String pickupLocation, String dropLocation) {
        System.out.println("\n========== RIDE REQUEST ==========");
        
        // Update location if vehicle implements GPS
        if (vehicle instanceof GPS) {
            ((GPS) vehicle).updateLocation(pickupLocation);
        }
        
        vehicle.getVehicleDetails();
        System.out.println("\nPickup: " + pickupLocation);
        System.out.println("Drop: " + dropLocation);
        System.out.println("Distance: " + distance + " km");
        
        double fare = vehicle.calculateFare(distance);
        System.out.println("Estimated Fare: $" + String.format("%.2f", fare));
    }
    
    public static void main(String[] args) {
        System.out.println("========== RIDE-HAILING APPLICATION ==========");
        
        // Create vehicles
        Car car = new Car("CAR101", "John Smith", 2.5);
        Bike bike = new Bike("BIKE201", "Mike Johnson", 1.5);
        Auto auto = new Auto("AUTO301", "Raj Kumar", 2.0, true);
        
        // Process rides
        processRide(car, 10.5, "Downtown Plaza", "Airport Terminal");
        processRide(bike, 5.0, "Central Station", "Tech Park");
        processRide(auto, 7.5, "Mall Road", "City Hospital");
        
        // Demonstrate polymorphism
        System.out.println("\n\n========== FARE COMPARISON ==========");
        Vehicle[] vehicles = {car, bike, auto};
        double testDistance = 10.0;
        
        System.out.println("Distance: " + testDistance + " km\n");
        for (Vehicle vehicle : vehicles) {
            String vehicleType = vehicle.getClass().getSimpleName();
            double fare = vehicle.calculateFare(testDistance);
            System.out.println(vehicleType + " Fare: $" + String.format("%.2f", fare));
        }
        
        // Track location
        System.out.println("\n========== GPS TRACKING ==========");
        car.updateLocation("Highway Exit 5");
        bike.updateLocation("Ring Road Junction");
        auto.updateLocation("Market Square");
        
        System.out.println("Car Location: " + car.getCurrentLocation());
        System.out.println("Bike Location: " + bike.getCurrentLocation());
        System.out.println("Auto Location: " + auto.getCurrentLocation());
    }
}
