package filterstreams;

import java.io.*;

/**
 * Reads a text file and converts all uppercase letters to lowercase
 * using FileReader, BufferedReader, FileWriter, and BufferedWriter
 */
public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (FileReader fr = new FileReader(inputFile);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(outputFile);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String line;
            // Read line by line and convert to lowercase
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted to lowercase successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
