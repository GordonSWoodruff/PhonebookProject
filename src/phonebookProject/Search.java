package phonebookProject;


public abstract class Search {
	private Person[] phonebook;
	protected Person[] reference = new Person[0];
	
	// Code for individual searches goes here
	/* for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
	 * 		if(phonebook[i].getCorrectObectParameter() == particularSearchField) {
	 *			reference = i; // sets reference to the index
	 *		}
	 *	}
	 */ 
	public abstract Person[] searchEntry(Person[] phonebook);
	
	public Person[] searchPractice(Person[] phonebook) {
		return reference;
	}
}
