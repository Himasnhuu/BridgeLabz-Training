package scenariobased.oops;
import java.util.Scanner;

//Invoice Generator for Freelancers
//Focus: Strings, Methods, Exception Handling
//Scenario:
//You're building an app for freelancers to generate invoice descriptions.
// Requirements:
//Accept input like: "Logo Design - 3000 INR, Web Page - 4500 INR"
//
//Split the string to extract task names and amounts
//Calculate total invoice amount
//If the input format is invalid (missing dash or amount), throw
//InvalidInvoiceFormatException.
//
//Example Methods:
//● parseInvoice(String input)
//● getTotalAmount(String[] tasks)

public class InvoiceGeneratorForFreelancers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String req = getStringInput(sc);
			if (!req.contains("-") || !req.contains(",")) {
			    int[] arr = new int [2];
			    arr[2]=34;
			}

			String[][] cReq= parseInvoice(req);
			double tAmt = getTotalAmount(cReq[1]);
			System.out.print("\n\tTotal Amount: "+tAmt);
		}catch(Exception e) {
			System.out.print("Invalid Input...");
		}
		sc.close();
	}
	
	static String getStringInput(Scanner sc) {
		System.out.print("Type your Requirements: ");
		return sc.nextLine();
	}
	
	static String[][] parseInvoice(String s) {
		String [] work = s.trim().split(",");
		String [] task = new String[work.length];
		String [] amt = new String[work.length];
		
		for(int i=0; i<work.length; i++) {
			task[i] = work[i].split("-")[0].trim();
			amt[i] = work[i].trim().split("-")[1].trim().split(" ")[0].trim();
		}
		System.out.print("\nCustomer Requirements. \n");
		for(String x:work) {
			System.out.println("\t"+x.trim());
		}
		
		return new String[][] {task, amt};
	}
	
	static double getTotalAmount(String[] arr) {
		double sum=0;
		for(String x:arr) {
			sum += Integer.parseInt(x);
		}
		return sum;
	}
}
