package invoicecreation;

class Invoice {
    private String transactionId;
    private double amount;
    private String date;
    
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
        this.amount = 0.0;
        this.date = "Not set";
    }
    
    public Invoice(String transactionId, double amount, String date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return String.format("Invoice[ID: %s, Amount: $%.2f, Date: %s]", 
                           transactionId, amount, date);
    }
}
