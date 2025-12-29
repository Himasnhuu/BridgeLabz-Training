package Week_01.javaMethods.extras;
import java.util.Scanner;

public class TemperatureConverter {
    
    public static void main(String[] args) {
        
        System.out.println("TEMPERATURE CONVERTER\n");
        
        // take input and choice
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        
        // perform conversion based on choice
        if (choice == 1) {
            double fahrenheit = getTemperature(sc, "Fahrenheit");
            double celsius = fahrenheitToCelsius(fahrenheit);
            displayResult(fahrenheit, "°F", celsius, "°C");
        } else if (choice == 2) {
            double celsius = getTemperature(sc, "Celsius");
            double fahrenheit = celsiusToFahrenheit(celsius);
            displayResult(celsius, "°C", fahrenheit, "°F");
        } else {
            System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
    
    // method to get temperature input
    static double getTemperature(Scanner sc, String unit) {
        System.out.print("Enter temperature in " + unit + ": ");
        return sc.nextDouble();
    }
    
    // method to convert Fahrenheit to Celsius
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
    
    // method to convert Celsius to Fahrenheit
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
    
    // method to display conversion result
    static void displayResult(double input, String inputUnit, double output, String outputUnit) {
        System.out.printf("\n%.2f%s = %.2f%s\n", input, inputUnit, output, outputUnit);
    }
}
