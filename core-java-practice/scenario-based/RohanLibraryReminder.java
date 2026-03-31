package scenariobased;
import java.util.Scanner;

/**
 * Rohan’s Library Reminder App 📚
 * ● Input return date and due date.
 * ● If returned late, calculate fine: ₹5/day.
 * ● Repeat for 5 books using for-loop.
 */

public class RohanLibraryReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Loop for 5 books
        for (int i = 1; i <= 5; i++) {

            System.out.println("\n📘 Book " + i);

            // Input due date
            System.out.print("Enter the Due date (day/month/year): ");
            String[] dueDate = sc.nextLine().split("/");

            // Input return date
            System.out.print("Enter the Return date (day/month/year): ");
            String[] returnDate = sc.nextLine().split("/");

            // Convert String to int
            int dd = Integer.parseInt(dueDate[0]);
            int dm = Integer.parseInt(dueDate[1]);
            int dy = Integer.parseInt(dueDate[2]);

            int rd = Integer.parseInt(returnDate[0]);
            int rm = Integer.parseInt(returnDate[1]);
            int ry = Integer.parseInt(returnDate[2]);

            // Date validation
            if (dd > 31 || rd > 31 || dm > 12 || rm > 12) {
                System.out.println("Invalid date entered");
                continue; // Move to next book
            }

            int penaltyDays = 0;

            // Same year
            if (ry == dy) {

                // Same month
                if (rm == dm) {
                    if (rd > dd) {
                        penaltyDays = rd - dd;
                    }
                }
                // Later month
                else if (rm > dm) {
                    penaltyDays = (rm - dm) * 30 + (rd - dd);
                }
            }
            // Later year
            else if (ry > dy) {
                penaltyDays = (ry - dy) * 365 + (rm - dm) * 30 + (rd - dd);
            }

            // Output
            if (penaltyDays > 0) {
                System.out.println("Book returned late by " + penaltyDays + " days.");
                System.out.println("Penalty : Rs." + (penaltyDays * 5));
            } else {
                System.out.println("Book returned on time. No penalty.");
            }

            System.out.println("------------------------------------------");
        }

        sc.close();
        System.out.println("Library fine calculation completed for all books.");
    }
}
