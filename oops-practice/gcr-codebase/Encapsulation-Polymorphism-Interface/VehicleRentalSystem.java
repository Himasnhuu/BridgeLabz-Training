package week2.oops.encapsulation;

/*3. Vehicle Rental System
Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.*/

//-------------------------------------------------------------------------------------------------------------------------------------
public class VehicleRentalSystem {
	public static void main(String[] args) {
		
		Car car = new Car("CAR001",50, "Toyota Camry");
        Bike bike = new Bike("BIKE001", 20, "Sport");
        Truck truck = new Truck("TRUCK001", 100, 5000);
        
        // Array of vehicles (Polymorphism)
        Vehicle[] vehicles = {car, bike, truck};
		
        int rentalDuration = 5;
        
        for(Vehicle x:vehicles) {
        	
        	double cost = x.calculateRentalCost(rentalDuration);
        	x.displayVehicleDetails();
        	System.out.println("Rental Cost: "+cost);
        	System.out.println(x.getInsuranceDetails());
        	System.out.println(x.calculateInsurance());
        	System.out.println();
        	
        	
        	
        }
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------

interface Insurable{
	double calculateInsurance();
	String getInsuranceDetails();
}

//-------------------------------------------------------------------------------------------------------------------------------------

abstract class Vehicle implements Insurable{
	
	private String vehicleNumber;
	private String type;
	private double rentalRate;
	private String insDetails;
	
	public Vehicle(String v, String t, double r) {
		vehicleNumber = v;
		type = t;
		rentalRate = r;
	}
	
	//getters
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public String getType() {
		return type;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	
	protected String getInsurancePolicy() {
		return insDetails;
	}
	
	//setters
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	protected void setInsurancePolicy(String policyNumber) {
		insDetails = policyNumber;
	}

	abstract double calculateRentalCost(int days);
	
	public void displayVehicleDetails() {
		System.out.println("Vehicle Type: "+type);
		System.out.println("Vehicle Number: "+vehicleNumber);
		System.out.println("Rental Rate: "+rentalRate);
	}
	
}

//-------------------------------------------------------------------------------------------------------------------------------------

class Car extends Vehicle{
	private String carModel;
	
	public Car(String v, double r, String c){
		super(v,"Car",r);
		carModel = c;
		setInsurancePolicy("CAR-INS-" + v);
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}
	
	@Override
	public double calculateInsurance() {
		return getRentalRate()*0.15;
	}
	
	@Override
	public String getInsuranceDetails() {
		return getInsurancePolicy();
	}
	
	@Override
	public void displayVehicleDetails() {
		super.displayVehicleDetails();
		System.out.println("Car Model: "+carModel);
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------

class Bike extends Vehicle{
	private String bikeType;
	
	public Bike(String v, double r, String c){
		super(v,"Bike",r);
		bikeType = c;
		setInsurancePolicy("BIKE-INS-" + v);
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}
	
	@Override
	public double calculateInsurance() {
		return getRentalRate()*0.15;
	}
	
	@Override
	public String getInsuranceDetails() {
		return getInsurancePolicy();
	}
	
	@Override
	public void displayVehicleDetails() {
		super.displayVehicleDetails();
		System.out.println("Bike Type: "+bikeType);
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------

class Truck extends Vehicle{
	private float truckCapacity;
	
	public Truck(String v, double r, float tc){
		super(v,"Truck",r);
		truckCapacity = tc;
		setInsurancePolicy("TRUCK-INS-" + v);
	}
	
	public float getTruckCapacity() {
		return truckCapacity;
	}

	public void setTruckCapacity(float truckCapacity) {
		this.truckCapacity = truckCapacity;
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}
	
	@Override
	public double calculateInsurance() {
		return getRentalRate()*0.15;
	}
	
	@Override
	public String getInsuranceDetails() {
		return getInsurancePolicy();
	}
	
	@Override
	public void displayVehicleDetails() {
		super.displayVehicleDetails();
		System.out.println("Truck Capacity: "+truckCapacity);
	}
}
















