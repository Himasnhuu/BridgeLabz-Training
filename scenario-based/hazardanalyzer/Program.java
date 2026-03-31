package week3dsa.scenario.hazardanalyzer;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RobotHazardAuditor r = new RobotHazardAuditor();
		
		try {
			System.out.println("Enter Arm Precision (0.0 - 1.0):");
			double ap = sc.nextDouble();
			
			System.out.println("Enter Worker Density (1 - 20):");
			int wd = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
			String ms = sc.nextLine();
			
			System.out.println("Robot Hazard Risk Score: "+r.calculateHazardRisk(ap, wd, ms));
			
		}catch(RobotSafetyException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
