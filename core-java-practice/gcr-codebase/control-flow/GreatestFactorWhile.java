package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds the greatest factor of a number beside itself using while loop
class GreatestFactorWhile {
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
            int counter = number - 1;
            
            // Find the greatest factor using while loop
            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }
            
            System.out.println("Greatest factor of " + number + " beside itself is: " + greatestFactor);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
