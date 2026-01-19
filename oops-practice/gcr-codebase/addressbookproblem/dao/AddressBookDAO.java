package dao;

import java.util.ArrayList;
import model.Contact;

public class AddressBookDAO {
	
	private ArrayList<Contact> contactInfo = new ArrayList<>();
	
	// UC 2: Add contact
	public boolean addContact(Contact contact) {
		if (contact == null) {
			return false;
		}
		contactInfo.add(contact);
		return true;
	}
	
	// UC 4: Delete contact
	public boolean deleteContact(String firstName, String lastName) {
		for (Contact contact : contactInfo) {
			if (contact.getfName().equalsIgnoreCase(firstName) && 
			    contact.getlName().equalsIgnoreCase(lastName)) {
				contactInfo.remove(contact);
				return true;
			}
		}
		return false;
	}
	
	// UC 3: Update contact
	public boolean updateContact(String firstName, String lastName, Contact newContact) {
		for (int i = 0; i < contactInfo.size(); i++) {
			Contact contact = contactInfo.get(i);
			if (contact.getfName().equalsIgnoreCase(firstName) && 
			    contact.getlName().equalsIgnoreCase(lastName)) {
				contactInfo.set(i, newContact);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Contact> getAllContacts() {
		return contactInfo;
	}
	
	public Contact getContactByName(String firstName) {
		for (Contact contact : contactInfo) {
			if (contact.getfName().equalsIgnoreCase(firstName)) {
				return contact;
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return contactInfo.isEmpty();
	}
	
	public int getContactCount() {
		return contactInfo.size();
	}
}
