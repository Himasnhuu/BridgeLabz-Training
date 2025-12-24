package Week_01.ProgrammingElements;

// This program distributes pens equally among students and finds remaining pens
public class PenDistribution {
    public static void main(String[] args) {
    
        // Define total number of pens and students
        int pens = 14;
        int students = 3;

        // Calculate pens per student and remaining pens
        int perStudent = pens / students;
        int remaining = pens % students;

        // Display the distribution result
        System.out.println("The Pen Per Student is " + perStudent + " and the remaining pen not distributed is " + remaining);
    }
}
