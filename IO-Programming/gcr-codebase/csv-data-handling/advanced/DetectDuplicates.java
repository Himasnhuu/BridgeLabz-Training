package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> seenIds = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            
            String line;
            // Detect duplicates based on ID
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                
                if (!seenIds.add(id)) {
                    System.out.println("Duplicate ID found: " + line);
                }
            }
            
            if (seenIds.size() > 0) {
                System.out.println("\nTotal unique IDs: " + seenIds.size());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
