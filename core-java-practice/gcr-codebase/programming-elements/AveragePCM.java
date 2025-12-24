package Week_01.ProgrammingElements;

// This program calculates the average marksin Physics, Chemistry, and Mathematics
public class AveragePCM {
    public static void main(String[] args) {
    
        // Define marks for each subject
        int maths = 94, physics = 95, chemistry = 96;

        // Calculate the average of three subjects
        double average = (maths + physics + chemistry) / 3.0;
        
        // Display Sam's average marks
        System.out.println("Sam's average mark in PCM is " + average);
    }
}
