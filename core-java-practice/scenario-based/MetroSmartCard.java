/* Metro Smart Card Fare Deduction 🚇
In Delhi Metro, fare varies by distance.
● Ask the user for distance.
● Calculate fare using ternary operator.
● Deduct from smart card balance.
Loop until balance is exhausted or the user quits.*/

package scenariobased;
import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // passenger recharges smart card at station counter
        System.out.println("METRO SMART CARD");
        System.out.print("Enter smart card balance (₹): ");
        double balance = sc.nextDouble();
        
        System.out.println("Fare: 0-2km = ₹10, 2-5km = ₹20, 5-12km = ₹30, 12+km = ₹40");
        System.out.println("Enter 0 to exit\n");
        
        // passenger travels until balance runs out
        while(true) {
            System.out.print("Balance: ₹" + balance + " | Enter distance (km): ");
            double distance = sc.nextDouble();
            
            // passenger exits metro
            if(distance == 0) {
                break;
            }
            
            // fare calculation using ternary operator
            double fare = (distance <= 2) ? 10 :
                         (distance <= 5) ? 20 :
                         (distance <= 12) ? 30 : 40;
            
            // check sufficient balance before opening gate
            if(balance < fare) {
                System.out.println("Insufficient balance! Required: ₹" + fare + "\n");
                break;
            }
            
            // deduct fare when passenger taps at entry gate
            balance -= fare;
            System.out.println("Fare deducted: ₹" + fare + "\n");
        }
        
        System.out.println("Final Balance: ₹" + balance);
        System.out.println("Thank you for using Metro Service");
        
        sc.close();
    }
}
