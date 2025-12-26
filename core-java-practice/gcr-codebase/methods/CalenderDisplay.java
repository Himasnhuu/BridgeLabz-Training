package Week_01.javaMethods.level3;
import java.util.Scanner;

public class CalenderDisplay {
    
    // method to get month name
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
    
    // method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // method to get number of days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // check for leap year february
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        
        return days[month - 1];
    }
    
    // method to get first day of month using gregorian calendar algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;
        
        // adjust for january and february
        if (m < 3) {
            m += 12;
            y--;
        }
        
        // gregorian calendar algorithm
        int y0 = y - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31*m0/12) % 7;
        
        return d0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        // get calendar information
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        // display calendar header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        // first for loop: add spaces for proper indentation
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        
        // second for loop: display days of month
        for (int day = 1; day <= daysInMonth; day++) {
            // use %3d to right-justify in field of width 3
            System.out.printf("%3d ", day);
            
            // move to next line after saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        
        System.out.println();
        
        sc.close();
    }
}
