package scenariobased.oops.onlineBankingSystem;

public class SavingsAccount extends Account {
    private double interestRate = 4.5;
    
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactionHistory.add(new Transaction("INTEREST CREDIT", interest, balance));
        System.out.println("✓ Interest of ₹" + String.format("%.2f", interest) + " credited!");
    }
}
