package week3dsa.scenario.aerovigil;
import java.util.Scanner;


public class UserInterface {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter flight details");
		String[] data = sc.nextLine().split(":");
		
		String no = data[0];
		String name = data[1];
		int p = Integer.parseInt(data[2]);
		int f = Integer.parseInt(data[3]);
		
		FlightUtil fu = new FlightUtil();
		
		try {
			if(fu.validateFlightNumber(no) && fu.validateFlightName(name) && fu.validatePassengerCount(p, name)) {
				System.out.println("Fuel required to fill the tank: "+fu.calculateFuelToFillTank(name, f)+" liters");
			}
		}catch(InvalidFlightException e){
			System.out.println(e.getMessage());
		}
		

		sc.close();
	}
}
