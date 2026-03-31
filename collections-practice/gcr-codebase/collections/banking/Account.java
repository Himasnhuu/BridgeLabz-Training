package banking;

public class Account {
    private String accountNumber;
    private String customerName;
    private double balance;
    
    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("Account[%s, %s, Balance: $%.2f]", 
            accountNumber, customerName, balance);
    }
}
