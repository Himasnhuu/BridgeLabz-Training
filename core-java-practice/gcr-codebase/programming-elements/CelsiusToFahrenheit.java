package practiceProblemDay1;

import java.util.Scanner;

// This program converts temperature from Celsius to Fahrenheit
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Converting Celsius to Fahrenheit using formula
        double fahrenheit = (celsius * 9 / 5) + 32;
        
        System.out.println("Temperature in Fahrenheit = " + fahrenheit);
        
        // Closing the Scanner class
        sc.close();
    }
}
