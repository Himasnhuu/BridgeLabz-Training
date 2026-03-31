package week9.online_doctor_consultation_scheduler;

import java.time.LocalDateTime;

public class DoctorApp {
	public static void main(String[] args) throws Exception {

		SchedulerService service = new SchedulerService();

		Doctor d1 = new Doctor(1, "Dr. Rao", Specialization.CARDIOLOGY);
		Patient p1 = new Patient(101, "Nitish");

		service.addDoctor(d1);

		LocalDateTime slot = LocalDateTime.of(2026, 2, 20, 10, 0);

		service.bookAppointment(d1, p1, slot);
//		service.bookAppointment(d1, p1, slot);

		service.showHistory();
	}
}
