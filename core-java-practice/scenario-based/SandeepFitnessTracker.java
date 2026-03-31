package scenariobased;
import java.util.Scanner;

/*
 * Sandeep's Fitness Challenge Tracker 🏋️‍♂️
 * Each day Sandeep completes a number of push-ups.
 * ● Store counts for a week.
 * ● Use for-each to calculate total and average.
 * ● Use continue to skip rest days.
 */

public class SandeepFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // variables to track active and rest days
        int activeDays = 0, restDays = 0;
        
        // array to store push-up counts for 7 days
        int[] numOfPushUps = new int[7];
        
        // array to store day names
        String[] arr = {"Monday", "Tuesday", "Wed", "Thur", "Friday", "Sat", "Sunday"};

        // display tracker title
        System.out.println("Sandeep's Fitness Challenge Tracker.\n");
        
        // loop through each day to take input
        for (int i = 0; i < arr.length; i++) {

            // ask if current day is rest day or active day
            System.out.print("Enter 0 if " + arr[i] + " is Rest Day and 1 for active day : ");
            int rest = sc.nextInt();

            // if rest day (user entered 0)
            if (rest == 0) {
                System.out.println(arr[i] + " is the rest day.\n");
                numOfPushUps[i] = 0;  // store 0 for rest day
                restDays += 1;  // increment rest day counter

            }
            // if active day (user entered 1)
            else {
                System.out.print("Enter the no. of pushups on " + arr[i] + " : ");
                numOfPushUps[i] = sc.nextInt();  // store push-up count
                System.out.println();
                activeDays += 1;  // increment active day counter
            }
        }

        // display separator line
        System.out.println("---------------------------------------------");
        
        // display header for day-wise summary
        System.out.println("Day\t\tpushups");
        
        // loop to display each day's push-up count
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t\t" + numOfPushUps[i]);
        }
        
        System.out.println("\n---------------------------------------------\n");

        // calculate total push-ups using for-each loop
        int totalPushUps = 0;
        for (int x : numOfPushUps) {
            totalPushUps += x;  // add each day's count to total
        }
        
        // display weekly report header
        System.out.println("Weekly Report");
        
        // display active and rest days count
        System.out.println("Active Days : " + activeDays + "\t\tRest Days : " + restDays);
        
        // display total push-ups and average per active day
        System.out.println("Total Push-ups : " + totalPushUps + "\t\tAverage : " + (totalPushUps / activeDays));
        
        System.out.println("\n---------------------------------------------\n");

        // close scanner
        sc.close();
    }
}
