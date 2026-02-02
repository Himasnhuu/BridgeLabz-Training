package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateData {
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            String header = br.readLine();
            System.out.println("Validating: " + header);
            
            String line;
            int lineNum = 1;
            
            // Validate each record
            while ((line = br.readLine()) != null) {
                lineNum++;
                String[] data = line.split(",");
                
                if (data.length < 3) {
                    System.out.printf("Line %d: Invalid format%n", lineNum);
                    continue;
                }
                
                String email = data[1].trim();
                String phone = data[2].trim();
                
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.printf("Line %d: Invalid email '%s'%n", lineNum, email);
                }
                
                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.printf("Line %d: Invalid phone '%s'%n", lineNum, phone);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
