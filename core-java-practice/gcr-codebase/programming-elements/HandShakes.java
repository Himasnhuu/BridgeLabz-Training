package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program calculates the maximum number of handshakes among n students
public class HandShakes {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Calculate total handshakes
        int handshakes = (n * (n - 1)) / 2;
        
        // Display the maximum number of handshakes
        System.out.println("Maximum number of handshakes is " + handshakes);
        
        // Closing the Scanner class
        sc.close();
    }
}
