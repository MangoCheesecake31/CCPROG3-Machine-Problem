import java.util.Scanner;
import java.io.*;
import java.util.Calendar;

public class MachineProject {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		boolean programIsOn = true;
		boolean inMainMenu = true;

		while(programIsOn) {
			// New User
			Account myAccount = new Account();

			// Main Menu
			while(inMainMenu && programIsOn) {

				Visual.mainMenu();

				switch(sc.next().charAt(0)) {
					// Register
					case '1' -> {
						if(registryProcess("customer")) {
							System.out.println("|> Registry Sucessful...");
						} else {
							System.out.println("|> Registry Failed...");
						}
					}
					// Login & Account Methods
					case '2' -> {
						myAccount = logInProcess();

						// Account Type Methods
						try {
							if(myAccount.getOnline()) {
								if(myAccount.getRole().equalsIgnoreCase("customer")) {
									CitizenMenus(myAccount);
								} else if(myAccount.getRole().equalsIgnoreCase("official")) {
									GovernmentOfficialMenus(myAccount);
								} else {
									ContactTracerMenus();	// Pass Account
								}
							}
						} catch (NullPointerException e) {
							System.out.println("|INVALID: Login Process Failed...");
						}
					}
					// Exit Program
					case '3' -> programIsOn = false;	
				}
			}
			// Log Out Object (Not sure if needed at this point)
			myAccount.logOut();
		}

