package restaurantreservation;

public class Main {
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();
        int totalTables = 10;

        try {
            // Make reservations
            system.reserveTable(1, "John Doe", "6:00 PM");
            system.reserveTable(3, "Jane Smith", "7:00 PM");
            system.reserveTable(5, "Bob Johnson", "6:30 PM");

            // Show all reservations
            system.showAllReservations();

            // Try to reserve an already reserved table
            system.reserveTable(1, "Alice Brown", "8:00 PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Cancel a reservation
        system.cancelReservation(3);

        // Show available tables
        system.showAvailableTables(totalTables);

        // Show remaining reservations
        system.showAllReservations();
    }
}
