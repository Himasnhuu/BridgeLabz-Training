package Week_01.javaMethods.extras;
import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
 
 public static void main(String[] args) {
     
     System.out.println("DATE COMPARISON\n");
     
     // take two date inputs
     LocalDate date1 = getDateInput("first");
     LocalDate date2 = getDateInput("second");
     
     // compare dates
     compareDates(date1, date2);
 }
 
 // method to get date input from user
 static LocalDate getDateInput(String position) {
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter " + position + " date:");
     System.out.print("Year: ");
     int year = sc.nextInt();
     
     System.out.print("Month: ");
     int month = sc.nextInt();
     
     System.out.print("Day: ");
     int day = sc.nextInt();
     
     return LocalDate.of(year, month, day);
 }
 
 // method to compare two dates using isBefore, isAfter, isEqual
 static void compareDates(LocalDate date1, LocalDate date2) {
     System.out.println("\nFirst Date: " + date1);
     System.out.println("Second Date: " + date2);
     System.out.println("\nComparison Result:");
     
     // check if first date is before second date
     if (date1.isBefore(date2)) {
         System.out.println("The first date is BEFORE the second date.");
     } 
     // check if first date is after second date
     else if (date1.isAfter(date2)) {
         System.out.println("The first date is AFTER the second date.");
     } 
     // check if dates are equal
     else if (date1.isEqual(date2)) {
         System.out.println("Both dates are THE SAME.");
     }
 }
}
