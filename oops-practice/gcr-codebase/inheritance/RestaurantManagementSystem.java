package week2.oops.inheritence;

/*Sample Problem 1: Restaurant Management System with Hybrid Inheritance
Description: Model a restaurant system where Person is the superclass and Chef and Waiter are subclasses. Both Chef and Waiter should implement a Worker interface that requires a performDuties() method.
Tasks:
Define a superclass Person with attributes like name and id.
Create an interface Worker with a method performDuties().
Define subclasses Chef and Waiter that inherit from Person and implement the Worker interface, each providing a unique implementation of performDuties().
Goal: Practice hybrid inheritance by combining inheritance and interfaces, giving multiple behaviors to the same objects.*/

class Persons {
    protected String name;
    protected String id;
    
    public Persons(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Persons implements Worker {
    private String specialty;
    
    public Chef(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is preparing " + specialty + " dishes.");
    }
}

class Waiter extends Persons implements Worker {
    private int tablesServed;
    
    public Waiter(String name, String id, int tablesServed) {
        super(name, id);
        this.tablesServed = tablesServed;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving " + tablesServed + " tables.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", "CH001", "Italian");
        Waiter waiter = new Waiter("John Smith", "WT001", 5);
        
        chef.performDuties();
        waiter.performDuties();
    }
}
