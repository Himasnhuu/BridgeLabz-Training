package defining_implementing.multi_vehicle_rental;

public class Bus implements VehicleRental {
    private int capacity;
    private boolean isRented;
    
    public Bus(int capacity) {
        this.capacity = capacity;
        this.isRented = false;
    }
    
    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Bus with capacity " + capacity + " has been rented");
        } else {
            System.out.println("Bus is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bus has been returned");
        } else {
            System.out.println("Bus was not rented");
        }
    }
}
