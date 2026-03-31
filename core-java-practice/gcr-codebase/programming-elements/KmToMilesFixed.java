package Week_01.ProgrammingElements;

// This program converts a fixed distance from kilometers to miles
public class KmToMilesFixed {
    public static void main(String[] args) {
    
        // Define the distance in kilometers
        double km = 10.8;
        // Convert kilometers to miles using conversion factor 1.6
        double miles = km / 1.6;

        // Display the converted distance in miles
        System.out.println("The distance " + km + " km in miles is " + miles);
    }
}
