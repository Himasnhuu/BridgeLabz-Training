package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program checks if a person is eligible to vote based on age
public class VotingEligibility {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for age
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        
        // Check if age is 18 or above for voting eligibility
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
