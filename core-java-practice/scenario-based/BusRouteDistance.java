
/*
* Bus Route Distance Tracker 🚌
Each stop adds distance.
● Ask if the passenger wants to get off at a stop.
● Use a while-loop with a total distance tracker.
● Exit on user confirmation.*/

package scenariobased;
import java.util.Scanner;

public class BusRouteDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // bus route demo configuration
        String[] stops = {"Terminal", "Market Square", "City Center", "Hospital", "University", "Airport"};
        int[] distances = {0, 5, 8, 6, 10, 12};  // distance in km between consecutive stops
        
        int totalDistance = 0;
        int currentStopIndex = 0;
        boolean continueJourney = true;
        
        // passenger boards bus at terminal
        System.out.println("Welcome aboard");
        System.out.println("You boarded at: " + stops[currentStopIndex]);
        
        // while loop continues until passenger wants to get off
        while (continueJourney && currentStopIndex < distances.length-1) {
            // bus travels to next stop
            currentStopIndex++;
            int segmentDistance = distances[currentStopIndex];
            totalDistance += segmentDistance;
            
            // announce arrival at stop
            System.out.println("Bus is moving...");
            System.out.println("Arrived at: " + stops[currentStopIndex]);
            System.out.println("Distance from previous stop: " + segmentDistance + " km");
            System.out.println("Total distance traveled: " + totalDistance + " km");
            System.out.println();
            
            // ask passenger if they want to get off
            System.out.print("Do you want to get off at this stop? (yes/no): \n");
            String response = sc.nextLine().toLowerCase();
            
            if (response.equals("yes") && currentStopIndex<distances.length) {
                continueJourney = false;
            }
            
        }
        
        // journey summary when passenger exits
        System.out.println("JOURNEY SUMMARY");
        System.out.println("Exit Stop: " + stops[currentStopIndex]);
        System.out.println("Total Distance Traveled: " + totalDistance + " km");
        System.out.println("Thank you for traveling with us!");
        
        sc.close();
    }
}
