package week4collections.lexicaltwist;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class LexicalTwist {
	public static void main(String[] args) throws InvalidWordException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first Word: ");
		String s1 = sc.nextLine();
		System.out.print("Enter the second Word: ");
		String s2 = sc.nextLine();
		
		sc.close();
		
		if(s1.contains(" ") || s2.contains(" ")) {
			throw new InvalidWordException("Invalid Word");
		}
		
		System.out.println("\nOriginal first word: "+s1);
		System.out.println("Original second word: "+s2);
		String s3 = reversing(s1);
		System.out.println("Reversed first word: "+s3);
		boolean flag = isReverse(s2, s3);
		System.out.println("Reversed  second word is same as the original first word: "+flag+"\n");
		
		if(flag) {
			System.out.println(replacing(s2)+"\n");
		}else {
			String combinedWord = combiningString(s1,s2);
			HashMap <String, Integer> count = countVC(combinedWord);
			System.out.println("Combined Word: "+combinedWord);
			System.out.println(count+"\n");
			
			if(count.get("Vowels") == count.get("Consonants")) {
				System.out.println("Vowels and consonants are equal\n");
			}else if(count.get("Vowels") < count.get("Consonants")) {
				System.out.println("Consonant count is greater: "+firstTwoConsonants(combinedWord));
			}else {
				System.out.println("Vowel count is greater: "+firstTwoVowels(combinedWord));				
			}
		}

	}

	// reversing the string
	static String reversing(String s) {
		int l = s.length();
		String reversed = "";

		for (int i = l - 1; i >= 0; i--) {
			reversed += s.charAt(i);
		}

		return reversed;
	}

	// checking the reverse strings
	static boolean isReverse(String s1, String s2) {
		return s1.equalsIgnoreCase(s2);
	}

	// Replacing the vowels with @
	static String replacing(String s) {
		StringBuilder sb = new StringBuilder();
		s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				sb.append('@');
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	// Combining strings and converting it into upper case
	static String combiningString(String s1, String s2) {

		String s3 = s1 + s2;
		return s3.toUpperCase();
	}

	// Counting vowels and consonants
	static HashMap<String, Integer> countVC(String s) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Vowels", 0);
		hm.put("Consonants", 0);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);


			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				hm.put("Vowels", hm.get("Vowels") + 1);
			} else if(ch>=65 && ch<=90){
				hm.put("Consonants", hm.get("Consonants") + 1);
			}

		}

		return hm;
	}

	// printing first two vowels
	static LinkedHashSet<Character> firstTwoVowels(String s) {

		LinkedHashSet <Character> hs = new LinkedHashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				hs.add(ch);
			}
			if (hs.size() == 2) {
				break;
			}
		}

		return hs;

	}

	// printing first two consonants
	static LinkedHashSet<Character> firstTwoConsonants(String s) {

		LinkedHashSet <Character> hs = new LinkedHashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				continue;
			}
			else if(ch>=65 && ch<=90) {
				hs.add(ch);
			}
			
			if (hs.size() == 2) {
				break;
			}
		}

		return hs;

	}
	

}
