package Week_01.javaMethods.level2;

public class MultiUnitConvertor {
    
    //Method to convert Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }
    
    //Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }
    
    //Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    
    //Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    
    //Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    
    //Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    
    public static void main(String[] args) {
        
        // Temperature conversions
        System.out.println("Temperature");
        double fahrenheit = 100;
        System.out.println(fahrenheit + "°F = " + convertFarhenheitToCelsius(fahrenheit) + "°C");
        
        double celsius = 37;
        System.out.println(celsius + "°C = " + convertCelsiusToFarhenheit(celsius) + "°F");
        
        // Weight conversions
        System.out.println("\nWeight");
        double pounds = 150;
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        
        double kilograms = 70;
        System.out.println(kilograms + " kg = " + convertKilogramsToPounds(kilograms) + " lbs");
        
        // Volume conversions
        System.out.println("\nVolume");
        double gallons = 5;
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
        
        double liters = 20;
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
    }
}
