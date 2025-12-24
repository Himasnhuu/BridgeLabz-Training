package Week_01.FlowControl.Level1;

// This program checks if a given date falls in spring season (March 20 to June 20)
public class SpringSeason {
    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments");
            return;
        }
        
        // Parse month and day from command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        
        // Initialize spring season flag
        // Spring Season is from March 20 to June 20
        boolean isSpring = false;
        
        // Check if the date falls in spring season
        if (month == 3 && day >= 20) {
            isSpring = true;
        } else if (month == 4 || month == 5) {
            isSpring = true;
        } else if (month == 6 && day <= 20) {
            isSpring = true;
        }
        
        // Display the result
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
