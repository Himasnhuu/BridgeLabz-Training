package scenariobased;
import java.util.Scanner;
/*
 * Arrays – Temperature Analyzer
 1. Scenario: You're analyzing a week’s worth of hourly temperature data stored in a 2D array
(float[7][24]).
Problem:
Write a method to:
 ● Find the hottest and coldest day,
 ● Return average temperature per day.*/

public class TemperatureAnalyzer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float [][] temp = new float [7][24];
		for (int i=0; i<7; i++) {
			for (int j=0; j<24; j++) {
				temp[i][j] = Math.round(Math.random() * 100.0f * 100.0f) / 100.0f;
			}
		}
		
		for(int i=0; i<7; i++) {
			for(float x : temp[i] ) {
				System.out.print(x+" | ");
			}
			System.out.println();
		}
		
		System.out.print("\nHottest Day : "+hotAndCold(temp)[0]+" "+hotAndCold(temp)[2]+"\n");
		System.out.print("Coldest Day : "+hotAndCold(temp)[1]+" "+hotAndCold(temp)[3]+"\n\n");

		displayAvgResult(avgTemp(temp));
		sc.close();
	} 	
	
	static String[] hotAndCold(float[][] arr) {
		float max = arr[0][0], min = arr[0][0];
		String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		int hotDay=0, coldDay=0;
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<24; j++) {
				if(max<arr[i][j]) {
					max = arr[i][j];
					hotDay = i;
				}
				
				if(min>arr[i][j]) {
					min = arr[i][j];
					coldDay = i;
				}
			}
		}
		
		String mx = String.valueOf(max);
		String mn = String.valueOf(min);
		
		
		
		return new String []{day[hotDay], day[coldDay], mx, mn };
	}
	
	static String avg(float[] arr) {
		float n = 0;
		for(float x:arr) {
			n+=x;
		}
		
		return String.valueOf(Math.round((n/arr.length)*100.0f)/100.0f);
	}
	
	static String[][] avgTemp(float[][] arr) {
		
		String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		String[][] result = new String[7][2];
		
		for(int i=0; i<7; i++) {
			result[i][0] = day[i];
			result[i][1] = avg(arr[i]);
		}
		
		return result;
	}
	
	static void displayAvgResult(String[][] s) {
		for(int i=0; i<7; i++) {
			System.out.print("Average temperature on ");
			for(String x: s[i]) {
				System.out.print(x+" ");
				
			}
			System.out.println();
		}
	}
	
}
