package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a year is a leap year using a single if condition
public class LeapYearSingleIf {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for year
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        // Check leap year condition using single if with logical operators
        // Single if condition using logical operators
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year");
        } else if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar)");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
