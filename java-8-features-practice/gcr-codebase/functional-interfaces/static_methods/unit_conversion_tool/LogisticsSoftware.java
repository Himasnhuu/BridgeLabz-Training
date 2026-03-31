package static_methods.unit_conversion_tool;

public class LogisticsSoftware {
    
    public static void main(String[] args) {
        double distanceKm = 100;
        double weightKg = 50;
        
        System.out.println(distanceKm + " km = " + 
                          UnitConverter.kmToMiles(distanceKm) + " miles");
        System.out.println(weightKg + " kg = " + 
                          UnitConverter.kgToLbs(weightKg) + " lbs");
    }
}
