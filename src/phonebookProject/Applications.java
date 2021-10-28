package phonebookProject;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Applications {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Start with 5 records already in the phonebook
		Person[] phonebook = new Person[5];
		Address a1 = new Address("114 Market St.","St Louis","MO",63403);
		phonebook[0] = new Person("John","Doe",6366435689L,a1);
		Address a2 = new Address("113 E Cedar St","St Louis","MO",63402);
		phonebook[1] = new Person("William","Jones",6364833219L,a2);
		Address a3 = new Address("1 Cranberry Ave","St Louis","MO",63404);
		phonebook[2] = new Person("Victoria","Chase",6363428539L,a3);
		Address a4 = new Address("114 Market St.","St Louis","MO", 63403);
		phonebook[3] = new Person("Jane","Doe",6366438979L,a4);
		Address a5 = new Address("1234 Main St","Granite City","IL",62040);
		phonebook[4] = new Person("William","Vanderstumpf",8154762345L,a5);
		mainMenu(phonebook);  // Call the mainMenu method
	}
	
	// Main Menu
	private static void mainMenu(Person[] phonebook) {
		// Declare and define variables
		boolean validInput = false;
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// Display the main menu
		System.out.println("+-+-+-+-+-+-+PHONE BOOK+-+-+-+-+-+-+");
		System.out.println("+-+-+-+-+-+-+ MAIN MENU +-+-+-+-+-+-+");
		System.out.println("1) DISPLAY all records");
		System.out.println("2) Add a NEW record");
		System.out.println("3) DELETE a record");
		System.out.println("4) UPDATE a record");
		System.out.println("5) SEARCH for a record");
		System.out.println("6) SORT all records in \n   ascending order");
		System.out.println("7) END the program");
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		// Error checking for correct valid input
		while (!validInput) {
			try {
				// If choice is valid, call menuChoice and set valid input to true
				int choice = userInput.nextInt();
				menuChoice(choice,phonebook);
				validInput = true;
				userInput.close();
			} catch (NumberFormatException e) {
				System.out.println("1NFE: Oops, that's not a valid input, please"
						+ " enter a number!");
				System.out.println("1) DISPLAY  2) NEW  3) DELETE  4) UPDATE  5)"
						+ " SEARCH  6) SORT  7) END");
				userInput.nextLine();
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println("2IAE: Oops, that's not a valid input, please"
						+ " enter a number!");
				System.out.println("1) DISPLAY  2) NEW  3) DELETE  4) UPDATE  5)"
						+ " SEARCH  6) SORT  7) END");
				userInput.nextLine();
				continue;
			} catch (InputMismatchException e) {
				System.out.println("3IME: Oops, that's not a valid input, please"
						+ " enter a number!");
				System.out.println("1) DISPLAY  2) NEW  3) DELETE  4) UPDATE  5)"
						+ " SEARCH  6) SORT  7) END");
				userInput.nextLine();
				continue;
			}
		}
	}
	
	// menuChoice method executes the choice from mainMenu
	private static void menuChoice(int choice, Person[] phonebook) {
		// Declare and define variables
		boolean redoSection = true;
		String redo = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// switch statement to execute the different methods of the phonebook
		switch(choice) {
		// Case 1 = DISPLAY all records
		case 1:
			boolean userContinue = false;
			displayAllRecords(phonebook);
			System.out.println("Press ENTER to continue!");
			String input = userInput.nextLine();
			while (!userContinue) {
				if(input.equals("")) {
					userContinue = true;
				}	
			}
			mainMenu(phonebook);
			break;
		// Case 2 = ADD an entry to the phonebook, then display 
		case 2:
			while(redoSection) {
				phonebook = addEntry(phonebook);
				System.out.println("Do you want to ADD another record? (Y/N) ");
				redo = userInput.nextLine();
				redoSection = toBoolean(redo);
				if(!redoSection) {
					mainMenu(phonebook);
				}
			}
			break;
		case 3:
			while(redoSection) {
				phonebook = checkDelete(phonebook);
				System.out.println("Do you want to DELETE another record? (Y/N) ");
				redo = userInput.nextLine();
				redoSection = toBoolean(redo);
				if(!redoSection) {
					mainMenu(phonebook);
				}
			}
			break;
		case 4:
			while(redoSection) {
				System.out.println("Main Menu Phonebook size = " + phonebook.length);
				phonebook = checkUpdate(phonebook);
				System.out.println("Do you want to UPDATE another record? (Y/N) ");
				redo = userInput.nextLine();
				redoSection = toBoolean(redo);
				if(!redoSection) {
					mainMenu(phonebook);
				}
			}
			break;
		case 5:
			while(redoSection) {
				System.out.println("Main Menu Phonebook size = " + phonebook.length);
				search(phonebook);
				System.out.println("Do you want to SEARCH FOR another record? (Y/N) ");
				redo = userInput.nextLine();
				redoSection = toBoolean(redo);
				if(!redoSection) {
					mainMenu(phonebook);
				}
			}
			break;
		case 6:
			showAscending();
			break;
		case 7:
			System.out.println("Do you want to quit? (Y/N)");
			String quitP = userInput.nextLine();
			boolean endProg = toBoolean(quitP);
			if (endProg == true) {
				System.out.println("Thank you for using this program!");
				System.exit(0);
			} else {
				mainMenu(phonebook);
			}
			break;
		}
		userInput.close();
	}
	
	// displayAllRecords method
	private static void displayAllRecords(Person[] phonebook) {
		System.out.println("Displaying all " + phonebook.length + " records.");
		for(int i = 0; i < phonebook.length; i++) {
			System.out.println(phonebook[i].toString());
		}
	}
	
	// displaySearchRecord method
	private static void displaySearchRecord(Person[] entry) {
		System.out.println("Displaying all " + entry.length + " record(s).");
		for(int i = 0; i < entry.length; i++) {
			System.out.println((i+1) + ") " + entry[i].toString());	
		}
	}
	
	
	// addEntry method
	private static Person[] addEntry(Person[] phonebook) {
		// Declare and define variables
		int choice = 0;
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		System.out.println("Do you want to enter record information \n 1) MANUALLY or by \n 2) PASTING?");
		choice = userInput.nextInt();
		switch (choice) {
		case 1:
			phonebook = addEntryManual(phonebook);
			break;
		case 2:
			phonebook = addEntryPaste(phonebook);
			break;
		}
		return phonebook;
	}

	// addEntryManual methods
