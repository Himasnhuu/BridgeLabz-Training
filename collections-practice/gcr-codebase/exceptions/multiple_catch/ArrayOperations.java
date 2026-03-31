package multiple_catch;

import java.util.Scanner;

public class ArrayOperations {
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
        
        System.out.print("Enter index to access: ");
        int index = scanner.nextInt();
        
        try {
            // Attempt to access array element
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle out of bounds index
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handle null array
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
