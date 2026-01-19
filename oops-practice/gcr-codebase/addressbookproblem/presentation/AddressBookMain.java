package presentation;

import java.util.Scanner;
import service.AddressBookService;

public class AddressBookMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		AddressBookService service = new AddressBookService();
		
		System.out.println("\nWELCOME TO ADDRESS BOOK SYSTEM\n");
		
		boolean running = true;
		
		while (running) {
			
			System.out.println("\nMAIN MENU");
			System.out.println("1. Add New Contact");
			System.out.println("2. Edit Existing Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display All Contacts");
			System.out.println("5. Search Contact by Name");
			System.out.println("6. Show Total Contact Count");
			System.out.println("7. Exit Application");
			System.out.print("Enter your choice (1-7): ");
			
			int choice;
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("\nInvalid input! Please enter a number between 1-7.");
				scanner.nextLine();
				continue;
			}
			
			switch (choice) {
				case 1:
					addContact(scanner, service);
					break;
					
				case 2:
					editContact(scanner, service);
					break;
					
				case 3:
					deleteContact(scanner, service);
					break;
					
				case 4:
					displayAllContacts(service);
					break;
					
				case 5:
					searchByName(scanner, service);
					break;
					
				case 6:
					showCount(service);
					break;
					
				case 7:
					System.out.println("\nThank you for using Address Book!");
					System.out.println("Goodbye!\n");
					running = false;
					break;
					
				default:
					System.out.println("\nInvalid choice! Please select 1-7.");
			}
		}
		
		scanner.close();
	}
	
	private static void addContact(Scanner scanner, AddressBookService service) {
		System.out.println("\nADD NEW CONTACT");
		
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Address: ");
		String address = scanner.nextLine();
		
		System.out.print("City: ");
		String city = scanner.nextLine();
		
		System.out.print("State: ");
		String state = scanner.nextLine();
		
		System.out.print("Zip Code: ");
		String zip = scanner.nextLine();
		
		System.out.print("Phone Number (10 digits): ");
		String phone = scanner.nextLine();
		
		System.out.print("Email: ");
		String email = scanner.nextLine();
		
		String result = service.addContact(firstName, lastName, address, city, state, zip, phone, email);
		System.out.println("\n" + result);
	}
	
	private static void editContact(Scanner scanner, AddressBookService service) {
		System.out.println("\nEDIT CONTACT");
		
		System.out.print("Enter First Name of contact to edit: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Enter Last Name of contact to edit: ");
		String lastName = scanner.nextLine();
		
		System.out.println("\nEnter new details (press Enter to keep existing):");
		
		System.out.print("New Address: ");
		String newAddress = scanner.nextLine();
		
		System.out.print("New City: ");
		String newCity = scanner.nextLine();
		
		System.out.print("New State: ");
		String newState = scanner.nextLine();
		
		System.out.print("New Zip: ");
		String newZip = scanner.nextLine();
		
		System.out.print("New Phone: ");
		String newPhone = scanner.nextLine();
		
		System.out.print("New Email: ");
		String newEmail = scanner.nextLine();
		
		String result = service.editContact(firstName, lastName, newAddress, newCity, newState, newZip, newPhone, newEmail);
		System.out.println("\n" + result);
	}
	
	private static void deleteContact(Scanner scanner, AddressBookService service) {
		System.out.println("\nDELETE CONTACT");
		
		System.out.print("Enter First Name of contact to delete: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Enter Last Name of contact to delete: ");
		String lastName = scanner.nextLine();
		
		System.out.print("\nAre you sure? (yes/no): ");
		String confirm = scanner.nextLine();
		
		if (confirm.equalsIgnoreCase("yes") || confirm.equalsIgnoreCase("y")) {
			String result = service.deleteContact(firstName, lastName);
			System.out.println("\n" + result);
		} else {
			System.out.println("\nDeletion cancelled.");
		}
	}
	
	private static void displayAllContacts(AddressBookService service) {
		String result = service.displayAllContacts();
		System.out.println(result);
	}
	
	private static void searchByName(Scanner scanner, AddressBookService service) {
		System.out.println("\nSEARCH CONTACT");
		
		System.out.print("Enter First Name to search: ");
		String name = scanner.nextLine();
		
		String result = service.displayContactByName(name);
		System.out.println(result);
	}
	
	private static void showCount(AddressBookService service) {
		String result = service.getContactCount();
		System.out.println("\n" + result);
	}
}
