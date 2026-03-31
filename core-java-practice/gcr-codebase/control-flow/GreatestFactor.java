package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds the greatest factor of a number beside itself using for loop
class GreatestFactor {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        int greatestFactor = 1;
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            // Find the greatest factor from number-1 down to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            
            System.out.println("Greatest factor of " + number + " beside itself is: " + greatestFactor);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
