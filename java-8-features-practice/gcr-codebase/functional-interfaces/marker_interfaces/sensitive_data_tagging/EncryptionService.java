package marker_interfaces.sensitive_data_tagging;

public class EncryptionService {
    
    public static void processData(Object data) {
        if (data instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data...");
            System.out.println("Data encrypted successfully");
        } else {
            System.out.println("Processing regular data (no encryption needed)");
        }
    }
    
    public static void main(String[] args) {
        CreditCardInfo cardInfo = new CreditCardInfo("1234-5678-9012-3456", "123");
        String regularData = "Regular information";
        
        processData(cardInfo);
        processData(regularData);
    }
}
