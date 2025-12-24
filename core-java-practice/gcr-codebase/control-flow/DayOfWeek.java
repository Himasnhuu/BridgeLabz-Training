package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program calculates the day of the week for a given date
public class DayOfWeek {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for month
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        
        // Taking user input for day
        System.out.print("Enter day: ");
        int d = sc.nextInt();
        
        // Taking user input for year
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        
        // Calculate y0 = y − (14 − m) / 12
        int y0 = y - (14 - m) / 12;
        
        // Calculate x = y0 + y0/4 − y0/100 + y0/400
        int x = y0 + y0/4 - y0/100 + y0/400;
        
        // Calculate m0 = m + 12 × ((14 − m) / 12) − 2
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        
        // Calculate d0 = (d + x + 31m0 / 12) mod 7
        int d0 = (d + x + 31*m0 / 12) % 7;
        
        // Create array of day names
        // Array of day names
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // Display the day of the week
        System.out.println("Day of the week: " + d0 + " (" + days[d0] + ")");
        
        // Closing the Scanner class
        sc.close();
    }
}
