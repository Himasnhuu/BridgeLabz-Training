package employee_leave_management_system;
import java.util.*;

public class LeaveManagementService {
	
	private Map<String, Employee> employees = new HashMap<>();
	private List<LeaveRequest> leaveRequests = new ArrayList<>();
	
	public void addEmployee(Employee emp) {
		employees.put(emp.getEmployeeId(), emp);
	}
	
	public void applyLeave(String empId, int days) 
	throws InsufficientLeaveBalanceException{
		Employee emp = employees.get(empId);
		
		if(emp.getLeaveBalance() < days) {
			throw new InsufficientLeaveBalanceException("Employee " 
		+ empId + " has insufficient leave balance.");
		}
		
		LeaveRequest request = new LeaveRequest(empId, days);
		leaveRequests.add(request);
	}
	
	public void approveLeave(int index) {
		LeaveRequest req = leaveRequests.get(index);
		Employee emp = employees.get(req.getEmployeeId());
		
		emp.deductLeave(req.getDays());
		req.setStatus("Approved");
	}
	
	public void rejectLeave(int index) {
		LeaveRequest req = leaveRequests.get(index);
		req.setStatus("Rejected");
	}
	
	public void showRequests() {
		leaveRequests.forEach(System.out::println);
	}
}
