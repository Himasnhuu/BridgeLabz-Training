package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds the youngest and tallest among 3 friends
class FriendsComparison {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking input for Amar's age and height
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = sc.nextDouble();
        
        // Taking input for Akbar's age and height
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = sc.nextDouble();
        
        // Taking input for Anthony's age and height
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = sc.nextDouble();
        
        // Find the youngest friend
        int smallestAge = amarAge;
        String youngestFriend = "Amar";
        
        if (akbarAge < smallestAge) {
            smallestAge = akbarAge;
            youngestFriend = "Akbar";
        }
        
        if (anthonyAge < smallestAge) {
            smallestAge = anthonyAge;
            youngestFriend = "Anthony";
        }
        
        // Find the tallest friend
        double largestHeight = amarHeight;
        String tallestFriend = "Amar";
        
        if (akbarHeight > largestHeight) {
            largestHeight = akbarHeight;
            tallestFriend = "Akbar";
        }
        
        if (anthonyHeight > largestHeight) {
            largestHeight = anthonyHeight;
            tallestFriend = "Anthony";
        }
        
        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Youngest friend: " + youngestFriend + " (Age: " + smallestAge + ")");
        System.out.println("Tallest friend: " + tallestFriend + " (Height: " + largestHeight + " cm)");
        
        // Closing the Scanner class
        sc.close();
    }
}
