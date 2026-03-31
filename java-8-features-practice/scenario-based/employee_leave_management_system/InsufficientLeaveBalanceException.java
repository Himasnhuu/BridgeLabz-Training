package employee_leave_management_system;

@SuppressWarnings("serial")
class InsufficientLeaveBalanceException extends Exception {
    public InsufficientLeaveBalanceException(String message) {
        super(message);
    }
}
