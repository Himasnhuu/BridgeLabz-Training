package online_class_attendance_tracker;

public class Main {
	public static void main(String[] args) {
		AttendanceTracker tracker = new AttendanceTracker();
		
		try {
			tracker.markAttendace("session1", "student1");
			tracker.markAttendace("session1", "student2");
			tracker.markAttendace("session1", "student1"); 
			
			tracker.markAttendace("session1", "student1");
		} catch (DuplicateAttendanceException e) {
			System.err.println(e.getMessage());
		}
		
		tracker.removeAttendance("session1", "student2");
		
		System.out.println("\nFinal Attendance Records:");
		tracker.displayAttendance();
	}
}
