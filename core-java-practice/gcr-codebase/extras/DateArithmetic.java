package Week_01.javaMethods.extras;
import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("DATE ARITHMETIC\n");
        
        // input date
        System.out.println("Enter a date:");
        System.out.print("Year: ");
        int year = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Day: ");
        int day = sc.nextInt();
        
        // create LocalDate object
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("\nOriginal Date: " + date);
        
        // add 7 days
        LocalDate afterDays = date.plusDays(7);
        System.out.println("After adding 7 days: " + afterDays);
        
        // add 1 month
        LocalDate afterMonth = afterDays.plusMonths(1);
        System.out.println("After adding 1 month: " + afterMonth);
        
        // add 2 years
        LocalDate afterYears = afterMonth.plusYears(2);
        System.out.println("After adding 2 years: " + afterYears);
        
        // subtract 3 weeks
        LocalDate finalDate = afterYears.minusWeeks(3);
        System.out.println("\nAfter subtracting 3 weeks: " + finalDate);
        
        
        sc.close();
    }
}
