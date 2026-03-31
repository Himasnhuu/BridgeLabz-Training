package online_class_attendance_tracker;
import java.util.*;

public class AttendanceTracker {
	private Map<String, Set<String>> sessionAttendance = new HashMap<>();
	
	public void markAttendace(String sessionId, String studentId) throws DuplicateAttendanceException{
		sessionAttendance.putIfAbsent(sessionId, new HashSet<>());
		
		Set<String> students = sessionAttendance.get(sessionId);
		
		if(!students.add(studentId)) {
			throw new DuplicateAttendanceException("Student " + studentId + " has already marked attendance for session " + sessionId);
		}
		System.out.println("Attendance marked for student " + studentId + " in session " + sessionId);
	}
	
	public void removeAttendance(String sessionId, String studentId) {
		Set<String> students = sessionAttendance.get(sessionId);
		
		if(students != null && students.remove(studentId)) {
			System.out.println("Attendance removed for student " + studentId + " in session " + sessionId);
		}else {
			System.out.println("No attendance record found for student " + studentId + " in session " + sessionId);
		}
	}
	
	public void displayAttendance() {
		for (Map.Entry<String, Set<String>> entry : sessionAttendance.entrySet()) {
			System.out.println("Session " + entry.getKey() + ": " + entry.getValue());
		}
	}
}
