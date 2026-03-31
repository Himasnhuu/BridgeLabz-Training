package scenariobased.oops.onlineBankingSystem;

import java.util.ArrayList;

public abstract class Account implements BankService {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected ArrayList<Transaction> transactionHistory;
    
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(new Transaction("INITIAL DEPOSIT", initialBalance, balance));
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("DEPOSIT", amount, balance));
        System.out.println("✓ Deposited ₹" + amount + " successfully!");
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available: ₹" + balance);
        }
        balance -= amount;
        transactionHistory.add(new Transaction("WITHDRAWAL", amount, balance));
        System.out.println("✓ Withdrawn ₹" + amount + " successfully!");
    }
    
    @Override
    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        
        System.out.println("\n=== Transaction History ===");
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolderName);
        System.out.println("---");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    
    public abstract void calculateInterest();
    
    public void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + getClass().getSimpleName());
        System.out.println("Current Balance: ₹" + String.format("%.2f", balance));
    }
}
