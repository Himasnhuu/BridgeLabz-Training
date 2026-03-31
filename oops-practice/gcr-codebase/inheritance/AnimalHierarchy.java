package week2.oops.inheritence;

/*Animal Hierarchy
Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses. Each subclass has a unique behavior.
Tasks:
Define a superclass Animal with attributes name and age, and a method makeSound().
Define subclasses Dog, Cat, and Bird, each with a unique implementation of makeSound().
Goal: Learn basic inheritance, method overriding, and polymorphism with simple classes.*/

class Animal{
	String name;
	int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void makeSound(){
		System.out.println("Animals make sound...");
	}
	
}

class Dog extends Animal{
	
	
	public Dog(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println("Bhau Bhau.....");
	}
}

class Cat extends Animal{
	
	
	public Cat(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println("mai aau mai aau.....");
	}
}


class Bird extends Animal{
	
	
	public Bird(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println("chi chai chi chai.....");
	}
}




public class AnimalHierarchy {
	public static void main(String[] args) {
		
		System.out.println("Animal Hierarchy...............................\n");
		
		Dog d = new Dog("Yuno", 10);
		Cat c = new Cat("chingi", 8);
		Bird b = new Bird("badal", 15);
		
		System.out.println("\nKutta.............................");
		d.makeSound();
		
		System.out.println("\nBilli.............................");
		c.makeSound();
		
		System.out.println("\nChidiyaa............................");
		b.makeSound();

	}
}
