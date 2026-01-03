package week2.oops.inheritence;

/*Vehicle and Transport System
Description: Design a vehicle hierarchy where Vehicle is the superclass, and Car, 
Truck, and Motorcycle are subclasses with unique attributes.
Tasks:
Define a superclass Vehicle with maxSpeed and fuelType attributes and a method 
displayInfo().
Define subclasses Car, Truck, and Motorcycle, each with additional attributes,
 such as seatCapacity for Car.
Demonstrate polymorphism by storing objects of different subclasses in an array of 
Vehicle type and calling displayInfo() on each.
Goal: Understand how inheritance helps in organizing shared and unique features across
 subclasses and use polymorphism for dynamic method calls.
*/

class Vehicle{
	int maxSpeed;
	String fuelType;
	String company;
	String model;
	
	public Vehicle(int maxSpeed, String fuelType, String company, String model) {
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
		this.company = company;
		this.model = model;
	}
	
	void displayInfo() {
		System.out.println("Max Speed: "+maxSpeed);
		System.out.println("Fuel Type: "+fuelType);
		System.out.println("Company: "+company);
		System.out.println("Model: "+model);
		
		
	}
	
}

class Car extends Vehicle{
	int seatCapacity;
	int nOfDoors;
	
	public Car(int maxSpeed, String fuelType, String company, String model, int seatCapacity, int nOfDoors) {
		super(maxSpeed, fuelType, company, model);
		this.seatCapacity = seatCapacity;
		this.nOfDoors = nOfDoors;
	}
	
	@Override
	void displayInfo() {
		System.out.println("Max Speed: "+maxSpeed);
		System.out.println("Fuel Type: "+fuelType);
		System.out.println("Company: "+company);
		System.out.println("Model: "+model);
		System.out.println("Seat Capacity: "+seatCapacity);
		System.out.println("Number of Doors: "+maxSpeed);
		
	}
	
	
}

class Truck extends Vehicle{
	double loadCapacity;
	boolean hasSleeper;
	
	public Truck(int maxSpeed, String fuelType, String company, String model, double x, boolean y) {
		super(maxSpeed, fuelType, company, model);
		loadCapacity = x;
		hasSleeper = y;
	}
	
	@Override
	void displayInfo() {
		System.out.println("Max Speed: "+maxSpeed);
		System.out.println("Fuel Type: "+fuelType);
		System.out.println("Company: "+company);
		System.out.println("Model: "+model);
		System.out.println("Load Capacity: "+loadCapacity);
		System.out.println("Sleeping facility: "+hasSleeper);
		
	}
	
}

class MotarCycle extends Vehicle{
	int seatCapacity;
	String mType;
	
	
	public MotarCycle(int maxSpeed, String fuelType, String company, String model, int seatCapacity, String x) {
		super(maxSpeed, fuelType, company, model);
		this.seatCapacity = seatCapacity;
		this.mType = x;
	}
	
	@Override
	void displayInfo() {
		System.out.println("Max Speed: "+maxSpeed);
		System.out.println("Fuel Type: "+fuelType);
		System.out.println("Company: "+company);
		System.out.println("Model: "+model);
		System.out.println("Seat Capacity: "+seatCapacity);
		System.out.println("MotarCycle Type: "+mType);
		
	}
	
	
}


public class VehicleAndTransportSystem {
	public static void main(String[] args) {
		
		Vehicle v = new Vehicle(80, "Petrol", "Maruti", "Dezire");
		Car c = new Car(120, "Petrol", "Maruti", "Dezire", 5, 4);
		Truck t = new Truck(80, "Desiel", "TATA", "FH16", 220, true);
		MotarCycle m = new MotarCycle(140, "Petrol", "Royal Enfield", "Classic",2, "Bullet");
		
		Vehicle [] vArray = {v, c, t, m};
		
		for(Vehicle x:vArray) {
			x.displayInfo();
			System.out.println();
		}
		
	}
}
