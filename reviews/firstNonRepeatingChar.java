package reviews;
import java.util.Scanner;

public class firstNonRepeatingChar {
	
	
	static char findChar(String s) {
		String st = s.toLowerCase();
		int size = s.length();
		
		
		for (int i=0; i<size; i++) {
			
			int count=0;
			
			for (int j=0; j<size; j++) {
				if (i==j) {
					continue;
				}
				else if(st.charAt(i)!=st.charAt(j)){
					count+=1;
				}
			}
			if(count==st.length()-1) {
				return s.charAt(i);
			}
		}
		
		return ' ';
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String s = sc.nextLine();
		
		System.out.print("First non repeating Character : "+findChar(s));
		sc.close();
	}
}
