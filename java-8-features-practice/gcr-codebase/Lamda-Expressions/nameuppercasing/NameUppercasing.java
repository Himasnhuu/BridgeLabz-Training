package nameuppercasing;

import java.util.*;
import java.util.stream.Collectors;

public class NameUppercasing {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("john doe", "Engineering"));
        employees.add(new Employee("jane smith", "Marketing"));
        employees.add(new Employee("bob johnson", "Sales"));
        employees.add(new Employee("alice brown", "HR"));
        employees.add(new Employee("charlie davis", "Finance"));
        
        System.out.println("=== Name Uppercasing for HR Letter ===\n");
        
        System.out.println("Original Employee Names:");
        employees.forEach(System.out::println);
        
        System.out.println("\n--- Using String::toUpperCase Method Reference ---");
        
        // Convert all names to uppercase using method reference
        // Instead of: .map(name -> name.toUpperCase())
        // We use: .map(String::toUpperCase)
        List<String> uppercaseNames = employees.stream()
            .map(Employee::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        System.out.println("\nUppercased Names for HR Letter:");
        uppercaseNames.forEach(System.out::println);
        
        System.out.println("\n--- Formatted for Official Letter ---");
        employees.stream()
            .map(Employee::getName)
            .map(String::toUpperCase)
            .forEach(name -> System.out.println("Dear " + name + ","));
    }
}
