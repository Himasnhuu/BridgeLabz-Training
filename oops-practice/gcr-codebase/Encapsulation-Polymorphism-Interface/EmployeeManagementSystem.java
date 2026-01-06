package week2.oops.encapsulation;

/*1. Employee Management System
Description: Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference.*/

//-------------------------------------------------------------------------------------------------------------------------

interface Department {
	public void assignDepartment(String department);

	String getDepartmentDetails();
}

//-------------------------------------------------------------------------------------------------------------------------

abstract class Employee implements Department {
	private String employeeId;
	private String name;
	private double baseSalary;
	private String department;

	public Employee(String e, String n, double s, String d) {
		employeeId = e;
		name = n;
		baseSalary = s;
		department = d;
	}

	// abstract method
	public abstract double calculateSalary();

	// concrete method
	public void displayDetails() {
		System.out.println("Employee ID: " + employeeId);
		System.out.println("Employee Name: " + name);
		System.out.println("Base Salary: " + baseSalary);
		System.out.println("Employee Department: " +department);
		System.out.println("Total Salary: " + calculateSalary());
	}

	// interface methods
	@Override
	public void assignDepartment(String d) {
		department = d;
	}

	@Override
	public String getDepartmentDetails() {
		return department != null ? department : "not assigned";
	}

	// getters

	public String getEmpId() {
		return employeeId;
	}

	public String getEmpName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	// setters

	public void setEmpId(String e) {
		employeeId = e;
	}

	public void setEmpName(String s) {
		name = s;
	}

	public void setBaseSalary(double b) {
		baseSalary = b;
	}

}

//------------------------------------------------------------------------------------------------------------------------------
class FullTimeEmployee extends Employee {

	double bonus;

	public FullTimeEmployee(String e, String n, double s,String d , double b) {
		super(e, n, s, d);
		bonus = b;
	}

	@Override
	public double calculateSalary() {

		return getBaseSalary() + bonus;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("FULL-TIME EMPLOYEE....");
		super.displayDetails();
		System.out.println("Bonus: " + bonus);
		System.out.println("Total Salary: " + calculateSalary());
	}
	

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}

//----------------------------------------------------------------------------------------------------------------------------------

class PartTimeEmployee extends Employee {
	private int hrsWorked;
	private double hourlyRate;

	public PartTimeEmployee(String e, String n, double s,String d, int hw) {
		super(e, n, s, d);
		hrsWorked = hw;
		hourlyRate = s / 9;
	}

	// abstract method
	@Override
	public double calculateSalary() {
		return hrsWorked * hourlyRate;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("PART-TIME EMPLOYEE.....");
		super.displayDetails();
		System.out.println("Employee Working Hours: "+hrsWorked);
		System.out.println("Employee Hourly Rate: "+hourlyRate);
	}
	
	//getters
	public int getHrsWorked() {
		return hrsWorked;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	//setters
	public void setHrsWorked(int h) {
		hrsWorked = h;
	}

}

//main class
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		
		FullTimeEmployee f = new FullTimeEmployee("dj43jhbhj34", "Himanshu Patel", 35000, "Electrical", 5000);
		
		PartTimeEmployee p = new PartTimeEmployee("dj43jhbhj34", "Himanshu Patel", 35000, "Mechanical", 4);
		
		f.displayDetails();
		System.out.println();
		p.displayDetails();
		
	}
}
//---------------------------------------------------------------------------------------------------------------
