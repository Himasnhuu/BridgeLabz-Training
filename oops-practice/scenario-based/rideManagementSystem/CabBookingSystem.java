package scenariobased.oops.rideManagementSystem;

import java.util.Scanner;

public class CabBookingSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RideManagementService service = new RideManagementService();
        
        while (true) {
            System.out.println("\n=== Cab Booking System ===");
            System.out.println("1. Book a Ride");
            System.out.println("2. Complete a Ride");
            System.out.println("3. View Ride History");
            System.out.println("4. View Available Drivers");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        String userName = sc.nextLine();
                        System.out.print("Enter your phone: ");
                        String userPhone = sc.nextLine();
                        
                        User user = new User(userName, userPhone);
                        
                        System.out.print("Pickup location: ");
                        String pickup = sc.nextLine();
                        System.out.print("Destination: ");
                        String destination = sc.nextLine();
                        System.out.print("Distance (km): ");
                        double distance = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Pricing type (Normal/Peak): ");
                        String pricingType = sc.nextLine();
                        
                        Ride ride = service.bookRide(user, pickup, destination, distance, pricingType);
                        System.out.println("\n Ride booked successfully!\n");
                        System.out.println(ride.getRideDetails());
                        
                        break;
                        
                    case 2:
                        System.out.print("Enter Ride ID to complete: ");
                        int rideId = sc.nextInt();
                        service.completeRide(rideId);
                        break;
                        
                    case 3:
                        service.displayRideHistory();
                        break;
                        
                    case 4:
                        service.displayAvailableDrivers();
                        break;
                        
                    case 5:
                        System.out.println("Thank you!");
                        sc.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NoDriverAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
