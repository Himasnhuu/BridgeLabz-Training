package scenariobased.oops;

import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

// Contact class
class Contact {
    private String name;
    private String phoneNumber;
    
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

// Contact Organizer class
class ContactOrganizer {
    private ArrayList<Contact> contacts;
    
    public ContactOrganizer() {
        contacts = new ArrayList<>();
    }
    
    // Add contact
    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        // Validate phone number
        if (phoneNumber.length() != 10) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }
        
        // Check if it's all digits
        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Phone number must contain only digits");
        }
        
        // Check for duplicate
        if (isDuplicate(phoneNumber)) {
            throw new InvalidPhoneNumberException("Contact with this phone number already exists");
        }
        
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("✓ Contact added successfully!");
    }
    
    // Check duplicate
    private boolean isDuplicate(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
    
    // Delete contact
    public void deleteContact(String phoneNumber) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(i);
                System.out.println("✓ Contact deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("✗ Contact not found!");
        }
    }
    
    // Search contact
    public void searchContact(String phoneNumber) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact Found: " + contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("✗ Contact not found!");
        }
    }
    
    // Display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        System.out.println("\n--- All Contacts ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }
}

// Main class
public class PhoneContactOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactOrganizer organizer = new ContactOrganizer();
        
        while (true) {
            System.out.println("\n=== Phone Contact Organizer ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Phone Number (10 digits): ");
                        String phone = sc.nextLine();
                        organizer.addContact(name, phone);
                        break;
                        
                    case 2:
                        System.out.print("Enter Phone Number to delete: ");
                        String deletePhone = sc.nextLine();
                        organizer.deleteContact(deletePhone);
                        break;
                        
                    case 3:
                        System.out.print("Enter Phone Number to search: ");
                        String searchPhone = sc.nextLine();
                        organizer.searchContact(searchPhone);
                        break;
                        
                    case 4:
                        organizer.displayAllContacts();
                        break;
                        
                    case 5:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                        
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
