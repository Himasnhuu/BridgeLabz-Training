package marker_interfaces.sensitive_data_tagging;

public class CreditCardInfo implements SensitiveData {
    private String cardNumber;
    private String cvv;
    
    public CreditCardInfo(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getCvv() {
        return cvv;
    }
}
