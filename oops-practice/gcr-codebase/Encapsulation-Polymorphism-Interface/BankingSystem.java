package week2.oops.encapsulation;

/*4. Banking System
Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically.*/

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    // Concrete method - deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // Concrete method - withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    
    // Abstract method
    public abstract double calculateInterest();
    
    // Getters and Setters (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    protected void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    protected void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan application of $" + amount + " approved for Savings Account");
        } else {
            System.out.println("Loan application rejected - Insufficient balance");
        }
    }
    
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Minimum balance required
    }
    
    public double getInterestRate() {
        return interestRate;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public double calculateInterest() {
        return 0; // Current accounts typically don't earn interest
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + getBalance());
        } else {
            System.out.println("Amount exceeds overdraft limit");
        }
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan application of $" + amount + " approved for Current Account");
        } else {
            System.out.println("Loan application rejected - Low transaction history");
        }
    }
    	
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; // Higher requirement for current accounts
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}

// Main class
public class BankingSystem {
    
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe", 10000, 4.5);
        CurrentAccount current = new CurrentAccount("CA001", "Jane Smith", 15000, 5000);
        
        System.out.println("========== BANKING SYSTEM ==========\n");
        
        // Savings Account operations
        System.out.println("--- Savings Account ---");
        System.out.println("Account Number: " + savings.getAccountNumber());
        System.out.println("Holder: " + savings.getHolderName());
        System.out.println("Initial Balance: $" + savings.getBalance());
        System.out.println("Interest Rate: " + savings.getInterestRate() + "%");
        System.out.println();
        
        savings.deposit(2000);
        System.out.println();
        savings.withdraw(3000);
        System.out.println();
        
        double interest = savings.calculateInterest();
        System.out.println("Interest Earned: $" + interest);
        System.out.println();
        
        savings.applyForLoan(50000);
        System.out.println();
        
        // Current Account operations
        System.out.println("--- Current Account ---");
        System.out.println("Account Number: " + current.getAccountNumber());
        System.out.println("Holder: " + current.getHolderName());
        System.out.println("Initial Balance: $" + current.getBalance());
        System.out.println("Overdraft Limit: $" + current.getOverdraftLimit());
        System.out.println();
        
        current.deposit(5000);
        System.out.println();
        current.withdraw(18000); // Using overdraft
        System.out.println();
        
        double currentInterest = current.calculateInterest();
        System.out.println("Interest Earned: $" + currentInterest);
        System.out.println();
        
        current.applyForLoan(100000);
        System.out.println();
        
        // Polymorphism demonstration
        System.out.println("========== POLYMORPHISM DEMO ==========\n");
        BankAccount[] accounts = {savings, current};
        
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Type: " + account.getClass().getSimpleName());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest: $" + account.calculateInterest());
            
            if (account instanceof Loanable) {
                System.out.println("Loan Eligible: " + ((Loanable) account).calculateLoanEligibility());
            }
            System.out.println();
        }
    }
}
