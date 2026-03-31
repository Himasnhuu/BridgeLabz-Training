package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int chunkSize = 100;
        int count = 0;
        int totalProcessed = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            
            String line;
            // Process in chunks
            while ((line = br.readLine()) != null) {
                count++;
                
                // Process chunk
                if (count == chunkSize) {
                    totalProcessed += count;
                    System.out.println("Processed " + totalProcessed + " records");
                    count = 0;
                }
            }
            
            // Process remaining records
            if (count > 0) {
                totalProcessed += count;
                System.out.println("Processed " + totalProcessed + " records");
            }
            
            System.out.println("Total records processed: " + totalProcessed);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
