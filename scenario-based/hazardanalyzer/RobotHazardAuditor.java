package week3dsa.scenario.hazardanalyzer;

public class RobotHazardAuditor {

	public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
			throws RobotSafetyException {

		if (armPrecision >= 0.0 && armPrecision <= 1.0) {
			if (workerDensity >= 0 && workerDensity <= 20) {
				if (machineryState.equals("Worn") || machineryState.equals("Faulty")
						|| machineryState.equals("Critical")) {

					double x = machineryState.equals("Worn") ? 1.3 : machineryState.equals("Faulty") ? 2.0 : 3.0;

					return ((1.0 - armPrecision) * 15.0) + (workerDensity * x);

				}
				throw new RobotSafetyException("Error: Unsupported machinery state");
			}
			throw new RobotSafetyException("Error: Worker density must be 1-20");
		}
		throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");

	}

}
