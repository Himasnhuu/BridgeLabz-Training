package employee_leave_management_system;
public class Employee {
	private String employeeId;
	private String name;
	private int leaveBalance;
	
	public Employee(String employeeId, String name, int leaveBalance) {
		this.employeeId = employeeId;
		this.name = name;
		this.leaveBalance = leaveBalance;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public int getLeaveBalance() {
		return leaveBalance;
	}
	
	public void deductLeave(int days) {
		if (days <= leaveBalance) {
			leaveBalance -= days;
		} else {
			System.out.println("Insufficient leave balance for " + employeeId);
		}
	}
	
	@Override
	public String toString() {
		return employeeId + " - " + name 
				+ ", Leave Balance: " + leaveBalance;
	}
}
