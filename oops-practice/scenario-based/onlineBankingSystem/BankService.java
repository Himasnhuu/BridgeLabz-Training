package scenariobased.oops.onlineBankingSystem;

public interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double getBalance();
    void displayTransactionHistory();
}
