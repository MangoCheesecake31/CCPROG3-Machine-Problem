import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	
	public void changeUserInfo() throws IOException {
		
		boolean inChangeMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inChangeMenu) {
			
			Visual.cls();
			Visual.changeUserMainMenu();

			switch(Character.toUpperCase((sc.next().charAt(0)))) {
				case '1':
					changeNameInfo();
					break;
				case '2':
					changeAddressInfo();
					break;
				case '3':
					inChangeMenu = false;
			}
		}

		sc.close();
	}


	public void checkIn() {
		System.out.println("Checking In!");
	}

	public void reportPositive() {
		System.out.println("Covid Positive!");
	}



	private void changeNameInfo() throws IOException {
		
		char input;
		boolean inEditMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {

			Visual.cls();
			Visual.changeUserNameMenu(fullName);

			input = sc.next().charAt(0);

			// Check if it is an edit menu
			if('0' < input && input < '4') {
				Visual.cls();
				Visual.enterNewNameMenu();
			}

			switch(input) {
				case '1':
					fullName.setFirstName(sc.next());
					break;
				case '2':
					fullName.setMiddleName(sc.next());
					break;
				case '3':
					fullName.setLastName(sc.next());
					break;
				case '4':
					inEditMenu = false;
			}
		}

		// Save Changes
		super.saveUserInfo(getUsername());
	}

	private void changeAddressInfo() throws IOException {
		
		char input;
		boolean inEditMenu = true;
		String dump;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {

			Visual.cls();
			Visual.changeUserAddressMenu(addresses);

			input = sc.next().charAt(0);

			// Check if it is an edit menu
			if('0' < input && input < '5') {
				Visual.cls();
				Visual.enterNewAddressMenu();
			}

			dump = sc.nextLine();

			switch(input) {
				case '1':
					addresses.setHomeAddress(sc.nextLine());
					break;
				case '2':
					addresses.setOfficeAddress(sc.nextLine());
					break;
				case '3':
					addresses.setPhoneNumber(sc.next());
					break;
				case '4':
					addresses.setEmailAddress(sc.nextLine());
					break;
				case '5':
					inEditMenu = false;
			}
		}

		// Save Changes
		super.saveUserInfo(getUsername());
	}
}