package week9.warehouse_cold_storage_temperature_monitor;
public class WarehouseApp {
    public static void main(String[] args) throws Exception {

        WarehouseService service = new WarehouseService();
        service.addRoom(101);

        service.recordTemperature(101, 5.5);
        service.recordTemperature(101, 9.2);  // alert
        service.recordTemperature(101, 6.0);

        service.generateReport(101);

        // Uncomment to test sensor failure
        // service.recordTemperature(101, 100);
    }
}
