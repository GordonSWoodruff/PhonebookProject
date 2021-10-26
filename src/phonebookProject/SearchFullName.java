package phonebookProject;

public class SearchFullName extends Search{
    String searchFName = "";
    String searchLName = "";

    @Override
    public Person[] searchEntry(Person[] phonebook) {
        searchFullName(phonebook,searchFName,searchLName);
        return reference;
    }
    
    private Person[] searchFullName(Person[] phonebook, String searchFName, String searchLName) {
    	return reference;
    }
    private Person[] searchLastName(Person[] phonebook, String searchFName) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getLastName() == searchLName) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			if(phonebook[i].getLastName() == searchLName) {
		 		reference[i] = phonebook[i]; // sets reference to the index
		 	}
		 }
		return reference; // phonebook[reference];
	}
    private Person[] searchFirstName(Person[] phonebook, String searchFName) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getFirstName() == searchFName) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			if(phonebook[i].getFirstName() == searchFName) {
		 		reference[i] = phonebook[i]; // sets reference to the index
		 	}
		 }
		return reference; // phonebook[reference];
	}
}
