package week4collections.flipkeylogicalproblem;

import java.util.Scanner;

public class FlipKey {
	public static void main(String[] args) {
		
		FlipKey f = new FlipKey();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Word: ");
		String s = sc.nextLine();
		String key = f.cleanseAndInvert(s);
		
		if(key.isEmpty()) {
			
			System.out.println("Invalid Input.");
		}else {
			System.out.println("The generated key is - "+key);
		}

		sc.close();
	}

	public String cleanseAndInvert(String input) {

		if (input.isEmpty() || input.length() < 6) {
			return "";
		}

		else if (!input.matches("[a-zA-Z]+")) {
			return "";
		}

		input.toLowerCase();

		StringBuilder sb = new StringBuilder("");

		int count = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) % 2 != 0) {
				char ch = count % 2 == 0 ? Character.toUpperCase(input.charAt(i)) : input.charAt(i);
				sb.append(ch);
				count++;
			}
		}

		return sb.toString();

	}

}
