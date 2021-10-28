package phonebookProject;
// Import other classes for search
import phonebookProject.SearchFirstName;
import phonebookProject.SearchLastName;

public class SearchFullName extends Search{
	// Class specific variables
    private String searchFName = "";
    private String searchLName = "";
    
    // SearchFullName constructor
    public SearchFullName(Person[] phonebook, String firstName, String lastName) {
    	searchFName = firstName;
    	searchLName = lastName;
    }
    @Override
    public Person[] searchEntry(Person[] phonebook) {
        searchFullName(phonebook,searchFName,searchLName);
        return reference;
    }
    // Class specific method
    private Person[] searchFullName(Person[] phonebook, String searchFName, String searchLName) {
    	Person[] temp = phonebook;
		SearchLastName lastResult = new SearchLastName(phonebook,searchLName);
		temp = lastResult.searchEntry(phonebook);
    	SearchFirstName firstResult = new SearchFirstName(temp,searchFName);
    	reference = firstResult.searchEntry(temp);
    	
    	return reference;
    }
}
