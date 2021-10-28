package phonebookProject;

public class Person {
	// Class specific variables
	private String firstName;
	private String lastName;
	private long phoneNo;
	private Address personAddress;
	// Basic Constructor
	public Person () {
		
	}
	// Person Constructor
	public Person(String firstName, String lastName, long phoneNo, Address personAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.personAddress = personAddress;
	}
	// Address setter
	public void addAddress(String street, String city, String state, int zip) {
		Address tempAddress = new Address(street,city,state,zip);
		personAddress = tempAddress;
	}
	// Address getter
	public Address getAddress() {
		return this.personAddress;
	}
	// Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	// toString override
	@Override
	public String toString() {
		// Build a phonebook record default entry using Stringbuilder.toString()
		StringBuilder entry = new StringBuilder();
		// Visually build the record
		entry.append(getLastName());
		entry.append(", ");
		entry.append(getFirstName());
		entry.append("   ");
		entry.append(getAddress().toString());
		entry.append(".....");
		String phoneNo = String.valueOf(getPhoneNo());
		phoneNo = phoneNo.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		entry.append(phoneNo);
		// Return the entry as a String
		return entry.toString();
	}
	// Outdated Address getters and setters
//	public Address getPersonAddress() {
//		return personAddress;
//	}
//
//	public void setPersonAddress(Address personAddress, String street) {
//		this.personAddress = personAddress;
//	}
}
