package notificationfiltering;

class PatientAlert {
    private String patientName;
    private String alertType;
    private String severity;
    private String department;
    
    public PatientAlert(String patientName, String alertType, String severity, String department) {
        this.patientName = patientName;
        this.alertType = alertType;
        this.severity = severity;
        this.department = department;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public String getAlertType() {
        return alertType;
    }
    
    public String getSeverity() {
        return severity;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - Patient: %s (%s)", 
                           severity, alertType, patientName, department);
    }
}
