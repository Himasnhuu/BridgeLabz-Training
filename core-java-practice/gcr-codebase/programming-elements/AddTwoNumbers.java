package practiceProblemDay1;
import java.util.Scanner;

//This program reads two integers from the user and prints their sum
public class AddTwoNumbers {
    public static void main(String[] args) {
    	
    	// Create a Scanner object to to take user inputs
        Scanner sc = new Scanner(System.in);

        //taking user inputs
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Add the two numbers and store the result in variable sum
        int sum = a + b;
        System.out.println("Sum = " + sum);
        
        // Close the Scanner to free system resources
        sc.close();
    }
}

