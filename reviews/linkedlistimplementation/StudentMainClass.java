package reviews.linkedlistimplementation;

import java.util.Scanner;

public class StudentMainClass {
	public static void main(String[] args) throws InvalidPositionException, StudentNotFoundException {
		boolean flag = true;
		
		StudentLinkedList l = new StudentLinkedList();

		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------");
			System.out.println("1. Add Student at the Beginning");
			System.out.println("2. Add Student at the End");
			System.out.println("3. Add Student at the given position");
			System.out.println("4. Delete Student information by Roll No.");
			System.out.println("5. Display Student Record");
			System.out.println("6. Exit");
			System.out.println("----------------------------------------");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				l.addAtbeg("Himanshu", 18, 24, 1001, "MCA");
				l.addAtbeg("Shivam", 17, 24, 1002, "MCA");
				l.addAtbeg("Nitish", 19, 24, 1003, "MCA");
				l.addAtbeg("Aryansh", 14, 24, 1004, "MCA");
				l.addAtbeg("hariom", 28, 24, 1005, "MCA");
				l.addAtbeg("sunny", 38, 24, 1006, "MCA");
				break;
				
			case 2:
				l.addAtEnd("Himanshu", 12, 24, 1007, "MCA");
				l.addAtEnd("Himanshu", 13, 24, 1008, "MCA");
				l.addAtEnd("Aman", 15, 24, 1009, "MCA");
				l.addAtEnd("Nikhil", 16, 24, 1010, "MCA");
				l.addAtEnd("Himanshu", 20, 24, 1011, "MCA");
				l.addAtEnd("Himanshu", 21, 24, 1012, "MCA");
				break;
				
			case 3:
				l.addAtPosition("Himanshu", 22, 24, 1013, "MCA", -1);
				l.addAtPosition("Vivek", 23, 24, 1014, "MCA", 3);
				l.addAtPosition("Himanshu", 48, 24, 1015, "MCA", 7);
				l.addAtPosition("Ayush", 41, 24, 1016, "MCA", 5);
				l.addAtPosition("Himanshu", 43, 24, 1017, "MCA", 8);
				break;
				
			case 4:
				
				l.deleteByRoll(28);
				l.deleteByRoll(41);
				l.deleteByRoll(17);
				l.deleteByRoll(43);
				break;
				
			case 5:
				
				l.displayStudentRecord();
				break;
				
			case 6:
				flag = false;
				System.out.println("\nExit...\n");
				break;
				
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
