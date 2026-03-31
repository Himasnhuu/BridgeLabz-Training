package hospitalpatientid;

import java.util.*;

public class HospitalPatientIdPrinting {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("P001", "John Doe"));
        patients.add(new Patient("P002", "Jane Smith"));
        patients.add(new Patient("P003", "Bob Johnson"));
        patients.add(new Patient("P004", "Alice Brown"));
        patients.add(new Patient("P005", "Charlie Davis"));
        
        System.out.println("=== Hospital Patient ID Printing ===\n");
        
        System.out.println("Admin Verification - All Patient IDs:");
        System.out.println("--------------------------------------");
        
        // Using method reference instead of lambda
        // Instead of: patients.forEach(p -> p.printId());
        // We use: patients.forEach(Patient::printId);
        patients.forEach(Patient::printId);
        
        System.out.println("\n--- Alternative: Printing IDs using getter method reference ---");
        // Using method reference with getter
        patients.stream()
            .map(Patient::getPatientId)
            .forEach(System.out::println);
    }
}
