package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptCSV {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "MySecretKey12345"; // 16 chars for AES-128
    
    // Encrypt data
    private static String encrypt(String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }
    
    // Decrypt data
    private static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
    
    // Write encrypted CSV
    public static void writeEncrypted(String file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("ID,Name,Department,Salary,Email\n");
            
            // Encrypt sensitive fields
            String salary = encrypt("60000");
            String email = encrypt("john@example.com");
            
            writer.write(String.format("1,John Doe,IT,%s,%s\n", salary, email));
            System.out.println("Encrypted data written");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    // Read and decrypt CSV
    public static void readDecrypted(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println(br.readLine()); // Header
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String salary = decrypt(data[3]);
                String email = decrypt(data[4]);
                System.out.printf("%s, %s, %s, Salary: %s, Email: %s%n",
                    data[0], data[1], data[2], salary, email);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String file = "employees_encrypted.csv";
        writeEncrypted(file);
        readDecrypted(file);
    }
}
