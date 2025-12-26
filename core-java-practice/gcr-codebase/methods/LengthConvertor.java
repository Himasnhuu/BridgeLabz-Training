package Week_01.javaMethods.level2;

public class LengthConvertor {
    
    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    
    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    
    // c. Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    
    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    
    // Method to convert inches to centimeters
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    
    public static void main(String[] args) {

        //  Yards to feet
        double yards = 10;
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
        
        // Feet to yards
        double feet = 15;
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
        
        // Meters to inches
        double meters = 5;
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
        
        // Inches to meters
        double inches = 100;
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        
        // Inches to centimeters
        double inch = 10;
        System.out.println(inch + " inches = " + convertInchesToCm(inch) + " cm");
    }
}
