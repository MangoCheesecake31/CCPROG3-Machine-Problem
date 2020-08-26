import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	starts a process to change User's personal information
	 *	@author Steven Castro
	 */
	public void changeUserInfo() {
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
					break;
				default: 
					System.out.println("|INVALID: Invalid Input...");
			}
		}
		sc.close();
	}

	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	@author Roymaxson Li
	 */
	public void checkIn() {
		int month, day, hour, minute;
		Record rec = new Record(getUsername());
		Scanner sc = new Scanner(System.in);

		System.out.println("Checking In!");
		System.out.println("Please enter establishment code: ");
		String code = sc.nextLine();
		System.out.println("Enter year: ");
		int year = sc.nextInt();
		System.out.println("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.println("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);
		System.out.println("Enter hour: ");
		do {
			hour = sc.nextInt();
			if(hour > 23 || hour < 0)
				System.out.println("Invalid input.");
		} while (hour > 23 || hour < 0);
		System.out.println("Enter minute: ");
		do {
			minute = sc.nextInt();
			if(minute > 60 || minute < 0)
				System.out.println("Invalid input.");
		} while (minute > 60 || minute < 0);

		sc.close();

		rec.addEntry(code, year, month, day, hour, minute);
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	@author Roymaxson Li
	 */
	public void reportPositive() {
		int month, day, hour, minute;
		Record rec = new Record(getUsername());
		CaseList caseList = new CaseList();
		Scanner sc = new Scanner(System.in);

		System.out.println("Covid Positive!");
		System.out.println("Enter year: ");
		int year = sc.nextInt();
		System.out.println("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.println("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);
		System.out.println("Enter hour: ");
		do {
			hour = sc.nextInt();
			if(hour > 23 || hour < 0)
				System.out.println("Invalid input.");
		} while (hour > 23 || hour < 0);
		System.out.println("Enter minute: ");
		do {
			minute = sc.nextInt();
			if(minute > 60 || minute < 0)
				System.out.println("Invalid input.");
		} while (minute > 60 || minute < 0);

		sc.close();

		Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
														Calendar.MONTH, month,
														Calendar.DAY_OF_MONTH, day,
														Calendar.HOUR, hour,
														Calendar.MINUTE, minute).build();

		caseList.addCase(getUsername(), cal);
	}

	// Change User Information  ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	starts a process to change User's name information
	 *	@author Steven Castro
	 */
	private void changeNameInfo() {
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
	 *	starts a process to change User's address information
	 *	@author Steven Castro
	 */
	private void changeAddressInfo() {
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