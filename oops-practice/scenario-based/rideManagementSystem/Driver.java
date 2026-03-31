package scenariobased.oops.rideManagementSystem;

public class Driver {
    private String name;
    private String vehicleNumber;
    private boolean available;
    
    public Driver(String name, String vehicleNumber) {
        this.name = name;
        this.vehicleNumber = vehicleNumber;
        this.available = true;
    }
    
    public String getName() {
        return name;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
