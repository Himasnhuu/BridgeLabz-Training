package scenariobased.oops.onlineBankingSystem;

import java.util.Scanner;

public class OnlineBankingSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingService bankingService = new BankingService();
        
        while (true) {
            System.out.println("\n=== Online Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Funds");
            System.out.println("6. View Transaction History");
            System.out.println("7. Calculate Interest (Savings Only)");
            System.out.println("8. View Account Info");
            System.out.println("9. View All Accounts");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Account Type (Savings/Current): ");
                        String type = sc.nextLine();
                        System.out.print("Account Number: ");
                        String accNum = sc.nextLine();
                        System.out.print("Account Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Initial Deposit: ");
                        double initialBalance = sc.nextDouble();
                        
                        bankingService.createAccount(type, accNum, name, initialBalance);
                        break;
                        
                    case 2:
                        System.out.print("Enter Account Number: ");
                        String depositAcc = sc.nextLine();
                        Account account1 = bankingService.findAccount(depositAcc);
                        
                        if (account1 != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            account1.deposit(depositAmount);
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter Account Number: ");
                        String withdrawAcc = sc.nextLine();
                        Account account2 = bankingService.findAccount(withdrawAcc);
                        
                        if (account2 != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            account2.withdraw(withdrawAmount);
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 4:
                        System.out.print("Enter Account Number: ");
                        String balanceAcc = sc.nextLine();
                        Account account3 = bankingService.findAccount(balanceAcc);
                        
                        if (account3 != null) {
                            System.out.println("Current Balance: ₹" + account3.getBalance());
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 5:
                        System.out.print("From Account Number: ");
                        String fromAcc = sc.nextLine();
                        System.out.print("To Account Number: ");
                        String toAcc = sc.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = sc.nextDouble();
                        
                        bankingService.transferFunds(fromAcc, toAcc, transferAmount);
                        break;
                        
                    case 6:
                        System.out.print("Enter Account Number: ");
                        String historyAcc = sc.nextLine();
                        Account account4 = bankingService.findAccount(historyAcc);
                        
                        if (account4 != null) {
                            account4.displayTransactionHistory();
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 7:
                        System.out.print("Enter Account Number: ");
                        String interestAcc = sc.nextLine();
                        Account account5 = bankingService.findAccount(interestAcc);
                        
                        if (account5 != null) {
                            account5.calculateInterest();
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 8:
                        System.out.print("Enter Account Number: ");
                        String infoAcc = sc.nextLine();
                        Account account6 = bankingService.findAccount(infoAcc);
                        
                        if (account6 != null) {
                            account6.displayAccountInfo();
                        } else {
                            System.out.println("✗ Account not found!");
                        }
                        break;
                        
                    case 9:
                        bankingService.displayAllAccounts();
                        break;
                        
                    case 10:
                        System.out.println("Thank you for banking with us!");
                        sc.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
