package phonebookProject;

public class SearchFirstName extends Search {
	private String searchFName = "";
	public SearchFirstName(Person[] phonebook,String fName) {
		// TODO Auto-generated constructor stub
		searchFName = fName;
	}
	@Override
	public Person[] searchEntry(Person[] phonebook) {
		searchFirstName(phonebook,searchFName);
		return reference;
	}

	private Person[] searchFirstName(Person[] phonebook, String searchFName) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		int place = 0;
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getFirstName().toLowerCase().equals(searchFName.toLowerCase()) == true) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			if(phonebook[i].getFirstName().toLowerCase().equals(searchFName.toLowerCase()) == true) {
				System.out.println(phonebook[i].getFirstName() + " = " + searchFName);
				reference[place] = phonebook[i]; // sets reference to the index
		 		place++;
		 	}
		 }
		return reference; // phonebook[reference];
	}
}
