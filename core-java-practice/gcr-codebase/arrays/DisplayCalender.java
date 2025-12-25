package Week_01.stringarray.level3;
import java.util.Scanner;

public class DisplayCalender {

    // Method to get month name from month number
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Divisible by 400, or divisible by 4 but not by 100
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Method to get number of days in a specific month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Special case: February in leap year has 29 days
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to get first day of the month using Gregorian calendar formula
    public static int getFirstDay(int month, int year) {
        // Zeller's congruence formula components
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }

    // Method to display calendar for given month and year
    public static void displayCalendar(int month, int year) {
        // Get month details
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

        // Display calendar header
        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print spaces for days before first day of month
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print all dates of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for month and year
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        // Display calendar for given month and year
        displayCalendar(month, year);

        sc.close();
    }
}