package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Demonstrates reading from a text file and writing to another file
 * using FileInputStream and FileOutputStream
 */
public class FileHandling {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        // Try-with-resources ensures streams are closed automatically
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
