package Week_01.ProgrammingElements;

// This program calculates Harry's age in 2024 based on his birth year
public class HarryAge {
    public static void main(String[] args) {
    
        // Define birth year and current year
        int birthYear = 2000;
        int currentYear = 2024;

        // Calculate Harry's age
        int age = currentYear - birthYear;
        
        // Display Harry's age
        System.out.println("Harry's age in 2024 is " + age);
    }
}
