package week2.oops.encapsulation;

/*7. Hospital Patient Management
Description: Design a system to manage patients in a hospital:
Create an abstract class Patient with fields like patientId, name, and age.
Add an abstract method calculateBill() and a concrete method getPatientDetails().
Extend it into subclasses InPatient and OutPatient, implementing calculateBill() with different billing logic.
Implement an interface MedicalRecord with methods addRecord() and viewRecords().
Use encapsulation to protect sensitive patient data like diagnosis and medical history.
Use polymorphism to handle different patient types and display their billing details dynamically.*/

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    protected String getDiagnosis() {
        return diagnosis;
    }
    
    protected void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    protected String getMedicalHistory() {
        return medicalHistory;
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int numberOfDays;
    private double roomChargePerDay;
    private StringBuilder records;
    
    public InPatient(String patientId, String name, int age, int numberOfDays, double roomChargePerDay) {
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.roomChargePerDay = roomChargePerDay;
        this.records = new StringBuilder();
    }
    
    @Override
    public double calculateBill() {
        double roomCharges = numberOfDays * roomChargePerDay;
        double medicalCharges = 500.0;
        return roomCharges + medicalCharges;
    }
    
    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        System.out.println(records.length() > 0 ? records.toString() : "No records available");
    }
    
    @Override
    public void getPatientDetails() {
        System.out.println("\n--- In-Patient Details ---");
        super.getPatientDetails();
        System.out.println("Type: In-Patient");
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Room Charge Per Day: $" + roomChargePerDay);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private int numberOfVisits;
    private double consultationFee;
    private StringBuilder records;
    
    public OutPatient(String patientId, String name, int age, int numberOfVisits, double consultationFee) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
        this.consultationFee = consultationFee;
        this.records = new StringBuilder();
    }
    
    @Override
    public double calculateBill() {
        return numberOfVisits * consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        System.out.println(records.length() > 0 ? records.toString() : "No records available");
    }
    
    @Override
    public void getPatientDetails() {
        System.out.println("\n--- Out-Patient Details ---");
        super.getPatientDetails();
        System.out.println("Type: Out-Patient");
        System.out.println("Number of Visits: " + numberOfVisits);
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

// Main class
public class HospitalPatientManagement {
    
    public static void main(String[] args) {
        System.out.println("========== HOSPITAL PATIENT MANAGEMENT ==========");
        
        // Create patients
        InPatient inPatient = new InPatient("IP001", "John Doe", 45, 5, 150.0);
        OutPatient outPatient = new OutPatient("OP001", "Jane Smith", 30, 3, 75.0);
        
        // Add medical records
        inPatient.addRecord("Admitted with fever - 01/01/2026");
        inPatient.addRecord("X-ray done - 02/01/2026");
        inPatient.addRecord("Prescribed antibiotics - 03/01/2026");
        
        outPatient.addRecord("Consultation for headache - 01/01/2026");
        outPatient.addRecord("Follow-up visit - 03/01/2026");
        
        // Display patient details
        inPatient.getPatientDetails();
        System.out.println();
        inPatient.viewRecords();
        
        outPatient.getPatientDetails();
        System.out.println();
        outPatient.viewRecords();
        
        // Polymorphism demonstration
        System.out.println("\n========== BILLING SUMMARY ==========");
        Patient[] patients = {inPatient, outPatient};
        
        double totalRevenue = 0;
        for (Patient patient : patients) {
            System.out.println("\nPatient: " + patient.getName());
            System.out.println("Type: " + patient.getClass().getSimpleName());
            double bill = patient.calculateBill();
            System.out.println("Bill Amount: $" + bill);
            totalRevenue += bill;
        }
        
        System.out.println("\nTotal Hospital Revenue: $" + totalRevenue);
    }
}
