package notificationfiltering;

import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface AlertFilter {
    boolean test(PatientAlert alert);
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<PatientAlert> allAlerts = new ArrayList<>();
        allAlerts.add(new PatientAlert("John Doe", "Medication Due", "LOW", "Cardiology"));
        allAlerts.add(new PatientAlert("Jane Smith", "Critical Vitals", "HIGH", "ICU"));
        allAlerts.add(new PatientAlert("Bob Johnson", "Lab Results Ready", "MEDIUM", "Oncology"));
        allAlerts.add(new PatientAlert("Alice Brown", "Emergency", "CRITICAL", "ER"));
        allAlerts.add(new PatientAlert("Charlie Davis", "Appointment Reminder", "LOW", "Cardiology"));
        allAlerts.add(new PatientAlert("Eva Wilson", "Surgery Scheduled", "HIGH", "Surgery"));
        allAlerts.add(new PatientAlert("Frank Miller", "Discharge Ready", "MEDIUM", "General"));
        
        System.out.println("=== Hospital Notification Filtering ===\n");
        
        System.out.println("All Alerts:");
        allAlerts.forEach(System.out::println);
        
        // Filter using custom functional interface
        System.out.println("\n--- Critical & High Severity ---");
        AlertFilter criticalAndHigh = alert -> 
            alert.getSeverity().equals("CRITICAL") || alert.getSeverity().equals("HIGH");
        
        allAlerts.stream()
            .filter(alert -> criticalAndHigh.test(alert))
            .forEach(System.out::println);
        
        System.out.println("\n--- ICU & ER Departments ---");
        AlertFilter icuAndEr = alert -> 
            alert.getDepartment().equals("ICU") || alert.getDepartment().equals("ER");
        
        allAlerts.stream()
            .filter(alert -> icuAndEr.test(alert))
            .forEach(System.out::println);
    }
}
