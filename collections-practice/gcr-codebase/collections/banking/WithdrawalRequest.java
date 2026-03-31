package banking;

public class WithdrawalRequest {
    private String accountNumber;
    private double amount;
    
    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return String.format("Withdrawal[%s, $%.2f]", accountNumber, amount);
    }
}
