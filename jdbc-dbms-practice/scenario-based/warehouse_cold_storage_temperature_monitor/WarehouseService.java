package week9.warehouse_cold_storage_temperature_monitor;
import java.util.*;

class WarehouseService {

    private Map<Integer, TemperatureLog> roomMap = new HashMap<>();

    public void addRoom(int roomId) {
        roomMap.putIfAbsent(roomId, new TemperatureLog());
    }

    public void recordTemperature(int roomId, double temp) throws SensorFailureException {
        TemperatureLog log = roomMap.get(roomId);
        if (log != null) {
            log.addReading(temp);
        }
    }

    public void generateReport(int roomId) {
        TemperatureLog log = roomMap.get(roomId);
        System.out.println("Daily Average Temp: " + log.calculateDailyAverage());
        log.checkAlert();
    }
}
