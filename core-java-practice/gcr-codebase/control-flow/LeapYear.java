package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a year is a leap year
public class LeapYear {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for year
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        // Validate year and check leap year condition
        // Check if year is valid (>= 1582 for Gregorian calendar)
        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar)");
        } else if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
