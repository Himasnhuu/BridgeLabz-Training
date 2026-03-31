package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONToCSV {
    // Convert JSON to CSV (simple parser for basic JSON array format)
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             FileWriter writer = new FileWriter(csvFile)) {
            
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line.trim());
            }
            
            // Write header
            writer.write("ID,Name,Age,Grade\n");
            
            // Parse JSON manually (basic implementation)
            String jsonStr = json.toString();
            String[] objects = jsonStr.split("\\},\\s*\\{");
            
            for (String obj : objects) {
                obj = obj.replaceAll("[\\[\\]\\{\\}]", "").trim();
                String id = extractValue(obj, "id");
                String name = extractValue(obj, "name");
                String age = extractValue(obj, "age");
                String grade = extractValue(obj, "grade");
                
                if (!id.isEmpty()) {
                    writer.write(String.format("%s,%s,%s,%s\n", id, name, age, grade));
                }
            }
            
            System.out.println("JSON converted to CSV");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    // Extract value from JSON string
    private static String extractValue(String json, String key) {
        String pattern = "\"" + key + "\"\\s*:\\s*\"?([^,\"\\}]+)\"?";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(json);
        return m.find() ? m.group(1).trim() : "";
    }
    
    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             FileWriter writer = new FileWriter(jsonFile)) {
            
            // Skip header
            br.readLine();
            
            writer.write("[\n");
            String line;
            boolean first = true;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!first) {
                    writer.write(",\n");
                }
                writer.write("  {\n");
                writer.write(String.format("    \"id\": \"%s\",\n", data[0]));
                writer.write(String.format("    \"name\": \"%s\",\n", data[1]));
                writer.write(String.format("    \"age\": %s,\n", data[2]));
                writer.write(String.format("    \"grade\": \"%s\"\n", data[3]));
                writer.write("  }");
                first = false;
            }
            
            writer.write("\n]");
            System.out.println("CSV converted to JSON");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        jsonToCsv("students.json", "students_from_json.csv");
        csvToJson("students.csv", "students_from_csv.json");
    }
}
