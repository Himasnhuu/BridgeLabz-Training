package Week_01.ProgrammingElements;

// This program calculates the volume of Earth in cubic kilometers and cubic miles
public class EarthVolume {
    public static void main(String[] args) {
    
        // Define Earth's radius and pi value
        double radiusKm = 6378;
        double pi = Math.PI;

        // Calculate volume using formula: (4/3) × π × radius³
        double volumeKm = (4.0 / 3) * pi * Math.pow(radiusKm, 3);
        
        // Convert volume from cubic kilometers to cubic miles
        double volumeMiles = volumeKm / Math.pow(1.6, 3);

        // Display the volume in both units
        System.out.println("The volume of earth in cubic kilometers is " +
                volumeKm + " and cubic miles is " + volumeMiles);
    }
}
