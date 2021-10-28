package phonebookProject;

public class SearchPhoneNo extends Search {
	// Class specific variable
	private long searchPhone = 0L;
	// SearchPhoneNo constructor
	public SearchPhoneNo(Person[] phonebook,long phoneNo) {
		// TODO Auto-generated constructor stub
		searchPhone = phoneNo;
	}

	@Override
	public Person[] searchEntry(Person[] phonebook) {
		reference = searchPhoneNo(phonebook,searchPhone);
		return reference;
	}
	// Class specific method
	private Person[] searchPhoneNo(Person[] phonebook, long searchPhone) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		int place = 0;
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getPhoneNo() == searchPhone) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < count; i++) {  // searches through the person object
			if(phonebook[i].getPhoneNo() == searchPhone) {
		 		reference[place] = phonebook[i]; // sets reference to the index
		 		place++;
		 	}
		 }
		return reference; // phonebook[reference];
	}
}
