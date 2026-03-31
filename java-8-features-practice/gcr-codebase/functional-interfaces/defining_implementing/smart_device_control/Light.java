package defining_implementing.smart_device_control;

public class Light implements DeviceControl {
    private String name;
    
    public Light(String name) {
        this.name = name;
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " light is now ON");
    }
    
    @Override
    public void turnOff() {
        System.out.println(name + " light is now OFF");
    }
}
