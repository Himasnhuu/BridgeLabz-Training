package bank_transaction;

public class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    // Method to withdraw amount with exception handling
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}
