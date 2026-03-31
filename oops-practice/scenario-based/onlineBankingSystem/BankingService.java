package scenariobased.oops.onlineBankingSystem;

import java.util.ArrayList;

public class BankingService {
    private ArrayList<Account> accounts;
    
    public BankingService() {
        this.accounts = new ArrayList<>();
    }
    
    public void createAccount(String type, String accountNumber, String name, double initialBalance) {
        Account account = null;
        
        if (type.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accountNumber, name, initialBalance);
        } else if (type.equalsIgnoreCase("Current")) {
            account = new CurrentAccount(accountNumber, name, initialBalance);
        } else {
            System.out.println("Invalid account type!");
            return;
        }
        
        accounts.add(account);
        System.out.println("✓ " + type + " Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }
    
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    public void transferFunds(String fromAccount, String toAccount, double amount) 
            throws InsufficientBalanceException {
        Account sender = findAccount(fromAccount);
        Account receiver = findAccount(toAccount);
        
        if (sender == null || receiver == null) {
            System.out.println("✗ One or both accounts not found!");
            return;
        }
        
        synchronized (sender) {
            synchronized (receiver) {
                sender.withdraw(amount);
                receiver.deposit(amount);
                System.out.println("✓ Transfer of ₹" + amount + " completed successfully!");
            }
        }
    }
    
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        
        System.out.println("\n=== All Accounts ===");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " | " + 
                             account.getAccountHolderName() + " | " + 
                             account.getClass().getSimpleName() + 
                             " | Balance: ₹" + String.format("%.2f", account.getBalance()));
        }
    }
}
