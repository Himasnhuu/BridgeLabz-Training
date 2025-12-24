package Week_01.ProgrammingElements;

// This program calculates the discount amount and final fee after applying a discount
public class FeeDiscount {
    public static void main(String[] args) {
    
        // Define the original fee and discount percentage
        double fee = 125000;
        double discountPercent = 10;

        // Calculate discount amount and final fee after discount
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        // Display the discount amount and final discounted fee
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);
    }
}
