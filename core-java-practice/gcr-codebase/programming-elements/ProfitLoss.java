package Week_01.ProgrammingElements;

// This program calculates profit and profit percentage from cost and selling price
public class ProfitLoss {
    public static void main(String[] args) {
    
        // Define cost price and selling price
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculate profit and profit percentage
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;

        // Display the profit and profit percentage
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice +
            "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercent
        );
    }
}
