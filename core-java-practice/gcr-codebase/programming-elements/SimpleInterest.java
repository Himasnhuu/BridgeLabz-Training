package practiceProblemDay1;

import java.util.Scanner;

// This program calculates simple interest based on principal, rate, and time
public class SimpleInterest {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for principal, rate, and time
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();
        System.out.print("Enter Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        // Calculating simple interest using formula: (P × R × T) / 100
        double si = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + si);
        
        // Closing the Scanner class
        sc.close();
    }
}
