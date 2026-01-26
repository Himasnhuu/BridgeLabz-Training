package bufferedstreams;

import java.io.*;

/**
 * Compares performance between buffered and unbuffered streams
 * when copying large files
 */
public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destFile = "largefile_copy.txt";
        int bufferSize = 4096;

        System.out.println("Copying with buffered streams...");
        long bufferedTime = copyWithBufferedStreams(sourceFile, destFile, bufferSize);
        System.out.println("Buffered streams time: " + bufferedTime + " ms");

        System.out.println("\nCopying with unbuffered streams...");
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destFile);
        System.out.println("Unbuffered streams time: " + unbufferedTime + " ms");

        System.out.println("\nPerformance improvement: " + 
            (unbufferedTime - bufferedTime) + " ms faster");
    }

    // Copy file using buffered streams with 4KB chunks
    private static long copyWithBufferedStreams(String source, String dest, int bufferSize) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }

    // Copy file byte by byte without buffering
    private static long copyWithUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }
}
