package Week_01.javaMethods.extras;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("NUMBER GUESSING GAME.\n\n");

        // flag to control game loop
        boolean flag = true;

        // main game loop
        while(flag) {
            // input the number user is thinking of
            System.out.print("Enter the number : ");
            int num = sc.nextInt();
            sc.nextLine();

            // generate computer's random guess
            int n = numberGuess();
            System.out.print("Computer's guess : " + n + "\n");

            // get user feedback on computer's guess
            System.out.print("Enter your feedback about computer guess(high/low/correct) : ");
            String s = sc.nextLine();
            System.out.println();

            // ask user to continue or exit
            System.out.print("Enter 0 to exit the game and 1 to continue playing : ");
            int choice = sc.nextInt();
            System.out.println();
            
            // process user's choice
            if (choice == 0) {
                System.out.print("Game is closed.");
                flag = false;
            } else if(choice == 1) {
                continue; // continue to next round
            } else {
                System.out.println("Invalid choice, Game Closed.");
                break; // exit on invalid input
            }
        }

        sc.close();
    }

    // method to generate random number between 1 and 100
    static int numberGuess() {
        return (int)(Math.random() * 100) + 1;
    }
}
