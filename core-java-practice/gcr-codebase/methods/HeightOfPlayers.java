
/*Create a program to find the shortest, tallest, and mean height of players present in a football team.
Hint => 
The formula to calculate the mean is: mean = sum of all elements/number of elements
Create an int array named heights of size 11 and get 3 digits random height in cms for each player in the 
range 150 cms to 250 cms
Write the method to Find the sum of all the elements present in the array.
Write the method to find the mean height of the players on the football team
Write the method to find the shortest height of the players on the football team 
Write the method to find the tallest height of the players on the football team
Finally display the results
*/

package Week_01.javaMethods.level3;
import java.util.Scanner;
public class HeightOfPlayers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HeightOfPlayers hr = new HeightOfPlayers();
		
		System.out.print("Enter the number of players : ");
		int n = sc.nextInt();
		
		int[] players = hr.generatePlayers(n);
		int sum = hr.sum(players);
		double mean = hr.mean(players);
		
		for(int i=0; i<players.length; i++) {
			System.out.print(players[i]+" ");
		}
		
		System.out.print("\nsum : "+sum);
		System.out.print("\nmean : "+mean);
		System.out.print("\nShortest : "+hr.shortest(players));
		System.out.print("\nTallest : "+hr.tallest(players));
		
		sc.close();
	}
	
	int[] generatePlayers(int n) {
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = (int)(Math.random()*900)+100;
		}
		return arr;
	}
	
	int sum(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	double mean(int[] arr) {
		double sm = sum(arr);
		double mn = sm/arr.length;
		return mn;
		
	}
	
	int shortest(int[] arr) {
		int min=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	int tallest(int[] arr) {
		int max=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
}
