package Week_01.stringarray.level2;
import java.util.Scanner;

/*
 * Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, 
 * paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a 
 * player or a computer will win. Show the stats of player and computer win in a tabular format across multiple 
 * games. Also, show the winning percentage between the player and the computer.
Hint => 
The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins (paper covers rock); 
scissors-paper: scissors win (scissors cuts paper)
Create a Method to find the Computer Choice using the Math.random
Create a Method to find the winner between the user and the computer
Create a Method to find the average and percentage of wins for the user and the computer and return a String 2D array
Create a Method to display the results of every game and also display the average and percentage wins 
In the main take user input for the number of games and call methods to display results
*/

public class RockPaperScissor {
	public static void main(String[] args) {
		// Take user input for number of games
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of games you wants to play : ");
		int n = sc.nextInt();
		System.out.println("Click r for rock, p for paper and s for scissor");
		System.out.println("Game Starts ...");
		System.out.println();
		displayResult(n);
		
		sc.close();
	}
	
	//method to find the winner and looser in a game
	static String findWL(String user, String Computer) {
		// Compare choices and determine winner
		if (user=="rock") {
			if (Computer=="rock") {
				return "Draw";
			}else if(Computer=="paper"){
				return "Computer Wins";
			}else {
				return "user Wins";
			}
		}else if(user=="paper") {
			if(Computer=="paper") {
				return "Draw";
			}else if(Computer=="rock") {
				return "user Wins";
			}else {
				return "Computer Wins";
			}
		}else {
			if(Computer=="paper") {
				return "user Wins";
			}else if(Computer=="rock") {
				return "Computer Wins";
			}else {
				return "Draw";
			}
		}
	}
	
	//method to find out Computers Choice
	static String computersChoice() {
		String [] arr = {"rock", "paper", "scissor"};
		int index = (int)(Math.random() * arr.length);
		return arr[index];
	}
	
	//method to find users choice
	static String usersChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your choice : ");
		char ch = sc.nextLine().charAt(0);
		char c = ch;
		if ((ch>='A')&&(ch<='Z')) {
			c = (char)(ch+32);
		}
		
		if(c=='r') {
			return "rock";
		}else if(c=='p') {
			return "paper";
		}else if(c=='s') {
			return "scissor";
		}else {
			return "Invalid Choice";
		}
	}
	
	// method to start the game
	static String startgame() {
		
		String uChoice = usersChoice();
		System.out.println("Your choice : "+uChoice);
		
		String CChoice = computersChoice();
		System.out.println("Computers Choice : "+CChoice);
		
		String result = findWL(uChoice, CChoice);
		return result;
	}
	
	
	// Displaying the result of the game
	static void displayResult(int n) {
		String result;
		int u=0, c=0;
		for(int i=0; i<n; i++) {
			result = startgame();
			if(result=="user Wins") {
				u++;
			}
			if(result=="Computer Wins") {
				c++;
			}
			
			System.out.println(result);
			System.out.println("USER = "+u+" & COMPUTER = "+c);
			System.out.println();
			
		}
		
		double uavg = (double)(u/n);
		double upercent = (double)((u*100)/n);
		System.out.println("Users Average wins = "+uavg+"   Users winning percent = "+upercent+"%");
		
		double cavg = (double)(c/n);
		double cpercent = (double)((c*100)/n);
		System.out.println("Computers Average wins = "+cavg+"   Computers winning percent = "+cpercent+"%");
	}
	
}