		System.out.println("> Program is terminating..");
	}



	public static void CitizenMenus(Account myAccount) {
		boolean inCitizenMenu = true;
		Scanner sc = new Scanner(System.in);

		// Load Account onto User Object
		Citizen cz = new Citizen();
		cz.copyAccountInfo(myAccount);

		while(inCitizenMenu) {
			Visual.cls();
			Visual.citizenMenu();

			switch (sc.next().charAt(0)) {
				// Check In
				case '1' -> checkIn(cz);
				// Report Positive Case
				case '2' -> reportPositive(cz);
				// Change Profile Information
				case '3' -> changeUserProfileProcess(cz);
				// Exit / LogOut
				case '4' -> inCitizenMenu = false;

			}
		}
		Visual.cls();
	}



	public static void GovernmentOfficialMenus(Account user) {
		// boolean inGovernmentOfficialMenu = true;
		// Scanner	sc = new Scanner(System.in);

		// GovernmentOfficial gv = new GovernmentOfficial();
		// gv.copyAccountInfo(user);

		// while(inGovernmentOfficialMenu) {
		// 	Visual.cls();
		// 	Visual.governmentOfficialMenu();

		// 	switch(sc.next().charAt(0)) {
		// 		// Check In
		// 		case '1' -> gv.checkIn();
		// 		// Report Positive Case
		// 		case '2' -> gv.reportPositive();
		// 		// Change Profile Information
		// 		case '3' -> gv.changeUserInfo();
		// 		// Display Unassigned Cases
		// 		case '4' -> gv.showUnassignedCases();
		// 		// Display Contact Tracing Updates (PHASE 2 IMPLEMENTATION)
		// 		case '5' -> System.out.println("Contact Tracing Updates!");
		// 		// Display Analytics
		// 		case '6' -> gv.analytics();
		// 		// Employ or Register Government Official Accounts
		// 		case '7' -> gv.createGovernmentOfficial();
		// 		// Employ or Register Contact Tracer Accounts
		// 		case '8' -> gv.createContactTracer();
		// 		// Terminate or Demote an Existing Account
		// 		case '9' -> gv.terminateAccount();
		// 		// Exit / Log Out
		// 		case '0' -> {
		// 			gv.logOut();
		// 			inGovernmentOfficialMenu = false;
		// 		}
		// 	}
		// }
		Visual.cls();
	}



	public static void ContactTracerMenus() {
		// ContactTracer contactTracer = new ContactTracer();
		// Scanner	sc = new Scanner(System.in);

		// boolean inContactTracerMenu = true;

		// while(inContactTracerMenu) {
		// 	Visual.cls();
		// 	Visual.contactTracerMenu();

		// 	switch(sc.next().charAt(0)) {
		// 		// Check In
		// 		case '1' -> contactTracer.checkIn();
		// 		// Report Positive Case
		// 		case '2' -> contactTracer.reportPositive();
		// 		// Change Profile Information
		// 		case '3' -> contactTracer.changeUserInfo();
		// 		// Show Cases (PHASE 2 IMPLEMENTATION)
		// 		case '4' -> System.out.println("Show Cases!");
		// 		// Trace Specific Case (PHASE 2 IMPLEMENTATION)
		// 		case '5' -> System.out.println("Trace Specific Case!");
		// 		// Inform Citizens Possibly Exposed (PHASE 2 IMPLEMENTATION)
		// 		case '6' -> System.out.println("Inform Citizens Possibly Exposed!");
		// 		case '7'-> {
		// 			contactTracer.logOut();
		// 			inContactTracerMenu = false;
		// 		}
		// 	}
		// }
	}
	
	public static void reportPositive(Account acc) {
		int year, month, day;
		Record rec = new Record(acc.getUsername());
		Case caseList = new caseList();
		Scanner sc = new Scanner(System.in);

		System.out.println("Covid Positive!");
		System.out.print("Enter year: ");
		year = sc.nextInt();
		System.out.print("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.print("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);

		Calendar time = Calendar.getInstance();
		Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
														Calendar.MONTH, month,
														Calendar.DAY_OF_MONTH, day,
														Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY),
														Calendar.MINUTE, time.get(Calendar.MINUTE)).build();
		caseList.addCase(acc.getUsername(), cal);
	}

	public static void checkIn(Account acc) {
		int year, month, day;
		Record rec = new Record(acc.getUsername());
		Scanner sc = new Scanner(System.in);

		System.out.println("Checking In!");
		System.out.print("Please enter establishment code: ");
		String code = sc.nextLine();
		System.out.print("Enter year: ");
		year = sc.nextInt();
		System.out.print("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.print("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);

		rec.addEntry(code, year, month, day);
	}

	// Main Menu ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	public static boolean registryProcess(String accountType) {
		Account ac = new Account();
		String username;
		String password;
		String role;
		Name fullname;
		Address addresses;


		// Registry Process ::::::::::::::::::::
		int attempt = 3;
		Scanner sc = new Scanner(System.in);
		String input, input2;


		// Ask User for Desirable Username
		Visual.cls();
		Visual.regUsernameMenu();

		// Check Username if it is Unique
		while(ac.verifyUsername(input = sc.next())) {
			Visual.cls();
			System.out.println("|INVALID: Username is already taken...");
			Visual.regUsernameMenu();
			attempt--;

			// Check Number of Attempts
			if(attempt == 0) {
				Visual.cls();
				System.out.println("|INVALID: Too Many Wrong Attempts...");
				return false;
			}
		}

		// User Inputted Username
		username = input;
		attempt = 3;

		// Ask User for Desirable Password
		Visual.cls();
		Visual.regPasswordMenu();

		// Check Password if it is in Valid Format
		while(!(ac.validPassword(input = sc.next()))) {
			Visual.cls();
			System.out.println("|INVALID: Passwords should contain atleast 6 characters and 1 digit or special character...");
			Visual.regPasswordMenu();
			attempt--;

			// Check Number of Attempts
			if(attempt == 0) {
				Visual.cls();
				System.out.println("|INVALID: Too Many Wrong Attempts...");
				return false;
			}
		}

		// User Inputted Password and Role
		password = input;
		role = accountType;


		// Ask User to Fill Personal Information ::::::::::::::::
		Visual.cls();

		// Ask User Fullname
		Visual.firstNameMenu();
		input = sc.next();
		Visual.middleNameMenu();
		input2 = sc.next();
		Visual.lastNameMenu();
		fullname = new Name(input, input2, sc.next());

		// Flush
		input = sc.nextLine();

		// // Ask User Address Information
		addresses = new Address();

		Visual.homeAddMenu();
		addresses.setHomeAddress(sc.nextLine());
		Visual.officeAddMenu();
		addresses.setOfficeAddress(sc.nextLine());
		Visual.phoneNumMenu();
		addresses.setPhoneNumber(sc.next());

		// Flush
		input = sc.nextLine();

		Visual.emailAddMenu();
		addresses.setEmailAddress(sc.nextLine());

		ac.register(accountType, username, password, fullname, addresses);
		return true;
	}

	public static Account logInProcess() {
		Account ac = new Account();
		Scanner sc = new Scanner(System.in);
		String username;

		// Login Process ::::::::::::::::::::

		// Ask User for Account Username
		Visual.cls();
		Visual.logUsernameMenu();

		// Check Username if Account is Existing
		if(ac.verifyUsername(username = sc.next())) {

			Visual.cls();
			System.out.println("|> User is verified...");

			// Ask User for Account Password
			Visual.logPasswordMenu();
			if(ac.logIn(username, sc.next())) {
				// Load Account Details onto ac Object
				ac.loadUserInfo(username);
				return ac;

			} else {
				Visual.cls();
				System.out.println("|INVALID: Wrong password...");
			}
		} else {
			Visual.cls();
			System.out.println("|> User is not verified...");
		}

		return null;
	}

	// Citizen Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Change User Profile Information  ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	starts a process to change User's personal information
	 *	@author Steven Castro
	 */
	public static void changeUserProfileProcess(Citizen myAccount) {
		boolean inChangeMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inChangeMenu) {
			// Prompt User What Personal Info to Change
			Visual.cls();
			Visual.changeUserMainMenu();

			// Call Change Info Proccesses (Name, Address)
			switch(Character.toUpperCase((sc.next().charAt(0)))) {
				// Change Name Information
				case '1' -> changeUserNameProfileProcess(myAccount);
				// Change Address information
				case '2' -> changeUserAddressProfileProcess(myAccount);
				// Save Changes & Exit
				case '3' -> inChangeMenu = false;
				default -> System.out.println("|INVALID: Invalid Input...");
			}
		}
	}

	/**
	 *	starts a process to change User's name information
	 *	@author Steven Castro
	 */
	public static void changeUserNameProfileProcess(Citizen myAccount) {
		char input;
		boolean inEditMenu = true;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {
			// Prompt User What Personal Info to Change (Name)
			Visual.cls();
			Visual.changeUserNameMenu(myAccount.fullName);

			input = sc.next().charAt(0);

			// Check Valid Input
			if('0' < input && input < '4') {
				Visual.cls();
				Visual.enterNewNameMenu();
			}

			// Apply Changes
			switch(input) {
				// Change First Name
				case '1' -> myAccount.fullName.setFirstName(sc.next());
				// Change Middle Name
				case '2' -> myAccount.fullName.setMiddleName(sc.next());
				// Change Last Name
				case '3' -> myAccount.fullName.setLastName(sc.next());
				// Save Changes & Exit
				case '4' -> inEditMenu = false;
			}
		}

		// Save Changes
		myAccount.saveUserInfo(myAccount.getUsername());
	}

	/**
	 *	starts a process to change User's address information
	 *	@author Steven Castro
	 */
	public static void changeUserAddressProfileProcess(Citizen myAccount) {
		char input;
		boolean inEditMenu = true;
		String dump;
		Scanner sc = new Scanner(System.in);

		while(inEditMenu) {
			// Prompt User What Personal Info to Change (Address)
			Visual.cls();
			Visual.changeUserAddressMenu(myAccount.addresses);

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
				// Change Home Address
				case '1' -> myAccount.addresses.setHomeAddress(sc.nextLine());
				// Change Home Address
				case '2' -> myAccount.addresses.setOfficeAddress(sc.nextLine());
				// Change Home Address
				case '3' -> myAccount.addresses.setPhoneNumber(sc.next());
				// Change Home Address
				case '4' -> myAccount.addresses.setEmailAddress(sc.nextLine());
				// Save Changes & Exit
				case '5' -> inEditMenu = false;
			}
		}

		// Save Changes
		myAccount.saveUserInfo(myAccount.getUsername());
	}

	// Check In & Report Cases  ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::




	
	// Goverment Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Account Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



}