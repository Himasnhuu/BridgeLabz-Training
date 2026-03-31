package static_methods.date_format_utility;

import java.time.LocalDate;

public class InvoiceGenerator {
    
    public static void main(String[] args) {
        LocalDate invoiceDate = LocalDate.now();
        
        System.out.println("Invoice Date (ISO): " + 
                          DateFormatter.formatAsISO(invoiceDate));
        System.out.println("Invoice Date (US): " + 
                          DateFormatter.formatAsUS(invoiceDate));
        System.out.println("Invoice Date (EU): " + 
                          DateFormatter.formatAsEU(invoiceDate));
    }
}
