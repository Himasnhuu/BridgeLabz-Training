package defining_implementing.multi_vehicle_rental;

public class Car implements VehicleRental {
    private String model;
    private boolean isRented;
    
    public Car(String model) {
        this.model = model;
        this.isRented = false;
    }
    
    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Car " + model + " has been rented");
        } else {
            System.out.println("Car is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Car " + model + " has been returned");
        } else {
            System.out.println("Car was not rented");
        }
    }
}
