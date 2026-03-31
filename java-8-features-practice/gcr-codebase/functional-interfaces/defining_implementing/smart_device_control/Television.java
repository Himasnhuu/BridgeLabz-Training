package defining_implementing.smart_device_control;

public class Television implements DeviceControl {
    private int channel;
    
    public Television() {
        this.channel = 1;
    }
    
    @Override
    public void turnOn() {
        System.out.println("TV is now ON - Channel " + channel);
    }
    
    @Override
    public void turnOff() {
        System.out.println("TV is now OFF");
    }
}
