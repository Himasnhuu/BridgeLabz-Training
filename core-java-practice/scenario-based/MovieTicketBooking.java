package scenariobased;
import java.util.Scanner;

/*
 * Movie Ticket Booking App 🎬
 * Ask users for movie type, seat type (gold/silver), and snacks.
 * ● Use switch and if together.
 * ● Loop through multiple customers.
 * ● Clean structure and helpful variable names.
 */

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Movie Ticket Booking.\n");

        // input total number of seats in the theatre
        System.out.print("Enter the total number of seats in the theatre : ");
        int seats = sc.nextInt();
        sc.nextLine();

        // variable to track total booked seats
        int bSeat = 0;

        // flag to control booking loop
        boolean flag = true;

        System.out.println("\n--------------------------------------------------");

        // loop to process multiple customers
        while (flag) {

            // input customer name
            System.out.print("Enter your name : ");
            String name = sc.nextLine();

            // movie type input
            System.out.print("Select movie type (1-Action, 2-Comedy, 3-Drama) : ");
            int movieChoice = sc.nextInt();
            sc.nextLine();

            int moviePrice = 0;
            String movieType = "";

            // 🎬 switch used here
            switch (movieChoice) {
                case 1:
                    movieType = "Action";
                    moviePrice = 200;
                    break;
                case 2:
                    movieType = "Comedy";
                    moviePrice = 180;
                    break;
                case 3:
                    movieType = "Drama";
                    moviePrice = 150;
                    break;
                default:
                    System.out.println("Invalid movie choice.");
                    continue;
            }

            // input number of seats to book
            System.out.print("Enter the no. of seats you want to book : ");
            int n = sc.nextInt();
            sc.nextLine();

            // add to total booked seats
            bSeat += n;

            // input seat types
            System.out.println("Enter the seat type (gold/silver/platinum)");
            String[] sType = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter seat type : ");
                sType[i] = sc.nextLine().toLowerCase();
            }

            // count seat types
            int g = 0, s = 0, p = 0;
            for (int i = 0; i < n; i++) {
                if (sType[i].equals("gold")) g++;
                else if (sType[i].equals("silver")) s++;
                else if (sType[i].equals("platinum")) p++;
            }

            // snack selection
            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = sc.nextLine().toLowerCase();
            int snackPrice = 0;

            // 🍿 if condition used here
            if (snacks.equals("yes")) {
                snackPrice = 100;
            }

            // total bill calculation
            int totalBill = (moviePrice * n) + snackPrice;

            // booking summary
            System.out.println("\n-----------------------------------------");
            System.out.println("Customer Name : " + name);
            System.out.println("Movie Type    : " + movieType);
            System.out.println("Seats Booked  : " + n);
            System.out.println("Gold Seats    : " + g);
            System.out.println("Silver Seats  : " + s);
            System.out.println("Platinum Seats: " + p);
            System.out.println("Snacks Added  : " + snacks);
            System.out.println("Total Bill    : Rs. " + totalBill);
            System.out.println("-----------------------------------------");

            // stop if theatre is full
            if (bSeat == seats) {
                flag = false;
            }

            // continue or exit
            System.out.println("Enter 0 to close the booking and 1 to continue open booking for customers : ");
            int a = sc.nextInt();
            sc.nextLine();

            if (a == 0) {
                flag = false;
            }
        }

        sc.close();
        System.out.println("\n🎬 Booking Closed. Thank You!");
    }
}
