package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjects {
    static class Student {
        String id, name;
        int age, marks;
        
        Student(String id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }
        
        @Override
        public String toString() {
            return String.format("Student[id=%s, name=%s, age=%d, marks=%d]", 
                id, name, age, marks);
        }
    }
    
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            
            String line;
            // Convert each row to Student object
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], 
                    Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
            
            // Print all students
            students.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
