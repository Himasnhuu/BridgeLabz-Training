package Week_01.javaMethods;

public class SpringSeason {
    
    // method to check if date falls in spring season
    public static boolean isSpring(int month, int day) {
        // spring season: March 20 to June 20
        if (month == 3 && day >= 20) {
            return true;  
        } else if (month == 4 || month == 5) {
            return true;  
        } else if (month == 6 && day <= 20) {
            return true; 
        }
        return false;
    }
    
    public static void main(String[] args) {
        // take input from command line arguments
        if (args.length < 2) {
            System.out.println("Usage: java SpringSeason <month> <day>");
            return;
        }
        
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        
        if (isSpring(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
