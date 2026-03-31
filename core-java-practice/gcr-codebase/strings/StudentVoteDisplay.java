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
		// Take user input
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. of students : ");
		int n = sc.nextInt();
		
		String[][] TwoDArray = stVote(n);
		display2DArray(TwoDArray);
		
		sc.close();
		
		}
		
		
	
	//method that returns the 1d array of randon ages of student
	static int[] ageArray(int n) {
		// Generate random ages between 10-24
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = (int)(Math.random() * 15)+10;
		}
		return arr;
	}
	
	//method to determine students can vote or not
	static String[][] stVote(int n){
		int[] arr = ageArray(n);
		String[][] age2DArray= new String[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			age2DArray[i][0] = String.valueOf(arr[i]);
			if(arr[i]>=18) {
				age2DArray[i][1] = "true";
			}else {
				age2DArray[i][1] = "false";
			}
		}
		return age2DArray;
	}
	
	//method to display the 2D array
	static void display2DArray(String[][] ar) {
		System.out.println("Displaying 2d array of students age :");
		for(int i=0; i<ar.length; i++) {
			System.out.println(ar[i][0]+ " "+ar[i][1]);
		}
	}
	
}
