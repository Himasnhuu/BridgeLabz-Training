package custom_exception;

import java.util.Scanner;

public class AgeValidator {
    
    // Method that validates age and throws custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        try {
            // Call validation method
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InvalidAgeException e) {
            // Handle custom exception
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
