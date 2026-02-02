package intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";
        List<String> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            // Read header
            String header = br.readLine();
            records.add(header);
            
            String line;
            // Process each record
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Increase IT department salary by 10%
                if (data[2].equals("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.valueOf((int) salary);
                }
                
                records.add(String.join(",", data));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        
        // Write updated records
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Updated records saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
