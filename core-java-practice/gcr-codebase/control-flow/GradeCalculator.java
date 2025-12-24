package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program calculates grade based on average marks of three subjects
public class GradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for marks of three subjects
        System.out.println("Enter marks for 3 subjects:");
        System.out.print("Physics: ");
        double physics = sc.nextDouble();
        
        System.out.print("Chemistry: ");
        double chemistry = sc.nextDouble();
        
        System.out.print("Maths: ");
        double maths = sc.nextDouble();
        
        // Calculate average percentage
        double average = (physics + chemistry + maths) / 3;
        
        // Initialize variables for grade and remarks
        // Determine grade and remarks
        String grade;
        String remarks;
        
        if (average >= 80) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (average >= 70) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (average >= 60) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (average >= 50) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (average >= 40) {
            grade = "F";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R";
            remarks = "(Remedial instruction)";
        }
        
        // Display grade results
        System.out.println("\n========== Results ==========");
        System.out.printf("Average Mark: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        // Closing the Scanner class
        sc.close();
    }
}
