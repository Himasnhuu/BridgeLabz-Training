package default_methods.payment_gateway_integration;

public class PayPalProcessor implements PaymentProcessor {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}
