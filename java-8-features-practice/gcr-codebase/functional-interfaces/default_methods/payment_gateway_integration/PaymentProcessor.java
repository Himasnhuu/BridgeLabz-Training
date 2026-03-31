package default_methods.payment_gateway_integration;

// Interface with default refund method
public interface PaymentProcessor {
    void processPayment(double amount);
    
    default void refund(double amount) {
        System.out.println("Processing refund of $" + amount);
        System.out.println("Refund completed successfully");
    }
}
