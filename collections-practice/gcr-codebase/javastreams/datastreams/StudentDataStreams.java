package datastreams;

import java.io.*;

/**
 * Stores and retrieves student primitive data (roll number, name, GPA)
 * using DataOutputStream and DataInputStream
 */
public class StudentDataStreams {
    public static void main(String[] args) {
        String filename = "student.dat";
        
        // Sample student data
        int rollNumber = 12345;
        String name = "Alice Johnson";
        double gpa = 3.85;

        writeStudentData(filename, rollNumber, name, gpa);
        readStudentData(filename);
    }

    // Write primitive data to binary file
    private static void writeStudentData(String filename, int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written successfully");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }

    // Read primitive data from binary file
    private static void readStudentData(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Details:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
