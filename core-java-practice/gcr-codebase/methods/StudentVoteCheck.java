/*Write a program to take user input for the age of all 10 students in a class and check whether the student 
 * can vote depending on his/her age is greater or equal to 18.
Hint => 
Create a class public class StudentVoteChecker and define a method public boolean canStudentVote(int age)
 which takes in age as a parameter and returns true or false
Inside the method firstly validate the age for a negative number, if a negative return is false cannot vote.
 For valid age check for age is 18 or above return true; else return false;
In the main function define an array of 10 integer elements, loop through the array by take user input for 
the student's age, call canStudentVote() and display the result
*/

package Week_01.javaMethods.level2;
import java.util.Scanner;
public class StudentVoteCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentVoteCheck sv = new StudentVoteCheck();
		int[] arr = new int [10];
		System.out.println("Enter the age of 10 students - ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			System.out.println(sv.canStudentVote(arr[i]));
		}

		sc.close();
	}
	
	public boolean canStudentVote(int age) {
		if(age>=18) {
			return true;
		}else {
			return false;
		}
	}
}
