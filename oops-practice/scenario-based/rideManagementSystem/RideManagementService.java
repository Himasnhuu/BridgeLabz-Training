package scenariobased.oops.rideManagementSystem;

import java.util.ArrayList;

public class RideManagementService {
    
    private ArrayList<Driver> drivers;
    private ArrayList<Ride> rideHistory;
    
    public RideManagementService() {
        this.drivers = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
        initializeDrivers();
    }
    
    private void initializeDrivers() {
        drivers.add(new Driver("Aryansh Chaudhary", "UP-86-AM-6020"));
        drivers.add(new Driver("Nitish Kumar", "DL-02-CD-5678"));
        drivers.add(new Driver("Shivam Pal", "DL-03-EF-9012"));
    }
    
    public Ride bookRide(User user, String pickup, String destination, 
                         double distance, String pricingType) 
                         throws NoDriverAvailableException {
        
        Driver availableDriver = null;
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                availableDriver = driver;
                break;
            }
        }
        
        if (availableDriver == null) {
            throw new NoDriverAvailableException("No drivers available at the moment!");
        }
        
        Ride ride = new Ride(user, pickup, destination, distance, pricingType);
        ride.assignDriver(availableDriver);
        availableDriver.setAvailable(false);
        
        rideHistory.add(ride);
        
        return ride;
    }
    
    public void completeRide(int rideId) {
        for (Ride ride : rideHistory) {
            if (ride.getRideId() == rideId) {
                if (ride.getDriver() != null) {
                    ride.getDriver().setAvailable(true);
                    System.out.println("Ride completed! Driver is now available.");
                    return;
                }
            }
        }
        System.out.println("Ride not found!");
    }
    
    public void displayRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No rides yet.");
            return;
        }
        
        System.out.println("\n=== Ride History ===");
        for (Ride ride : rideHistory) {
            System.out.println("\n" + ride.getRideDetails());
            System.out.println("---");
        }
    }
    
    public void displayAvailableDrivers() {
        System.out.println("\n=== Available Drivers ===");
        boolean found = false;
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                System.out.println("• " + driver.getName() + " - " + driver.getVehicleNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No drivers available.");
        }
    }
}
