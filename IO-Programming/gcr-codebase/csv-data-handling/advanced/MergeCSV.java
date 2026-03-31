package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";
        
        Map<String, String[]> students = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            // Skip header and read students1.csv (ID, Name, Age)
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.put(data[0], new String[]{data[0], data[1], data[2], "", ""});
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            // Skip header and read students2.csv (ID, Marks, Grade)
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (students.containsKey(data[0])) {
                    students.get(data[0])[3] = data[1];
                    students.get(data[0])[4] = data[2];
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file2: " + e.getMessage());
            return;
        }
        
        // Write merged data
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (String[] student : students.values()) {
                writer.write(String.join(",", student) + "\n");
            }
            System.out.println("Files merged successfully to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
