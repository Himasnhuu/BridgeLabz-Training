package largefile;

import java.io.*;

/**
 * Efficiently reads a large text file line by line
 * and displays only lines containing the word "error"
 */
public class ReadLargeFile {
    public static void main(String[] args) {
        String filename = "largefile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            // Read line by line without loading entire file
            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Case-insensitive search for "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
