package restaurantreservation;

import java.util.*;

public class RestaurantReservationSystem {
    private Map<Integer, Integer> tableMap; // tableNumber -> Table object reference (index in list)
    private List<Reservation> reservations;

    public RestaurantReservationSystem() {
        tableMap = new HashMap<>();
        reservations = new ArrayList<>();
    }

    // Reserve a table for a specific time slot
    public void reserveTable(int tableNumber, String customerName, String timeSlot) throws TableAlreadyReservedException {
        // Check if table is already reserved
        if (tableMap.containsKey(tableNumber)) {
            throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved!");
        }

        Reservation reservation = new Reservation(tableNumber, customerName, timeSlot);
        reservations.add(reservation);
        tableMap.put(tableNumber, reservations.size() - 1);
        System.out.println("Reservation successful: " + reservation);
    }

    // Cancel a reservation
    public void cancelReservation(int tableNumber) {
        if (!tableMap.containsKey(tableNumber)) {
            System.out.println("No reservation found for table " + tableNumber);
            return;
        }

        int index = tableMap.get(tableNumber);
        Reservation removed = reservations.get(index);
        tableMap.remove(tableNumber);
        System.out.println("Cancelled reservation: " + removed);
    }

    // Show all available tables (not in the map)
    public void showAvailableTables(int totalTables) {
        System.out.println("\nAvailable Tables:");
        for (int i = 1; i <= totalTables; i++) {
            if (!tableMap.containsKey(i)) {
                System.out.println("Table " + i);
            }
        }
    }

    // Show all reservations
    public void showAllReservations() {
        System.out.println("\nAll Reservations:");
        for (Reservation res : reservations) {
            if (res != null && tableMap.containsKey(res.getTableNumber())) {
                System.out.println(res);
            }
        }
    }
}
