package phonebookProject;

public class Address {
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public Address () {
		
	}

	public Address(String street, String city, String state, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		String returnOutput = street + ", " + city + ", " + state + "  " + zip;
		return returnOutput;
	}

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