//	private static Person[] addEntry(Person[] phonebook) {
	private static Person[] addEntryManual(Person[] phonebook) {
		// Declare and define needed variables
		boolean validInput = false;
		int addZip = 0;
		long addPhoneNo = 0L;
		String addCity = "";
		String addFirstName = "";
		String addLastName = "";
		String addStreet = "";
		String addState = "";
		String trash = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// Enter information into variables for entry into phonebook
		System.out.println("Please enter the first name: ");
		addFirstName = userInput.nextLine();
		System.out.println("Please enter the last name: ");
		addLastName = userInput.nextLine();
		System.out.println("Please enter the phone number: ");
		// Error correction for entering a phone number
		while(!validInput) {
			try {
				addPhoneNo = userInput.nextLong();
				trash = userInput.nextLine();
				if(addPhoneNo > 9999999999L || addPhoneNo < 1000000000L) {
					validInput = false;
					System.out.println("Please enter a 9 digit telephone number!");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a 9 digit telephone number!");
				trash = userInput.nextLine();
				continue;
			}	
		}
		System.out.println("Please enter the street number and name: ");
		addStreet = userInput.nextLine();
		System.out.println("Please enter the city: ");
		addCity = userInput.nextLine();
		// Error correction for entering a 2 letter state abbreviation
		validInput = false;
		while(!validInput) {
			System.out.println("Please enter the state abbreviation: ");
			addState = userInput.nextLine();
			if(addState.length() != 2) {
				validInput = false;
				System.out.println("Please enter a 2 letter state abbreviation)");
			} else {
				validInput = true;
			}
		}
		// Error correction for entering a 5 digit ZIP code
		validInput = false;
		System.out.println("Please enter the zip code: ");
		while(!validInput) {
			try {
				addZip = userInput.nextInt();
				trash = userInput.nextLine();
				if(addZip > 99999 || addZip < 0) {
					validInput = false;
					System.out.println("Please enter a 5 digit ZIP code!");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a 5 digit ZIP code!");
				trash = userInput.nextLine();
				continue;
			}	
		}
		// Populate the variables into objects
		Address a1 = new Address(addStreet,addCity,addState,addZip);
		Person ap1 = new Person(addFirstName,addLastName,addPhoneNo,a1);
		// insert newly created Person into phonebook
		phonebook = insertObject(phonebook,ap1);
		displayAllRecords(phonebook);
		return phonebook;
	}
	private static Person[] addEntryPaste(Person[] phonebook) {
		// Declare and define variables
		String pastedPerson = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// Paste entry input
		System.out.println("Please paste the user information (ensure each section"
				+ " is separated by a comma followed by a space): ");
		System.out.println("Example: John Jones, 1681 Broadway, New York City, NY, 10019, 2121234567");
		pastedPerson = userInput.nextLine();
		// Declare split variables
		String firstName = "";
		String lastName = "";
		String[] pastedSplit = pastedPerson.split(", ");
		String[] nameSplit = pastedSplit[0].split(" ");
		// Split the name into first and last name
		if(nameSplit.length > 2) {
			for(int i = 0; i < nameSplit.length - 1; i++) {
				if(i == 0) {
					firstName = nameSplit[i];
				} else if(i > 0 && i < nameSplit.length - 2) {
					firstName = firstName + " " + nameSplit[i];
				} else {
					firstName = firstName + " " + nameSplit[i];
					lastName = lastName + nameSplit[i + 1];
				}
			}
		} else {
			for(int i = 0; i < nameSplit.length - 1; i++) {
				if(i == 0) {
					firstName = nameSplit[i];
					lastName = nameSplit[i + 1];
				}
			}
		}

		// Declare object variables and define them with pastedSplit info
		int addZip = Integer.parseInt(pastedSplit[4]);
		long addPhoneNo = Long.parseLong(pastedSplit[5]);
		String addCity = pastedSplit[2];
		String addFirstName = firstName;
		String addLastName = lastName;
		String addState = pastedSplit[3];
		String addStreet = pastedSplit[1];
		
		// Populate the variables into objects
		Address a1 = new Address(addStreet,addCity,addState,addZip);
		Person ap1 = new Person(addFirstName,addLastName,addPhoneNo,a1);
		// insert newly created Person into phonebook
		phonebook = insertObject(phonebook,ap1);
		displayAllRecords(phonebook);
		return phonebook;
	}
	// Insert Person object into phonebook
	private static Person[] insertObject(Person[] phonebook, Person ap1) {
		// Create a temp array with 1 extra record
		Person[] temp = new Person[(phonebook.length) + 1];
		// Loop through the temp array and add anything already in the phonebook array
		for(int i = 0; i < phonebook.length; i++) {
			temp[i] = phonebook[i];
		}
		// Insert the information to add into phonebook array
		temp[temp.length - 1] = ap1;
		// Replace the old phonebook with the new one
		phonebook = temp;
		// Return changed phonebook
		return phonebook;
	}
	
	// delete methods (checkDelete & deleteEntry)
	private static Person[] checkDelete(Person[] phonebook) {
		// Declare and define variables
		boolean deleteRecord = false;
		int choice = 0;
		long deleteNumber = 0L;
		Person[] reference = new Person[0];
		String flagName = "";
		String trash = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// Get userInput for deletion
		reference = search(phonebook); //personByPhone(phonebook,searchNo);
		if(reference.length > 1) {
			System.out.println("Enter the number of the record you want to delete: ");
			choice = userInput.nextInt();
			trash = userInput.nextLine();
			System.out.println("Are you sure you want to delete this record? (Y/N)");
			flagName = userInput.nextLine();
			deleteRecord = toBoolean(flagName);
			if(deleteRecord) {
				deleteNumber = reference[choice - 1].getPhoneNo();
				phonebook = deleteEntry(phonebook,deleteNumber);
			}
		} else if (reference.length == 1) {
			System.out.println("Are you sure you want to delete this record? (Y/N)");
			flagName = userInput.nextLine();
			deleteRecord = toBoolean(flagName);
			if(deleteRecord) {
				deleteNumber = reference[0].getPhoneNo();
				phonebook = deleteEntry(phonebook,deleteNumber);
			}
		}
		displayAllRecords(phonebook);
		return phonebook;
	}	
	private static Person[] deleteEntry(Person[] phonebook, long deleteNumber) {
		int count = 0;
		System.out.println("DELETING CURRENT RECORD!!!");
		for (int i = 0; i < phonebook.length; i++) {
			if(phonebook[i].getPhoneNo() == deleteNumber) {
				phonebook[i] = null;
			}
		}
		// Create a temp array with 1 less record
		Person[] temp = new Person[(phonebook.length) - 1];
		// Loop through the temp array and add anything already in the phonebook array
		for(int i = 0; i < phonebook.length; i++) {
			if(phonebook[i] != null) {
				temp[count] = phonebook[i];
				count++;
			}
		}
		phonebook = temp;
		return phonebook;
	}
	
	// update methods (checkUpdate & updateEntry)
	private static Person[] checkUpdate(Person[] phonebook) {
		// Declare and define variables
		boolean updateRecord = false;
		int choice = 0;
		long updateNumber = 0L;
		Person[] reference = new Person[0];
		String flagName = "";
		String trash = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		// Get userInput for deletion
		reference = search(phonebook); //personByPhone(phonebook,searchNo);
		if(reference.length > 1) {
			System.out.println("Enter the number of the record you want to update: ");
			choice = userInput.nextInt();
			trash = userInput.nextLine();
			System.out.println("Are you sure you want to update this record? (Y/N)");
			flagName = userInput.nextLine();
			updateRecord = toBoolean(flagName);
			if(updateRecord) {
				updateNumber = reference[choice - 1].getPhoneNo();
				phonebook = updateEntry(phonebook,updateNumber,updateRecord);
			}
		} else if (reference.length == 1) {
			System.out.println("Are you sure you want to update this record? (Y/N)");
			flagName = userInput.nextLine();
			updateRecord = toBoolean(flagName);
			if(updateRecord) {
				updateNumber = reference[0].getPhoneNo();
				phonebook = updateEntry(phonebook,updateNumber,updateRecord);
			}
		}
		displayAllRecords(phonebook);
		return phonebook;
	}
	private static Person[] updateEntry(Person[] phonebook, long updateNumber, boolean updateRecord) {
		// Declare and define variables
		int choice = 0;
		int newZip = 0;
		long newPhone = 0L;
		String flagName = "";
		String newEntry = "";
		String trash = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		do {	
			System.out.println("Which section of the record do you wish to UPDATE?");
			System.out.println("1) Last Name  2) First Name  3) Street Address"
				+ "  4) City  5) State  6) Zip Code  7) Telephone Number");
			choice = userInput.nextInt();
			trash = userInput.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Please type in the new Last Name: ");
				newEntry = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].setLastName(newEntry);
					}
				}
				break;
			case 2:
				System.out.println("Please type in the new First Name: ");
				newEntry = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].setFirstName(newEntry);
					}
				}
				break;
			case 3:
				System.out.println("Please type in the new Street Address: ");
				newEntry = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].getAddress().setStreet(newEntry);
					}
				}
				break;
			case 4:
				System.out.println("Please type in the new City: ");
				newEntry = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].getAddress().setStreet(newEntry);
					}
				}
				break;
			case 5:
				System.out.println("Please type in the new State (abbreviation): ");
				newEntry = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].getAddress().setState(newEntry);
					}
				}
				break;
			case 6:
				System.out.println("Please type in the new Zip Code: ");
				newZip = userInput.nextInt();
				trash = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].getAddress().setZip(newZip);
					}
				}
				break;
			case 7:
				System.out.println("Please type in the new Phone Number: ");
				newPhone = userInput.nextLong();
				trash = userInput.nextLine();
				for (int i = 0; i < phonebook.length; i++) {
					if(phonebook[i].getPhoneNo() == updateNumber) {
						phonebook[i].setPhoneNo(newPhone);
					}
				}
				break;
			}
			System.out.println("Do you want to change another part of this "
					+ "record? (Y/N)");
			flagName = userInput.nextLine();
			updateRecord = toBoolean(flagName);
		} while (updateRecord); 
		return phonebook;
	}
	
	// searchEntry method (requires search term)	
	private static Person[] search(Person[] phonebook) {
		// Declare and define variables
		int choice = 0;
		long searchPhone = 0L;
		Person[] reference = new Person[0];
		String firstName = "";
		String lastName = "";
		String searchCity = "";
		String searchFName = "";
		String searchLName = "";
		String searchTName = "";
		String searchState = "";
		String trash = "";
		/* Open Scanner input; don't close as this causes problems with error 
		 * correction
		 */
		Scanner userInput = new Scanner(System.in);
		System.out.println("How would you like to search? \n1) Phone Number\n2) "
				+ "First Name\n3) Last Name\n4) City or State\n5) Full Name");
		choice = userInput.nextInt();
		trash = userInput.nextLine();
		switch (choice){
			case 1:
				// Search using the telephone number
				System.out.println("Please enter the telephone number to search "
						+ "for (digits only): ");
				searchPhone = userInput.nextLong();
				trash = userInput.nextLine();
				Search searchResult = new SearchPhoneNo(phonebook,searchPhone);
				reference = searchResult.searchEntry(phonebook);
				displaySearchRecord(reference);  // Display the results
				break;
			case 2:
				// Search using the first name
				System.out.println("Please enter the first name to search for: ");
				searchFName = userInput.nextLine();
				searchResult = new SearchFirstName(phonebook,searchFName);
				reference = searchResult.searchEntry(phonebook);
				displaySearchRecord(reference);  // Display the results
				break;
			case 3:
				// Search using the last name
				System.out.println("Please enter the last name to search for: ");
				searchLName = userInput.nextLine();
				searchResult = new SearchLastName(phonebook,searchLName);
				reference = searchResult.searchEntry(phonebook);
				displaySearchRecord(reference);  // Display the results
				break;
			case 4:
				// Search using the city or state
				choice = 0;  // Zero out choice to use for the next switch statement
				System.out.println("Do you want to search using city or state? "
						+ "\n1) City\n2) State");
				choice = userInput.nextInt();
				trash = userInput.nextLine();
				switch (choice) {
				case 1:
					// Search using the city's name
					System.out.println("Please enter the name of the city you are"
							+ " searching for: ");
					searchCity = userInput.nextLine();
					searchResult = new SearchCityState(phonebook,searchCity);
					reference = searchResult.searchEntry(phonebook);
					displaySearchRecord(reference);  // Display the results
					break;
				case 2:
					// Seach using the state abbreviation
					System.out.println("Please enter the name of the city you are"
							+ " searching for: ");
					searchState = userInput.nextLine();
					searchResult = new SearchCityState(phonebook,searchState);
					reference = searchResult.searchEntry(phonebook);
					displaySearchRecord(reference);  // Display the results
					break;
				}
				break;
			case 5:
				// Search using the person's full name
				System.out.println("Please enter the full name to search for: ");
				searchTName = userInput.nextLine();
				String[] nameSplit = searchTName.split(" ");
				// Split the name into first and last name
				if(nameSplit.length > 2) { // For any name more than 2 names
					for(int i = 0; i < nameSplit.length - 1; i++) {
						if(i == 0) {
							firstName = nameSplit[i];
						} else if(i > 0 && i < nameSplit.length - 2) {
							firstName = firstName + " " + nameSplit[i];
						} else {
							firstName = firstName + " " + nameSplit[i];
							lastName = lastName + nameSplit[i + 1];
						}
					}
				} else {
					// For all names greater than 2, places middle names as first names
					for(int i = 0; i < nameSplit.length - 1; i++) {
						if(i == 0) {
							firstName = nameSplit[i];
							lastName = nameSplit[i + 1];
						}
					}
				}
				searchResult = new SearchFullName(phonebook,firstName,lastName);
				reference = searchResult.searchEntry(phonebook);
				displaySearchRecord(reference);  // Display the results
				break;
		}
		return reference;
	}
	
	// showAscending method
	private static void showAscending() {
		/* Compare one entry of an array to the next
		 * If the entry is higher than the current entry, move up one rung
		 * If the entry is lower than the current entry, move down one rung
		 * If the entry is higher than the previous and lower than the next, 
		 * place it there, grab the one in the spot, and start to compare that one
		 */
		
	}
	
	// Converts String to Boolean
	private static boolean toBoolean(String flagName) {
		// Declare and define variables
		boolean returnFlag = false;  // Method always returns false without correct input
		String capY = "Y";
		String lCaseY = "y";
		// Convert input String to boolean
		if(capY.equals(flagName) || lCaseY.equals(flagName)) {
			returnFlag = true;
		}
		return returnFlag;
	}
}