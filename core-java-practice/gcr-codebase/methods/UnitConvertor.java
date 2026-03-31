
/*Extend or Create a UnitConvertor utility class similar to the one shown
 *  in the notes to do the following. 
 *  Please define static methods for all the UnitConvertor class methods. E.g. 
public static double convertKmToMiles(double km) => 
Method To convert kilometers to miles and return the value. Use the following 
code  double km2miles = 0.621371;
Method to convert miles to kilometers and return the value. Use the following
 code  double miles2km = 1.60934;
Method to convert meters to feet and return the value. Use the following code
 to convert  double meters2feet = 3.28084;
Method to convert feet to meters and return the value. Use the following code 
 to convert  double feet2meters = 0.3048;*/

package Week_01.javaMethods.level2;

public class UnitConvertor {
    
    // a. Method to convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    
    // b. Method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    
    // c. Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    
    // d. Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    
    public static void main(String[] args) {
        // Test all conversion methods
        
        // a. Kilometers to miles
        double km = 10;
        double miles = convertKmToMiles(km);
        System.out.println(km + " km = " + miles + " miles");
        
        // b. Miles to kilometers
        double mi = 10;
        double kilometers = convertMilesToKm(mi);
        System.out.println(mi + " miles = " + kilometers + " km");
        
        // c. Meters to feet
        double m = 100;
        double feet = convertMetersToFeet(m);
        System.out.println(m + " meters = " + feet + " feet");
        
        // d. Feet to meters
        double ft = 100;
        double meters = convertFeetToMeters(ft);
        System.out.println(ft + " feet = " + meters + " meters");
    }
}
