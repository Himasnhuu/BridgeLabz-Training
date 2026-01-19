package dao;

import java.util.ArrayList;
import java.util.HashMap;

public class MultipleAddressBookDAO {
	
	private HashMap<String, AddressBookDAO> addressBooks;
	
	public MultipleAddressBookDAO() {
		this.addressBooks = new HashMap<>();
	}
	
	// UC 6: Add new address book
	public boolean addAddressBook(String name) {
		if (name == null || name.trim().isEmpty()) {
			return false;
		}
		if (addressBooks.containsKey(name)) {
			return false;
		}
		addressBooks.put(name, new AddressBookDAO());
		return true;
	}
	
	public AddressBookDAO getAddressBook(String name) {
		return addressBooks.get(name);
	}
	
	public boolean removeAddressBook(String name) {
		if (addressBooks.containsKey(name)) {
			addressBooks.remove(name);
			return true;
		}
		return false;
	}
	
	public void displayAllAddressBooks() {
		if (addressBooks.isEmpty()) {
			System.out.println("No address books available.");
			return;
		}
		
		System.out.println("\n=== All Address Books ===");
		for (String name : addressBooks.keySet()) {
			AddressBookDAO book = addressBooks.get(name);
			System.out.println(name + " - Contacts: " + book.getContactCount());
		}
	}
	
	public boolean hasAddressBook(String name) {
		return addressBooks.containsKey(name);
	}
	
	public int getAddressBookCount() {
		return addressBooks.size();
	}
	
	public ArrayList<String> getAllAddressBookNames() {
		return new ArrayList<>(addressBooks.keySet());
	}
}
