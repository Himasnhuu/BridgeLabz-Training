package bank_transaction;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        BankAccount account = new BankAccount(initialBalance);
        
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        
        try {
            // Attempt withdrawal
            account.withdraw(amount);
            
        } catch (InsufficientBalanceException e) {
            // Handle insufficient balance
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle negative amount
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
