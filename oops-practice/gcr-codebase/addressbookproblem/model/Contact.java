package model;

public class Contact {

	private String fName;
	private String lName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String pNumber;
	private String email;

	public Contact(String fName, String lName, String address, String city, String state, String zip, String pNumber,
			String email) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.pNumber = pNumber;
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getpNumber() {
		return pNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n========== CONTACT DETAILS ==========" +
			   "\nName: " + fName + " " + lName +
			   "\nAddress: " + address +
			   "\nCity: " + city +
			   "\nState: " + state +
			   "\nZip: " + zip +
			   "\nPhone: " + pNumber +
			   "\nEmail: " + email +
			   "\n-----------------------------------------";
	}
	
	// UC 7: Duplicate check
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Contact other = (Contact) obj;
		return this.fName.equalsIgnoreCase(other.fName) && 
		       this.lName.equalsIgnoreCase(other.lName);
	}
	
	@Override
	public int hashCode() {
		String fullName = fName.toLowerCase() + lName.toLowerCase();
		return fullName.hashCode();
	}
}
