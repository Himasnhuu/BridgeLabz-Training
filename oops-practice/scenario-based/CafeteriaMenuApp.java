package scenariobased.oops;
import java.util.Scanner;

//Cafeteria Menu App
//Focus: Arrays, Methods
//● Scenario: The campus cafeteria offers 10 fixed items daily. You need to build a system to display menu items and 
//	take orders based on user input.
//● Requirements:
//● Store items in a string[] array.
//● Print the menu with index numbers.
//● Allow the user to select an item by index.
//● Use methods like DisplayMenu(), GetItemByIndex().

public class CafeteriaMenuApp {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		displayMenu();
		System.out.print("\nEnter 0 to confirm your Order...\n");
		String confirm = "";
		StringBuilder sb = new StringBuilder("");		
		while(confirm!="order confirmed") {
			String item = getElementByIndex(sc);
			if (item!="order confirmed") {
				sb.append("|");
				sb.append(item);
			}else {
				sb.append("|");
			}
			confirm = item=="order confirm"?"order confirm": item;
		}
		
		System.out.print("\n"+sb+"\n\n"+confirm+"...");
		
		sc.close();
	}
	
	
	public static void displayMenu() {
		
		String [] menu = {"Dosa","Samosa","Coffee","Chai","Cold Drink","Patties","Sandwich","Vadapao","Popcorn","Pizza","Burgir"};
		System.out.println("WELCOME TO MAKHAN MALAI CAFE\n");
		System.out.println("S.No\tItems");
		System.out.println("----\t-----");
		for(int i=0; i<menu.length; i++) {
			System.out.println(" "+(i+1)+"\t"+menu[i]);
		}
		
	}
	
	public static String getElementByIndex(Scanner sc) {
		String [] menu = {"Dosa","Samosa","Coffee","Chai","Cold Drink","Patties","Sandwich","Vadapao","Popcorn","Pizza","Burgir"};
		System.out.print("Place your order: ");
		int order = sc.nextInt();
		sc.nextLine();
		return order==0?"order confirmed":menu[order];
	}
	
}

