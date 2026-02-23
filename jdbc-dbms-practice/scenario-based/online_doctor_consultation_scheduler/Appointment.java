package week9.online_doctor_consultation_scheduler;
import java.time.LocalDateTime;

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;

    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment [Doctor=" + doctor.getName() +
               ", Patient=" + patient.getName() +
               ", Time=" + dateTime + "]";
    }
}
