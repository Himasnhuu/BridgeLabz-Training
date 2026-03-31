package default_methods.smart_vehicle_dashboard;

public class ElectricCar implements VehicleDashboard {
    private int speed;
    private int batteryPercentage;
    
    public ElectricCar(int speed, int batteryPercentage) {
        this.speed = speed;
        this.batteryPercentage = batteryPercentage;
    }
    
    @Override
    public void displaySpeed() {
        System.out.println("Current speed: " + speed + " km/h");
    }
    
    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery level: " + batteryPercentage + "%");
    }
}
