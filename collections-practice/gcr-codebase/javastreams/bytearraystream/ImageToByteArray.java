package bytearraystream;

import java.io.*;

/**
 * Converts an image file to byte array and back to image file
 * using ByteArrayOutputStream and ByteArrayInputStream
 */
public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "input.jpg";
        String destImage = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(sourceImage);
            System.out.println("Image converted to byte array: " + imageBytes.length + " bytes");

            // Convert byte array back to image
            byteArrayToImage(imageBytes, destImage);
            System.out.println("Byte array written to new image file");

            // Verify both images are identical
            if (verifyImages(sourceImage, destImage)) {
                System.out.println("Verification successful: Images are identical");
            } else {
                System.out.println("Verification failed: Images differ");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Read image file and convert to byte array
    private static byte[] imageToByteArray(String filename) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(filename)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Write byte array to image file
    private static void byteArrayToImage(byte[] imageBytes, String filename) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filename)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Compare two image files byte by byte
    private static boolean verifyImages(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1) {
                byte2 = fis2.read();
                if (byte1 != byte2) {
                    return false;
                }
            }
            return fis2.read() == -1;
        }
    }
}
