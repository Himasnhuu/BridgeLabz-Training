package Week_01.javaMethods.level2;
import java.util.Scanner;

public class NumberAnalysis {
    
    // method to check if number is positive or negative
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    
    // method to check if number is even or odd
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    // method to compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        
        // take user input for 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        
        
        // loop through array and analyze each number
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("\nNumber " + (i + 1) + ": " + numbers[i]);
            
            // check if positive or negative
            if (isPositive(numbers[i])) {
                System.out.println("  Positive");
                
                // if positive, check even or odd
                if (isEven(numbers[i])) {
                    System.out.println("  Even");
                } else {
                    System.out.println("  Odd");
                }
            } else {
                System.out.println("  Negative");
            }
        }
        
        // compare first and last element
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        
        System.out.println("\nFirst element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);
        
        if (result == 1) {
            System.out.println("First element is greater than last element");
        } else if (result == 0) {
            System.out.println("First element is equal to last element");
        } else {
            System.out.println("First element is less than last element");
        }
        
        sc.close();
    }
}
