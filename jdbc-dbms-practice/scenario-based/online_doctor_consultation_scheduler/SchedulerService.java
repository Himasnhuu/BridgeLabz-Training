package week9.online_doctor_consultation_scheduler;
import java.time.LocalDateTime;
import java.util.*;

class SchedulerService {

    private Map<Specialization, List<Doctor>> doctorMap = new HashMap<>();
    private Map<Doctor, List<LocalDateTime>> bookedSlots = new HashMap<>();
    private List<Appointment> history = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctorMap.computeIfAbsent(doctor.getSpecialization(), k -> new ArrayList<>()).add(doctor);
        bookedSlots.putIfAbsent(doctor, new ArrayList<>());
    }

    public void bookAppointment(Doctor doctor, Patient patient, LocalDateTime slot)
            throws SlotUnavailableException {

        List<LocalDateTime> slots = bookedSlots.get(doctor);

        if (slots.contains(slot)) {
            throw new SlotUnavailableException("Slot already booked for doctor: " + doctor.getName());
        }

        slots.add(slot);
        history.add(new Appointment(doctor, patient, slot));
    }

    public void showHistory() {
        history.forEach(System.out::println);
    }
}
