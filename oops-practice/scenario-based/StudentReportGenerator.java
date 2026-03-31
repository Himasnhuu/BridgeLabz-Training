package scenariobased.oops;

import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student class
class Student {
    String name;
    String[] subjects;
    int[] marks;
    
    public Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }
}

public class StudentReportGenerator {
    
    // Calculate average
    public static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    
    // Assign grade
    public static String assignGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 60) return "C";
        else if (average >= 40) return "D";
        else return "F";
    }
    
    // Validate marks
    public static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Mark must be between 0 and 100. Found: " + mark);
            }
        }
    }
    
    // Display report card
    public static void displayReport(Student student) {
        System.out.println("\n========== REPORT CARD ==========");
        System.out.println("Name: " + student.name);
        System.out.println("---------------------------------");
        System.out.println("Subject\t\tMarks");
        System.out.println("---------------------------------");
        
        for (int i = 0; i < student.subjects.length; i++) {
            System.out.println(student.subjects[i] + "\t\t" + student.marks[i]);
        }
        
        double average = calculateAverage(student.marks);
        String grade = assignGrade(average);
        
        System.out.println("---------------------------------");
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Grade: " + grade);
        System.out.println("=================================\n");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] subjects = {"Math", "Science", "English"};
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            
            int[] marks = new int[subjects.length];
            
            try {
                for (int j = 0; j < subjects.length; j++) {
                    System.out.print(subjects[j] + " marks: ");
                    marks[j] = sc.nextInt();
                }
                sc.nextLine();
                
                validateMarks(marks);
                students.add(new Student(name, subjects, marks));
                
            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Retry for this student
                sc.nextLine();
            }
        }
        
        // Display all reports
        for (Student student : students) {
            displayReport(student);
        }
        
        sc.close();
    }
}
