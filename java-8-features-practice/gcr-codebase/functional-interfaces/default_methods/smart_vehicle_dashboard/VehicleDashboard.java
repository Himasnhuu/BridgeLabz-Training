package default_methods.smart_vehicle_dashboard;

// Interface with default method for battery percentage display
public interface VehicleDashboard {
    void displaySpeed();
    
    default void displayBatteryPercentage() {
        System.out.println("Battery feature not available for this vehicle");
    }
}
