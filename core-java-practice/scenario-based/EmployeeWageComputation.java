package scenariobased;


public class EmployeeWageComputation {
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO EMPLOYEE WAGE COMPUTATION PROGRAM.\n");
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("USE CASE 1.");
		String s = useCase1()==true ? "PRESENT" : "ABSENT";
		System.out.println("Employee is "+s);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("USE CASE 2.");
		Double d = useCase2();
		System.out.println("Daily Employee wage is "+d);
		System.out.println("------------------------------------------------------------------");
		
		System.out.println("USE CASE 3.");
		String s2 = useCase3()==true ? "FULL TIME" : "PART TIME";
		System.out.println("Employee is "+s2);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("USE CASE 4.");
		double d1 = s2.equals("FULL TIME") ? useCase4(true) : useCase4(false);
		System.out.println("Employee is "+s2+" and its daily wage is "+d1);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("USE CASE 5.");
		double d2 = useCase5();
		System.out.println("Monthly wage of the Employee is "+d2);
		System.out.println("--------------------------------------------------------------------");
		
		System.out.println("USE CASE 6.");
		double d3 = s2.equals("FULL TIME") ? useCase6(true) : useCase6(false);
		System.out.println("Wages till total working hours or days is reached for a month - Assume 100 hours and 20 days : "+d3);
		System.out.println("-----------------------------------------------------------------------");
		
	}
	
	//method to check the absent and present of the employee
	static boolean useCase1() {
		return ((int)(Math.random()*2)==0)? false : true ;
	}
	
	//method to calculate daily employee wage
	static double useCase2() {
		double dailyWage = 20 * 8;
		return dailyWage;
	}
	
	//method to add part time employee and its wage
	static boolean useCase3() {
		return (int)(Math.random()*2)==0 ? false : true;
	}
	
	//method to calculate wage using switch case statement depending on the type of employment(Part-time or Full-time)
	static double useCase4(boolean x) {
		
		int z = x==true ? 1 : 0;
		
		switch (z){
			
			case 1:
				return 20 * 8;
			
			case 0:
				return 20 * 8;
			
			default:
				return 0;
		}
	}
	
	// method to calculate wages for a month
	static double useCase5() {
		return 20*8*20;
	}
	
	//method to calculate wages till condition of total working hours and days 
	static double useCase6(boolean b) {
		int totalhours = 0;
		int x = b==true ? 1 : 0;
		boolean flag = true;
		
		while(flag) {
			switch (x){
				case 1:
					totalhours+=8;
					break;
				case 0:
					totalhours+=8;
					break;
				default:
					totalhours+=0;
					break;
					
			}
			
			if(totalhours>=20*8+100) {
				flag = false;
			}
			
		}
		
		return totalhours *20;
		
	}
	
}
