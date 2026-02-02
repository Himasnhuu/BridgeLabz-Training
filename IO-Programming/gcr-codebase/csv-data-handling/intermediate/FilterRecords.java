package intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "students.csv";
        int threshold = 80;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            
            String line;
            // Filter and print qualifying students
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);
                
                if (marks > threshold) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %d%n", 
                        data[0], data[1], data[2], marks);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
