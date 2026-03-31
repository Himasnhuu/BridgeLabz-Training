package leetcode;

import java.util.Scanner;

public class InterLeavingString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));

		sc.close();
	}

	static boolean isInterleave(String s1, String s2, String s3) {

		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		StringBuilder sb3 = new StringBuilder(s3);
		StringBuilder sb4 = new StringBuilder("");
		
		System.out.println("1- "+sb1+"\n");
		System.out.println("2- "+sb2+"\n");
		System.out.println("3- "+sb3+"\n");

		int a = 0;
		int b = 0;
		int i = 0;

		boolean flag = true;
		if(s1.length()+s2.length() != s3.length()) {
			System.out.println("length is not equal");
			return false;
		}

		while (i < sb3.length()) {
			
			if(a==sb1.length()) {
				flag=false;
			}
			
			if(b==sb2.length()) {
				flag=true;
			}
			
			if (flag) {
				if (sb3.charAt(i) == sb1.charAt(a)) {
					sb4.append(sb1.charAt(a));
					a++;
					i++;
				} else {
					flag = false;
				}
			}

			else {
				if (sb3.charAt(i) == sb2.charAt(b)) {
					sb4.append(sb2.charAt(b));
					b++;
					i++;
				} else {
					flag = true;
				}
			}
		}

		return sb4.toString().equals(sb3.toString());

	}
}
