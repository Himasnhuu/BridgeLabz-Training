package scenariobased;

import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        // Scanner object to take user input from keyboard
        Scanner sc = new Scanner(System.in);

        // Welcome message
        System.out.println("Draw a number and win exciting gifts!");

        // Infinite loop to allow multiple visitors to play
        while (true) {

            // Prompt user to enter a number
            System.out.print("\nEnter a number: ");

            // ✅ Check if the input is NOT an integer
            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");

                // Clear invalid input from scanner buffer
                sc.next();

                // Skip the remaining code and restart the loop
                continue;
            }

            // Read the valid integer entered by user
            int n = sc.nextInt();

            // Consume the leftover newline character
            sc.nextLine();

            // ✅ Check if the number is divisible by both 3 and 5
            if (n % 3 == 0 && n % 5 == 0) {

                // Winning message
                System.out.println("Congratulations, Lucky number " + n + " wins the gift!");

                // Ask user if they want to continue or exit
                System.out.print("\nType yes to draw again or exit to quit: ");
                String choice = sc.nextLine().toLowerCase();

                // If user wants to exit
                if (choice.equals("exit")) {
                    System.out.println("Thanks for playing the Festival Lucky Draw!");
                }
                // If user wants to draw again
                else if (choice.equals("yes")) {
                    System.out.println("Enter your lucky number again : ");
                    continue; // Restart the loop
                }

            } 
            // If number is NOT divisible by 3 and 5
            else {

                // Losing message
                System.out.println("Better luck next time.");

                // Ask user if they want to continue or exit
                System.out.print("Type yes to draw again or exit to quit: ");
                String choice = sc.nextLine().toLowerCase();

                // If user wants to exit
                if (choice.equals("exit")) {
                    System.out.println("\nThanks for playing the Festival Lucky Draw!");
                }
                // If user wants to draw again
                else if (choice.equals("yes")) {
                    System.out.println("Enter your lucky number again : ");
                    continue; // Restart the loop
                }
            }

            // Decorative separator
            System.out.println("\n--------------------------------------------------------------------------");

            // Final confirmation before closing the lucky draw
            System.out.print("Type exit to close the lucky draw and continue to still open it... : ");
            String choice = sc.nextLine().toLowerCase();

            // Decorative separator
            System.out.println("--------------------------------------------------------------------------");

            // If user chooses to exit the lucky draw
            if (choice.equals("exit")) {
                System.out.println("\n----------------------------------------------");
                System.out.println("Lucky Draw closed.");
                System.out.println("----------------------------------------------");
                break; // Exit the while loop
            }
            // If user wants to continue playing
            else {
                System.out.println("\nDraw a number and win exciting gifts!");
            }
        }

        // Close the scanner resource
        sc.close();
    }
}
