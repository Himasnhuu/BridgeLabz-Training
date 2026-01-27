package try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
            
        } catch (IOException e) {
            // Handle file not found or read errors
            System.out.println("Error reading file");
        }
    }
}
