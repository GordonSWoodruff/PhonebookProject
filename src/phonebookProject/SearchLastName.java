package phonebookProject;

public class SearchLastName extends Search {
	// Class specific variable
	private String searchLName = "";
	// SearchLastName constructor
	public SearchLastName(Person[] phonebook,String lName) {
		// TODO Auto-generated constructor stub
		searchLName = lName;
	}
	@Override
	public Person[] searchEntry(Person[] phonebook) {
		searchLastName(phonebook,searchLName);
		return reference;
	}
	// Class specific method
	private Person[] searchLastName(Person[] phonebook, String searchLName) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		int place = 0;
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getLastName().toLowerCase().equals(searchLName.toLowerCase()) == true) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			if(phonebook[i].getLastName().toLowerCase().equals(searchLName.toLowerCase()) == true) {
				reference[place] = phonebook[i]; // sets reference to the index
		 		place++;
		 	}
		 }
		return reference; // phonebook[reference];
	}
}
