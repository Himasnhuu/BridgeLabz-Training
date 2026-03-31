// 1. Program to Simulate Student Report
package week2.oops.classesAndObject;

public class Student {
    
    // attributes
    String name;
    String rollNumber;
    double[] marks;
    
    // constructor
    Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    // method to calculate grade based on marks
    String calculateGrade() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        double average = total / marks.length;
        
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
    
    // method to display student details and grade
    void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark" + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Grade " + calculateGrade());
    }
    
    public static void main(String[] args) {
        
        // create first student
        double[] marks1 = {80.0, 70.0, 75.0};
        Student student1 = new Student("Thamarai", "ECE001", marks1);
        student1.displayStudentDetails();
        
        // create second student
        double[] marks2 = {60.0, 65.0, 50.0};
        Student student2 = new Student("Kannan", "CSC002", marks2);
        student2.displayStudentDetails();
    }
}
