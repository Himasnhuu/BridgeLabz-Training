package nested_try_catch;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        
        try {
            // Outer try-catch for array access
            int element = array[index];
            
            try {
                // Inner try-catch for division
                int result = element / divisor;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("Cannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid array index
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
