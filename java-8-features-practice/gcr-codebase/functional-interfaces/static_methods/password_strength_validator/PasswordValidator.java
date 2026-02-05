package static_methods.password_strength_validator;

public class PasswordValidator {
    
    public static void main(String[] args) {
        String password1 = "Weak123";
        String password2 = "Strong@123";
        
        System.out.println("Password '" + password1 + "' is strong: " + 
                          SecurityUtils.isPasswordStrong(password1));
        System.out.println("Password '" + password2 + "' is strong: " + 
                          SecurityUtils.isPasswordStrong(password2));
    }
}
