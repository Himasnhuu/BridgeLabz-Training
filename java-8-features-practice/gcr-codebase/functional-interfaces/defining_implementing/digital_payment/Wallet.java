package defining_implementing.digital_payment;

public class Wallet implements Payment {
    private String walletName;
    private double balance;
    
    public Wallet(String walletName, double balance) {
        this.walletName = walletName;
        this.balance = balance;
    }
    
    @Override
    public void pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Paid $" + amount + " via " + walletName + 
                             ". Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance in " + walletName);
        }
    }
}
