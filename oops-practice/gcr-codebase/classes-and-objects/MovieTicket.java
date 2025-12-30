// 4. Program to Model a Movie Ticket Booking System
package week2.oops.classesAndObject;

import java.util.HashSet;

public class MovieTicket {
    
    // attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;
    
    // static set to track all booked seats
    static HashSet<String> bookedSeats = new HashSet<>();
    
    // constructor
    MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }
    
    // method to book a ticket
    void bookTicket() {
        if (bookedSeats.contains(seatNumber)) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            isBooked = false;
        } else {
            bookedSeats.add(seatNumber);
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
        }
    }
    
    // method to display ticket details
    void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }
    
    public static void main(String[] args) {
        
        // create first ticket
        MovieTicket ticket1 = new MovieTicket("Dragon", "A10", 120.0);
        ticket1.displayTicketDetails();
        
        // book the ticket
        ticket1.bookTicket();
        
        // try to book same seat again
        MovieTicket ticket2 = new MovieTicket("Dragon", "A10", 120.0);
        ticket2.bookTicket();
        
        // display details
        ticket1.displayTicketDetails();
    }
}
