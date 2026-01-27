package checked_exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            // Attempt to read the file
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            // Handle file not found or other IO errors
            System.out.println("File not found");
        }
    }
}
