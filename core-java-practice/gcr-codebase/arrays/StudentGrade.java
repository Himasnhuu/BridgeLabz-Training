package Week_01.stringarray.level2;
import java.util.Scanner;

public class StudentGrade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input for number of students
		System.out.print("Enter the number of Students : ");
		int n = sc.nextInt();
		
		// Generate random scores for students
		int[][] score = generateScores(n);
		
		// Calculate total, average, and percentage
		double[][] result = calculations(score);
		
		// Calculate grades based on percentage
		String[][] gradeArray = gradeCal(result);
		
		// Display student results
		for(int i=0;i<n;i++) {
			for(int j=0; j<7; j++) {
				System.out.print(gradeArray[i][j]+"  ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	// Method for generating random scores for different subjects
	static int[][] generateScores(int n){
		int[][] score = new int[n][3];
		
		// Generate random scores between 10 and 100
		for (int i=0; i<n;i++) {
			score[i][0]= (int)((Math.random()*90)+10);
			score[i][1]= (int)((Math.random()*90)+10);
			score[i][2]= (int)((Math.random()*90)+10);
		}
		return score;
	}
	
	// Method to calculate total, average, and percentage
	static double[][] calculations(int[][] arr){
		double[][] result = new double[arr.length][6];
		
		// Calculate for each student
		for(int i=0; i<arr.length; i++) {
			// Store original scores
			result[i][0] = arr[i][0];
			result[i][1] = arr[i][1];
			result[i][2] = arr[i][2];
			
			// Calculate total
			result[i][3] = arr[i][0] + arr[i][1] + arr[i][2];
			
			// Calculate average
			result[i][4] = Math.round((result[i][3]/3)*100.0)/100.0;
			
			// Calculate percentage
			result[i][5] = Math.round(((result[i][3]*100)/300)*100.0)/100.0;
		}
		return result;
	}
	
	// Method to find the grade based on percentage
	static String[][] gradeCal(double[][] arr){
		String[][] grade = new String[arr.length][arr[0].length+1];
		
		// Assign grades to each student
		for(int i=0; i<grade.length;i++) {
			// Copy numeric values
			for(int j=0; j<arr[0].length; j++) {
				grade[i][j] = String.valueOf(arr[i][j]);
			}
			
			// Determine grade based on percentage
			if(arr[i][5]>=80) {
				grade[i][6] = String.valueOf('A');
			}
			else if((arr[i][5]>=70)&&(arr[i][5]<=79)) {
				grade[i][6] = String.valueOf('B');
			}
			else if((arr[i][5]>=60)&&(arr[i][5]<=69)) {
				grade[i][6] = String.valueOf('C');
			}
			else if((arr[i][5]>=50)&&(arr[i][5]<=59)) {
				grade[i][6] = String.valueOf('D');
			}
			else if((arr[i][5]>=40)&&(arr[i][5]<=49)) {
				grade[i][6] = String.valueOf('E');
			}else {
				grade[i][6] = String.valueOf('R');
			}
		}
		return grade;
	}
}
