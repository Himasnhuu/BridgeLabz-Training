package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds all multiples of a number below 100 using while loop
class MultiplesBelow100While {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100!");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");
            
            int counter = 99;
            
            // Find multiples using while loop
            while (counter >= 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
