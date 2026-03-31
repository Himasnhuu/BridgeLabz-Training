package week3dsa.scenario.aerovigil;

import java.util.Scanner;

public class FlightUtil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {

		if (flightNumber.matches("^FL-[1-9][0-9]{3}$")) {
			return true;
		}

		throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");

	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {

		if (flightName.equalsIgnoreCase("SpiceJet") || flightName.equalsIgnoreCase("Vistara")
				|| flightName.equalsIgnoreCase("IndiGo") || flightName.equalsIgnoreCase("Air Arabia")) {

			return true;

		}

		throw new InvalidFlightException("The flight name " + flightName + " is invalid");

	}

	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {

		if (flightName.equalsIgnoreCase("SpiceJet") && passengerCount >0 && passengerCount <= 396) {
			return true;
		} else if (flightName.equalsIgnoreCase("Vistara") && passengerCount >0 && passengerCount <= 615) {
			return true;
		} else if (flightName.equalsIgnoreCase("IndiGo") && passengerCount >0 && passengerCount <= 230) {
			return true;
		} else if (flightName.equalsIgnoreCase("Air Arabia") && passengerCount >0 && passengerCount <= 130) {
			return true;
		}

		throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
	}

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
		
		if (flightName.equalsIgnoreCase("SpiceJet") && currentFuelLevel >=0 && currentFuelLevel<=200000) {
			return 200000-currentFuelLevel;
		} else if (flightName.equalsIgnoreCase("Vistara") && currentFuelLevel >=0 && currentFuelLevel<=300000) {
			return 300000-currentFuelLevel;
		} else if (flightName.equalsIgnoreCase("IndiGo") && currentFuelLevel >=0 && currentFuelLevel<=250000) {
			return 250000-currentFuelLevel;
		} else if (flightName.equalsIgnoreCase("Air Arabia") && currentFuelLevel >=0 && currentFuelLevel<=150000) {
			return 150000-currentFuelLevel;
		}
		
		throw new InvalidFlightException("Invalid fuel level for "+flightName);
		
	}
	
	
}
