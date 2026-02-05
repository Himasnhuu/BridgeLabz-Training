package functional_interfaces.temperature_alert_system;

import java.util.function.Predicate;

// Temperature alert system using Predicate<Double>
public class TemperatureAlertSystem {
    private double threshold;
    
    public TemperatureAlertSystem(double threshold) {
        this.threshold = threshold;
    }
    
    public void checkTemperature(double currentTemp) {
        Predicate<Double> isCritical = temp -> temp > threshold;
        
        if (isCritical.test(currentTemp)) {
            System.out.println("ALERT! Temperature " + currentTemp + 
                             "°C exceeds threshold " + threshold + "°C");
        } else {
            System.out.println("Temperature " + currentTemp + "°C is normal");
        }
    }
}
