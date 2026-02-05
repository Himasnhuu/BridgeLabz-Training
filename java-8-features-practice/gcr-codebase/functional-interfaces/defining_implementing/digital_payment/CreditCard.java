package defining_implementing.digital_payment;

public class CreditCard implements Payment {
    private String cardNumber;
    
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card ending in " + 
                          cardNumber.substring(cardNumber.length() - 4));
    }
}
