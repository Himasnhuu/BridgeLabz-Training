package employee_leave_management_system;

public class Main {
	public static void main(String[] args) {
		try {
			LeaveManagementService service = new LeaveManagementService();
			
			service.addEmployee(new Employee("E001", "Aman", 15));
			service.addEmployee(new Employee("E002", "Riya", 10));
			
			service.applyLeave("E001", 5);
			service.applyLeave("E002", 2); 
			
			service.approveLeave(0);
			service.rejectLeave(1);
			
			service.showRequests();
		} catch (InsufficientLeaveBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
