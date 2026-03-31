package queue;

import java.util.*;

class Patient {
    String name;
    int severity;
    
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class HospitalTriage {
    
    public static List<String> triagePatients(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
        
        pq.addAll(patients);
        
        List<String> order = new ArrayList<>();
        while (!pq.isEmpty()) {
            order.add(pq.poll().name);
        }
        
        return order;
    }
    
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("John", 3),
            new Patient("Alice", 5),
            new Patient("Bob", 2)
        );
        
        System.out.println("Patients: " + patients);
        System.out.println("Order: " + triagePatients(patients));
    }
}
