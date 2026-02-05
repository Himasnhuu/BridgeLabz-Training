package functional_interfaces.string_length_checker;

import java.util.function.Function;

// String length checker using Function<String, Integer>
public class StringLengthChecker {
    private int maxLength;
    
    public StringLengthChecker(int maxLength) {
        this.maxLength = maxLength;
    }
    
    public void checkMessage(String message) {
        Function<String, Integer> getLength = str -> str.length();
        
        int length = getLength.apply(message);
        
        if (length > maxLength) {
            System.out.println("Message exceeds character limit! Length: " + 
                             length + ", Max: " + maxLength);
        } else {
            System.out.println("Message is valid. Length: " + length);
        }
    }
}
