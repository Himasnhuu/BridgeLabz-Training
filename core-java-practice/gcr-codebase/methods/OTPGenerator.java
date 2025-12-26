package Week_01.javaMethods.level3;

public class OTPGenerator {
    
    // method to generate 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }
    
    // method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        int[] otps = new int[10];
        
        System.out.println("Generating 10 OTPs...\n");
        
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        
        boolean unique = areOTPsUnique(otps);
        
        System.out.println("Are all OTPs unique? " + unique);
        
        if (!unique) {
            System.out.println("Duplicate OTPs found! Regeneration recommended.");
        } else {
            System.out.println("All OTPs are unique!");
        }
    }
}
