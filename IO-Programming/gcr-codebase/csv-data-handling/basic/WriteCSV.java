package basic;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.write("ID,Name,Department,Salary\n");
            
            // Write employee records
            writer.write("1,John Doe,IT,60000\n");
            writer.write("2,Jane Smith,HR,55000\n");
            writer.write("3,Mike Johnson,Finance,65000\n");
            writer.write("4,Sarah Williams,IT,70000\n");
            writer.write("5,Tom Brown,Marketing,58000\n");
            
            System.out.println("Employee data written successfully");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
