package smarthomelighting;

@FunctionalInterface
interface LightBehavior {
    void activate();
}

class SmartLight {
    
    public void executePattern(LightBehavior behavior) {
        behavior.activate();
        System.out.println();
    }
    
    public static void main(String[] args) {
        SmartLight livingRoom = new SmartLight();
        
        // Different light patterns using lambdas
        LightBehavior motionTrigger = () -> System.out.println("  Motion detected - Bright light");
        LightBehavior eveningMode = () -> System.out.println("  Evening mode - Warm light");
        LightBehavior voiceCommand = () -> System.out.println("  Voice: Party mode - RGB cycling");
        
        livingRoom.executePattern(motionTrigger);
        livingRoom.executePattern(eveningMode);
        livingRoom.executePattern(voiceCommand);
    }
}
