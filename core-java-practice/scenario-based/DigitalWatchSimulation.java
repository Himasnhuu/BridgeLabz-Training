package scenariobased;

/*
 * Digital Watch Simulation ⏱️
 * Simulate a 24-hour watch:
 * ● Print hours and minutes in a nested for-loop.
 * ● Use a break to stop at 13:00 manually (simulate power cut).
 */

public class DigitalWatchSimulation {
    public static void main(String[] args) {
        
        System.out.println("DIGITAL WATCH SIMULATION.\n");
        System.out.println("24-Hour Format Display");
        System.out.println("Power cut will occur at 13:00\n");
        
        // flag to track if power cut occurred
        boolean powerCut = false;
        
        // outer loop for hours (0-23)
        for (int hour = 0; hour < 24; hour++) {
            
            // inner loop for minutes (0-59)
            for (int minute = 0; minute < 60; minute++) {
                
                // format and display time
                System.out.printf("%02d:%02d\n", hour, minute);
                
                // simulate power cut at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("\nPOWER CUT! Watch stopped at 13:00");
                    powerCut = true;
                    break; // break from minute loop
                }
                
            }
            
            // break from hour loop if power cut occurred
            if (powerCut) {
                break;
            }
        }
        
        System.out.println("\nSIMULATION ENDED");
    }
}
