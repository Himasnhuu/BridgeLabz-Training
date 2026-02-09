package online_class_attendance_tracker;

@SuppressWarnings("serial")
public class DuplicateAttendanceException extends Exception {
	public DuplicateAttendanceException(String message) {
		super(message);
	}
}
