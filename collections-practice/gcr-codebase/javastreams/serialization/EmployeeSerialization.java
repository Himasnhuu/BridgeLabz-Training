package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates object serialization by storing and retrieving
 * a list of Employee objects using ObjectOutputStream and ObjectInputStream
 */
public class EmployeeSerialization {
    public static void main(String[] args) {
        String filename = "employees.dat";

        // Create sample employee data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "John Doe", "IT", 75000));
        employees.add(new Employee(102, "Jane Smith", "HR", 65000));
        employees.add(new Employee(103, "Bob Johnson", "Finance", 70000));

        serializeEmployees(employees, filename);
        deserializeEmployees(filename);
    }

    // Serialize employee list to file
    private static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    // Deserialize employee list from file
    @SuppressWarnings("unchecked")
    private static void deserializeEmployees(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized employees:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
