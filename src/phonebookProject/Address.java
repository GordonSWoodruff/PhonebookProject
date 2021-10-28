package phonebookProject;

public class Address {
	// Class specific variables
	private String street;
	private String city;
	private String state;
	private int zip;
	// Basic constructor
	public Address () {
		
	}
	// Specific constructor
	public Address(String street, String city, String state, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	// toString override
	@Override
	public String toString() {
		String returnOutput = street + ", " + city + ", " + state + "  " + zip;
		return returnOutput;
	}
	// Getters and setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
}
