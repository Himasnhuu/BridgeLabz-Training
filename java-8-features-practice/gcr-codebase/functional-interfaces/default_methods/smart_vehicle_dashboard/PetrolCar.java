package default_methods.smart_vehicle_dashboard;

public class PetrolCar implements VehicleDashboard {
    private int speed;
    
    public PetrolCar(int speed) {
        this.speed = speed;
    }
    
    @Override
    public void displaySpeed() {
        System.out.println("Current speed: " + speed + " km/h");
    }
}
