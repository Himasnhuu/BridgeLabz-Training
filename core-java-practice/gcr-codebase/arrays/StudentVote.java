package Week_01.arrays.level1;
import java.util.Scanner;

public class StudentVote {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Create array to store ages of 10 students
		int[] SAge = new int[10];
		
		// Take input for student ages
		System.out.print("Enter the age of 10 students : \n");
		for(int i=0;i<SAge.length;i++) {
			SAge[i]=sc.nextInt();
		}
		
		// Check voting eligibility (age >= 18)
		for(int i=0;i<SAge.length;i++) {
			if(SAge[i]>=18) {
				System.out.printf("The student with the age %d can vote\n", SAge[i]);
			}else {
				System.out.printf("The student with the age %d cannot vote\n", SAge[i]);
			}
		}
	}

}
