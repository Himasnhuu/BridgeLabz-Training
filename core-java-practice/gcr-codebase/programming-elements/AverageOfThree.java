package practiceProblemDay1;
import java.util.Scanner;

// This program calculates the average of three numbers entered by the user
public class AverageOfThree {
    public static void main(String[] args) {
    	
        // Create a Scanner object to take user inputs
        Scanner sc = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Enter third number: ");
        double c = sc.nextDouble();

        // Calculating the average
        double average = (a + b + c) / 3;
        // Display the calculated average
        System.out.println("Average = " + average);
        
        // Closing the Scanner class
        sc.close();
    }
}
