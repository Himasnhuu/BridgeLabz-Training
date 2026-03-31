package week9.warehouse_cold_storage_temperature_monitor;
import java.util.*;

class TemperatureLog {

    private List<Double> readings = new ArrayList<>();
    private static final double MIN_SAFE = 2.0;
    private static final double MAX_SAFE = 8.0;

    public void addReading(double temp) throws SensorFailureException {
        if (temp < -30 || temp > 50) {
            throw new SensorFailureException("Sensor failure detected: " + temp);
        }
        readings.add(temp);
    }

    public double calculateDailyAverage() {
        return readings.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public void checkAlert() {
        for (double temp : readings) {
            if (temp < MIN_SAFE || temp > MAX_SAFE) {
                System.out.println("ALERT! Temperature out of safe range: " + temp);
            }
        }
    }
}
