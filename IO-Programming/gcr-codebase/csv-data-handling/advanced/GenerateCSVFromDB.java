package advanced;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSVFromDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "password";
        String outputFile = "employees_report.csv";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
             FileWriter writer = new FileWriter(outputFile)) {
            
            // Write header
            writer.write("Employee ID,Name,Department,Salary\n");
            
            // Write data from database
            while (rs.next()) {
                writer.write(String.format("%d,%s,%s,%.2f\n",
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")));
            }
            
            System.out.println("CSV report generated: " + outputFile);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
