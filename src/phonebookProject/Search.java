package phonebookProject;


public abstract class Search {
	// Class variables
	private Person[] phonebook;
	protected Person[] reference = new Person[0];
	
	// Code for individual searches goes here
	/* int count = 0;
	 *	int place = 0;
	 *	for (int i = 0; i < phonebook.length; i++) {
	 *		if(phonebook[i].getPhoneNo() == searchPhone) {
	 *			count++;
	 *		}
	 *	}
	 *	Person[] temp = new Person[count];
	 *	reference = temp;
	 *	for (int i = 0; i < count; i++) {  // searches through the person object
	 *		if(phonebook[i].getPhoneNo() == searchPhone) {
	 *	 		reference[place] = phonebook[i]; // sets reference to the index
	 *	 		place++;
	 *	 	}
	 *	 }
	 */ 
	// Abstract method
	public abstract Person[] searchEntry(Person[] phonebook);
	// Unused placeholder method
	public Person[] searchPractice(Person[] phonebook) {
		return reference;
	}
}
