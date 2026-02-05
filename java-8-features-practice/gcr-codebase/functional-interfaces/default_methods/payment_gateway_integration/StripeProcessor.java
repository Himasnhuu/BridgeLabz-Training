package default_methods.payment_gateway_integration;

public class StripeProcessor implements PaymentProcessor {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment: $" + amount);
    }
}
