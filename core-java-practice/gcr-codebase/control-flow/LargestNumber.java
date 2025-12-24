package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program checks which number is the largest among three numbers
class LargestNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for three numbers
        System.out.println("Enter the numbers ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        
        // Check if first number is the largest
        if (number1 > number2 && number1 > number3) {
            System.out.println("Is the first number the largest? true");
        } else {
            System.out.println("Is the first number the largest? false");
        }
        
        // Check if second number is the largest
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? true");
        } else {
            System.out.println("Is the second number the largest? false");
        }
        
        // Check if third number is the largest
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? true");
        } else {
            System.out.println("Is the third number the largest? false");
        }
        
        // Closing the Scanner class
        sc.close();
        
        
    }
}
