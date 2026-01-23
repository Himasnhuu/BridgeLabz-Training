package banking;

import java.util.*;

public class BankingSystem {
    
    private HashMap<String, Account> accounts;
    private Queue<WithdrawalRequest> withdrawalQueue;
    
    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }
    
    // Create account
    public void createAccount(String accountNumber, String customerName, double initialBalance) {
        Account account = new Account(accountNumber, customerName, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created: " + account);
    }
    
    // Get account
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    // Deposit money
    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited $" + amount + " to " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
    
    // Queue withdrawal request
    public void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request queued: " + accountNumber + " for $" + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
    
    // Process withdrawal requests
    public void processWithdrawals() {
        System.out.println("\nProcessing withdrawal requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            Account account = accounts.get(request.getAccountNumber());
            
            if (account.withdraw(request.getAmount())) {
                System.out.println("Processed: " + request + " - Success");
            } else {
                System.out.println("Processed: " + request + " - Insufficient funds");
            }
        }
    }
    
    // Get customers sorted by balance
    public TreeMap<Double, List<Account>> getCustomersSortedByBalance() {
        TreeMap<Double, List<Account>> sortedByBalance = new TreeMap<>(Collections.reverseOrder());
        
        for (Account account : accounts.values()) {
            sortedByBalance.computeIfAbsent(account.getBalance(), k -> new ArrayList<>())
                          .add(account);
        }
        
        return sortedByBalance;
    }
    
    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        accounts.values().forEach(System.out::println);
    }
    
    // Display accounts sorted by balance
    public void displayAccountsByBalance() {
        System.out.println("\nAccounts sorted by balance (highest first):");
        TreeMap<Double, List<Account>> sorted = getCustomersSortedByBalance();
        for (Map.Entry<Double, List<Account>> entry : sorted.entrySet()) {
            for (Account account : entry.getValue()) {
                System.out.println(account);
            }
        }
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create accounts
        bank.createAccount("ACC001", "Alice", 5000);
        bank.createAccount("ACC002", "Bob", 3000);
        bank.createAccount("ACC003", "Carol", 7000);
        bank.createAccount("ACC004", "David", 2000);
        
        // Deposit
        bank.deposit("ACC001", 1000);
        
        // Queue withdrawal requests
        bank.requestWithdrawal("ACC001", 500);
        bank.requestWithdrawal("ACC002", 1000);
        bank.requestWithdrawal("ACC003", 8000);
        bank.requestWithdrawal("ACC004", 500);
        
        // Process withdrawals
        bank.processWithdrawals();
        
        // Display results
        bank.displayAllAccounts();
        bank.displayAccountsByBalance();
    }
}
