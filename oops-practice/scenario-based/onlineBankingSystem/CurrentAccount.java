package scenariobased.oops.onlineBankingSystem;

public class CurrentAccount extends Account {
    private double overdraftLimit = 5000;
    
    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance + overdraftLimit) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Available: ₹" + balance + " | Overdraft: ₹" + overdraftLimit
            );
        }
        balance -= amount;
        transactionHistory.add(new Transaction("WITHDRAWAL", amount, balance));
        System.out.println("✓ Withdrawn ₹" + amount + " successfully!");
    }
    
    @Override
    public void calculateInterest() {
        System.out.println("Current accounts do not earn interest.");
    }
}
