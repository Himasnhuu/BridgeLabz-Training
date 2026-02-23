package week9.warehouse_cold_storage_temperature_monitor;
class SensorFailureException extends Exception {
    public SensorFailureException(String msg) {
        super(msg);
    }
}
