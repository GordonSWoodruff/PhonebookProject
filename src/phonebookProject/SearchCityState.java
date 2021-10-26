package phonebookProject;

public class SearchCityState extends Search {
	private String searchCity = "";
	private String searchState = "";
	public SearchCityState (Person[] phonebook,String location) {
		// TODO Auto-generated constructor stub
		if(location.length() > 2) {
			searchCity = location.toLowerCase();
			System.out.println(searchCity);
		} else {
			searchState = location.toLowerCase();
		}
	}

	@Override
	public Person[] searchEntry(Person[] phonebook) {
		if (searchCity != "") {
			reference = searchCity(phonebook,searchCity);
		} else if (searchState != "") {
			reference = searchState(phonebook,searchState);
		} else {
			System.out.println("That's not a valid entry! Please try again");
			reference = new Person[0];
		}
		return reference;
	}

	private Person[] searchCity(Person[] phonebook, String searchCity) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		int place = 0;
		String inputCity = "";
		for (int i = 0; i < phonebook.length; i++) {
			inputCity = phonebook[i].getAddress().getCity().toLowerCase();
			System.out.println(inputCity);
			if(inputCity.equals(searchCity)) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			inputCity = phonebook[i].getAddress().getCity().toLowerCase();
			if(inputCity.equals(searchCity)) {
				reference[place] = phonebook[i]; // sets reference to the index
		 		place++;
		 	}
		 }
		return reference; // phonebook[reference];
	}

	private Person[] searchState(Person[] phonebook, String searchState) {
		// make a for loop to measure out the size of the phonebook array
		int count = 0;
		int place = 0;
		String inputState = "";
		for (int i = 0; i < phonebook.length; i++) {
			inputState = phonebook[i].getAddress().getState().toLowerCase();
			if(inputState.equals(searchState)) {
				count++;
			}
		}
		Person[] temp = new Person[count];
		reference = temp;
		for (int i = 0; i < phonebook.length; i++) {  // searches through the person object
			inputState = phonebook[i].getAddress().getState().toLowerCase();
			if(inputState.equals(searchState)) {
				reference[place] = phonebook[i]; // sets reference to the index
		 		place++;
		 	}
		 }
		return reference; // phonebook[reference];
	}
}
