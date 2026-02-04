package invoicecreation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001",
            "TXN002", 
            "TXN003",
            "TXN004",
            "TXN005"
        );
        
        System.out.println("=== Invoice Object Creation ===\n");
        
        System.out.println("Transaction IDs:");
        transactionIds.forEach(System.out::println);
        
        System.out.println("\n--- Using Constructor Reference ---");
        
        // Create invoice objects using constructor reference
        // Instead of: .map(id -> new Invoice(id))
        // We use: .map(Invoice::new)
        List<Invoice> invoices = transactionIds.stream()
            .map(Invoice::new)
            .collect(Collectors.toList());
        
        System.out.println("\nGenerated Invoices:");
        invoices.forEach(System.out::println);
        
        System.out.println("\n--- Using Function with Constructor Reference ---");
        
        // Using Function interface with constructor reference
        Function<String, Invoice> invoiceCreator = Invoice::new;
        
        List<Invoice> moreInvoices = new ArrayList<>();
        for (String txnId : Arrays.asList("TXN006", "TXN007", "TXN008")) {
            moreInvoices.add(invoiceCreator.apply(txnId));
        }
        
        System.out.println("\nAdditional Invoices:");
        moreInvoices.forEach(System.out::println);
    }
}
