package service;

import java.util.ArrayList;
import dao.AddressBookDAO;
import model.Contact;

public class AddressBookService {
	
	public AddressBookDAO dao;
	
	public AddressBookService() {
		this.dao = new AddressBookDAO();
	}
	
	// UC 2, 7: Add contact with validation and duplicate check
	public String addContact(String firstName, String lastName, String address, 
	                        String city, String state, String zip, String phone, String email) {
		
		if (firstName == null || firstName.trim().isEmpty()) {
			return "Error: First name cannot be empty!";
		}
		
		if (lastName == null || lastName.trim().isEmpty()) {
			return "Error: Last name cannot be empty!";
		}
		
		if (phone == null || phone.trim().isEmpty()) {
			return "Error: Phone number cannot be empty!";
		}
		
		String cleanPhone = phone.replaceAll("[^0-9]", "");
		if (cleanPhone.length() != 10) {
			return "Error: Phone number must be 10 digits!";
		}
		
		if (email != null && !email.trim().isEmpty()) {
			if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
				return "Error: Invalid email format!";
			}
		}
		
		// UC 7: Duplicate check
		Contact tempContact = new Contact(firstName, lastName, "", "", "", "", "", "");
		ArrayList<Contact> existingContacts = dao.getAllContacts();
		if (existingContacts.contains(tempContact)) {
			return "Error: Duplicate contact! A person with the same name already exists!";
		}
		
		Contact newContact = new Contact(firstName, lastName, address, city, 
		                                 state, zip, phone, email);
		
		boolean success = dao.addContact(newContact);
		if (success) {
			return "Contact added successfully!";
		} else {
			return "Error: Failed to add contact!";
		}
	}
	
	// UC 3: Edit contact
	public String editContact(String firstName, String lastName, String newAddress, 
	                        String newCity, String newState, String newZip, String newPhone, String newEmail) {
		
		Contact existingContact = null;
		for (Contact contact : dao.getAllContacts()) {
			if (contact.getfName().equalsIgnoreCase(firstName) && 
			    contact.getlName().equalsIgnoreCase(lastName)) {
				existingContact = contact;
				break;
			}
		}
		
		if (existingContact == null) {
			return "Error: Contact not found!";
		}
		
		if (newAddress != null && !newAddress.trim().isEmpty()) {
			existingContact.setAddress(newAddress);
		}
		
		if (newCity != null && !newCity.trim().isEmpty()) {
			existingContact.setCity(newCity);
		}
		
		if (newState != null && !newState.trim().isEmpty()) {
			existingContact.setState(newState);
		}
		
		if (newZip != null && !newZip.trim().isEmpty()) {
			existingContact.setZip(newZip);
		}
		
		if (newPhone != null && !newPhone.trim().isEmpty()) {
			String cleanPhone = newPhone.replaceAll("[^0-9]", "");
			if (cleanPhone.length() != 10) {
				return "Error: Phone number must be 10 digits!";
			}
			existingContact.setpNumber(newPhone);
		}
		
		if (newEmail != null && !newEmail.trim().isEmpty()) {
			if (!newEmail.contains("@") || newEmail.indexOf("@") != newEmail.lastIndexOf("@")) {
				return "Error: Invalid email format!";
			}
			existingContact.setEmail(newEmail);
		}
		
		return "Contact updated successfully!";
	}
	
	// UC 4: Delete contact
	public String deleteContact(String firstName, String lastName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			return "Error: Please provide a name!";
		}
		
		if (lastName == null || lastName.trim().isEmpty()) {
			return "Error: Please provide last name!";
		}
		
		boolean deleted = dao.deleteContact(firstName, lastName);
		
		if (deleted) {
			return "Contact deleted successfully!";
		} else {
			return "Error: Contact not found!";
		}
	}
	
	// UC 5: Display all contacts
	public String displayAllContacts() {
		ArrayList<Contact> contacts = dao.getAllContacts();
		
		if (contacts.isEmpty()) {
			return "\nNo contacts in address book.";
		}
		
		StringBuilder result = new StringBuilder();
		result.append("\nALL CONTACTS IN ADDRESS BOOK");
		
		for (int i = 0; i < contacts.size(); i++) {
			result.append("\nContact #").append(i + 1).append(":");
			result.append(contacts.get(i).toString());
		}
		
		result.append("\n\nTotal Contacts: ").append(contacts.size());
		return result.toString();
	}
	
	public String displayContactByName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			return "Error: Please provide a name to search!";
		}
		
		Contact contact = dao.getContactByName(firstName);
		
		if (contact == null) {
			return "Contact not found with name: " + firstName;
		}
		
		return "\nCONTACT FOUND\n" + contact.toString();
	}
	
	public String getContactCount() {
		int count = dao.getContactCount();
		return "Total contacts in address book: " + count;
	}
	
	// UC 8: Search by city
	public ArrayList<Contact> searchByCity(String city) {
		ArrayList<Contact> result = new ArrayList<>();
		if (city == null || city.trim().isEmpty()) {
			return result;
		}
		
		ArrayList<Contact> allContacts = dao.getAllContacts();
		for (Contact contact : allContacts) {
			if (contact.getCity() != null && contact.getCity().equalsIgnoreCase(city)) {
				result.add(contact);
			}
		}
		return result;
	}
	
	// UC 8: Search by state
	public ArrayList<Contact> searchByState(String state) {
		ArrayList<Contact> result = new ArrayList<>();
		if (state == null || state.trim().isEmpty()) {
			return result;
		}
		
		ArrayList<Contact> allContacts = dao.getAllContacts();
		for (Contact contact : allContacts) {
			if (contact.getState() != null && contact.getState().equalsIgnoreCase(state)) {
				result.add(contact);
			}
		}
		return result;
	}
	
	// UC 9: View by city
	public java.util.HashMap<String, ArrayList<Contact>> viewPersonsByCity() {
		java.util.HashMap<String, ArrayList<Contact>> cityMap = new java.util.HashMap<>();
		ArrayList<Contact> allContacts = dao.getAllContacts();
		
		for (Contact contact : allContacts) {
			String city = contact.getCity();
			if (city == null || city.trim().isEmpty()) {
				continue;
			}
			
			if (!cityMap.containsKey(city)) {
				cityMap.put(city, new ArrayList<Contact>());
			}
			cityMap.get(city).add(contact);
		}
		return cityMap;
	}
	
	// UC 9: View by state
	public java.util.HashMap<String, ArrayList<Contact>> viewPersonsByState() {
		java.util.HashMap<String, ArrayList<Contact>> stateMap = new java.util.HashMap<>();
		ArrayList<Contact> allContacts = dao.getAllContacts();
		
		for (Contact contact : allContacts) {
			String state = contact.getState();
			if (state == null || state.trim().isEmpty()) {
				continue;
			}
			
			if (!stateMap.containsKey(state)) {
				stateMap.put(state, new ArrayList<Contact>());
			}
			stateMap.get(state).add(contact);
		}
		return stateMap;
	}
	
	// UC 10: Count by city
	public int getCountByCity(String city) {
		return searchByCity(city).size();
	}
	
	// UC 10: Count by state
	public int getCountByState(String state) {
		return searchByState(state).size();
	}
}
