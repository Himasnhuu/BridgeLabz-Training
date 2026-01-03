package week2.oops.inheritence;

/*
 * Employee Management System
Description: Create an Employee hierarchy for different employee types such as Manager,
 Developer, and Intern.
Tasks:
Define a base class Employee with attributes like name, id, and salary, and a method 
displayDetails().
Define subclasses Manager, Developer, and Intern with unique attributes for each, like
 teamSize for Manager and programmingLanguage for Developer.
Goal: Practice inheritance by creating subclasses with specific attributes and 
overriding superclass methods.*/

class Employee{
	String name;
	String id;
	double salary;
	
	public Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	void displayDetails() {
		
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Salary: "+salary);
		
	}
}

class Manager extends Employee{
	int teamSize;
	
	public Manager(String name, String id, double salary, int teamSize) {
		super(name, id, salary);
		this.teamSize = teamSize;
	}
	
	void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Salary: "+salary);
		System.out.println("Team Size: "+teamSize);
	}
		
}


class Developer extends Employee{
	String pL;
	
	public Developer(String name, String id, double salary, String programmingLanguage) {
		super(name, id, salary);
		pL = programmingLanguage;
	}
	
	void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Salary: "+salary);
		System.out.println("Programming Language: "+pL);
	}
		
}


class Intern extends Employee{
	String EType;
	
	public Intern(String name, String id, double salary, String EmployeeType) {
		super(name, id, salary);
		EmployeeType = EType;
	}
	
	void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Salary: "+salary);
		System.out.println("Employee Type: "+EType);
	}
		
}



public class EmployeeManagementSystem {
	public static void main(String[] args) {
		
		Employee e = new Employee("Himanshu Patel", "gdf2345", 35000);
		Manager m = new Manager("Himanshu Patel", "gdf2345", 50000, 35);
		Developer d = new Developer("Himanshu Patel", "gdf2345", 50000, "Java");
		Intern i = new Intern("Himanshu Patel", "gdf2345", 50000, "Permanent");
		
		e.displayDetails();
		System.out.println("\n");
		
		m.displayDetails();
		System.out.println("\n");
		
		d.displayDetails();
		System.out.println("\n");
		
		i.displayDetails();
		System.out.println("\n");
		
		
	}
}
