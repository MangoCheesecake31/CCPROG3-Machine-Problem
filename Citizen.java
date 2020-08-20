import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	
	/**
		starts a process to change User's personal information
		@author Steven Castro
	*/
	public void changeUserInfo() throws IOException {
		boolean inChangeMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inChangeMenu) {
			// Prompt User What Personal Info to Change
			Visual.cls();
			Visual.changeUserMainMenu();

			// Call Change Info Proccesses (Name, Address)
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


	/**
		starts a process to change User's name information
		@author Steven Castro
	*/
	private void changeNameInfo() throws IOException {
		char input;
		boolean inEditMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {
			// Prompt User What Personal Info to Change (Name)
			Visual.cls();
			Visual.changeUserNameMenu(fullName);

			input = sc.next().charAt(0);

			// Check Valid Input
			if('0' < input && input < '4') {
				Visual.cls();
				Visual.enterNewNameMenu();
			}

			// Apply Changes
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

	/**
		starts a process to change User's address information
		@author Steven Castro
	*/
	private void changeAddressInfo() throws IOException {
		char input;
		boolean inEditMenu = true;
		String dump;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {
			// Prompt User What Personal Info to Change (Address)
			Visual.cls();
			Visual.changeUserAddressMenu(addresses);

			input = sc.next().charAt(0);

			// Check Valid Input
			if('0' < input && input < '5') {
				Visual.cls();
				Visual.enterNewAddressMenu();
			}

			// Flush
			dump = sc.nextLine();

			// Apply Changes
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