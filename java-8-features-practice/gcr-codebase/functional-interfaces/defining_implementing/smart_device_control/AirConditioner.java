package defining_implementing.smart_device_control;

public class AirConditioner implements DeviceControl {
    private int temperature;
    
    public AirConditioner() {
        this.temperature = 24;
    }
    
    @Override
    public void turnOn() {
        System.out.println("AC is now ON at " + temperature + "°C");
    }
    
    @Override
    public void turnOff() {
        System.out.println("AC is now OFF");
    }
}
