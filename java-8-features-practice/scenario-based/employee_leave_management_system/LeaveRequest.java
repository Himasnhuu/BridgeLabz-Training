package employee_leave_management_system;

public class LeaveRequest {
	private String employeeId;
	private int days;
	private String status;
	
	public LeaveRequest(String employeeId, int days) {
		this.employeeId = employeeId;
		this.days = days;
		this.status = "Pending";
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Employee ID: " + employeeId 
				+ ", Days: " + days 
				+ ", Status: " + status;
	}
}
