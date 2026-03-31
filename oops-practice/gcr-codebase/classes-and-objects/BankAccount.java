// 2. Program to Simulate an ATM
package week2.oops.classesAndObject;

public class BankAccount {
    
    // attributes
    String accountHolder;
    String accountNumber;
    double balance;
    
    // constructor
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // method to deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // method to withdraw money (only if sufficient balance exists)
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    // method to display current balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
    
    public static void main(String[] args) {
        
        System.out.println("State of Chennai\n");
        
        // create bank account
        BankAccount account = new BankAccount("Himanshu", "ACC12345", 700.0);
        
        // display initial balance
        account.displayBalance();
        
        // deposit money
        account.deposit(200.0);
        account.displayBalance();
        
        // withdraw money
        account.withdraw(100.0);
        account.displayBalance();
        
        // try to withdraw more than balance
        account.withdraw(1000.0);
    }
}
