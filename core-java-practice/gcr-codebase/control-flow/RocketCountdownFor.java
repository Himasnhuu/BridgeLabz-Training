package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program performs rocket countdown using for loop
public class RocketCountdownFor {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for countdown value
        System.out.print("Enter countdown value: ");
        int counter = sc.nextInt();
        
        // Perform countdown from counter to 1
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        // Display liftoff message
        System.out.println("Liftoff!");
        
        // Closing the Scanner class
        sc.close();
    }
}
