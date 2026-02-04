package hospitalpatientid;

class Patient {
    private String patientId;
    private String name;
    
    public Patient(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    // Method to print patient ID
    public void printId() {
        System.out.println("Patient ID: " + patientId);
    }
}
