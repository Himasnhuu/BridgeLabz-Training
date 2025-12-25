package Week_01.stringarray.level2;
import java.util.Scanner;

/*
 * Write a program to take user input for the age of all 10 students in a class and check whether the 
 * student can vote depending on his/her age is greater or equal to 18.
Hint => 
Create a method to define the random 2-digit age of several students provided as method parameters and 
return a 1D array of ages of n students
Create a method that takes an array of age as a parameter and returns a 2D String array of age and a boolean
 true or false to indicate can and cannot vote. Inside the method firstly validate the age for a negative number, 
 if a negative cannot vote. For valid age check for age is 18 or above to set true to indicate can vote.
Create a method to display the 2D array in a tabular format.
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

public class StudentVoteDisplay {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input for number of students
		System.out.print("Enter the no. of students : ");
		int n = sc.nextInt();
		
		// Generate and display voting eligibility
		String[][] TwoDArray = stVote(n);
		display2DArray(TwoDArray);
		
		sc.close();
		
		}
		
		
	
	// Method that returns the 1D array of random ages of students
	static int[] ageArray(int n) {
		int[] arr = new int[n];
		
		// Generate random ages between 10 and 24
		for(int i=0; i<n; i++) {
			arr[i] = (int)(Math.random() * 15)+10;
		}
		return arr;
	}
	
	// Method to determine which students can vote
	static String[][] stVote(int n){
		// Get random ages
		int[] arr = ageArray(n);
		String[][] age2DArray= new String[arr.length][2];
		
		// Check voting eligibility for each student
		for(int i=0;i<arr.length;i++) {
			age2DArray[i][0] = String.valueOf(arr[i]);
			
			// Students 18 or older can vote
			if(arr[i]>=18) {
				age2DArray[i][1] = "true";
			}else {
				age2DArray[i][1] = "false";
			}
		}
		return age2DArray;
	}
	
	// Method to display the 2D array
	static void display2DArray(String[][] ar) {
		System.out.println("Displaying 2d array of students age :");
		
		// Display age and voting eligibility for each student
		for(int i=0; i<ar.length; i++) {
			System.out.println(ar[i][0]+ " "+ar[i][1]);
		}
	}
	
}
