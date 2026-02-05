package defining_implementing.multi_vehicle_rental;

public class Bike implements VehicleRental {
    private String type;
    private boolean isRented;
    
    public Bike(String type) {
        this.type = type;
        this.isRented = false;
    }
    
    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Bike " + type + " has been rented");
        } else {
            System.out.println("Bike is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bike " + type + " has been returned");
        } else {
            System.out.println("Bike was not rented");
        }
    }
}
