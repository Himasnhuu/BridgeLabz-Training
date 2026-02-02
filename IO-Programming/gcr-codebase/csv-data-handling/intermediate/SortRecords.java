package intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortRecords {
    static class Employee {
        String id, name, department;
        int salary;
        
        Employee(String id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }
    
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            
            String line;
            // Read employees
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(new Employee(data[0], data[1], data[2], 
                    Integer.parseInt(data[3])));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        
        // Sort by salary descending
        Collections.sort(employees, Comparator.comparingInt(e -> -e.salary));
        
        // Print top 5
        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.printf("%s - %s (%s): $%d%n", e.id, e.name, e.department, e.salary);
        }
    }
}
