import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class MachineProject {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		boolean programIsOn = true;
		boolean inMainMenu = true;

		while (programIsOn) {
			// New User
			Account myAccount = new Account();

			// Main Menu
			while (inMainMenu && programIsOn) {

				Visual.mainMenu();

				switch (sc.next().charAt(0)) {
					// Register
					case '1' -> {
						if (registryProcess("customer")) {
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
							if (myAccount.getOnline()) {
								if (myAccount.getRole().equalsIgnoreCase("customer")) {
									CitizenMenus(myAccount);
								} else if (myAccount.getRole().equalsIgnoreCase("official")) {
									GovernmentOfficialMenus(myAccount);
								} else {
									ContactTracerMenus(myAccount);    // Pass Account
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

	/**
	 * displays the menu for Citizen accounts and asks the user
	 * what he/she wants to do.
	 * @param myAccount the current user's account
	 */
	public static void CitizenMenus(Account myAccount) {
		boolean inCitizenMenu = true;
		Scanner sc = new Scanner(System.in);

		// Load Account onto User Object
		Citizen cz = new Citizen();
		cz.copyAccountInfo(myAccount);

		while (inCitizenMenu) {
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

	/**
	 * Displays the Government Official menu and asks the
	 * user what he/she wants to do.
	 * @param user the current user's account
	 */
	public static void GovernmentOfficialMenus(Account user) {
		boolean inGovernmentOfficialMenu = true;
		Scanner sc = new Scanner(System.in);

		GovernmentOfficial gv = new GovernmentOfficial();
		gv.copyAccountInfo(user);

		while (inGovernmentOfficialMenu) {
			Visual.cls();
			Visual.governmentOfficialMenu();

			switch (sc.next().charAt(0)) {
				// Check In
				case '1' -> checkIn(gv);
				// Report Positive Case
				case '2' -> reportPositive(gv);
				// Change Profile Information
				case '3' -> changeUserProfileProcess(gv);
				// Display Unassigned Cases
				case '4' -> {
					for(String[] s: gv.showUnassignedCases()) {
						System.out.println();
							for(String s2: s)
								System.out.print(s2 + " | ");
						System.out.println();
					}
				}
				// Display Contact Tracing Updates (PHASE 2 IMPLEMENTATION)
				case '5' -> System.out.println("Contact Tracing Updates!");
				// Display Analytics
				case '6' -> analyticsProcess(gv);
				// Employ or Register Government Official Accounts
				case '7' -> createGovernmentOfficialProcess(gv);
				// Employ or Register Contact Tracer Accounts
				case '8' -> createContactTracerProcess(gv);
				// Terminate or Demote an Existing Account
				case '9' -> terminateAccountProcess(gv);
				// Exit / Log Out
				case '0' -> {
					gv.logOut();
					inGovernmentOfficialMenu = false;
				}
			}
		}
		Visual.cls();
	}


	public static void ContactTracerMenus(Account user) {
		boolean inContactTracerMenu = true;
		Scanner sc = new Scanner(System.in);

		ContactTracer contactTracer = new ContactTracer();
		contactTracer.copyAccountInfo(user);

		while(inContactTracerMenu) {
			Visual.cls();
		 	Visual.contactTracerMenu();

		 	switch(sc.next().charAt(0)) {
//		 		// Check In
//		 		case '1' -> contactTracer.checkIn();
//		 		// Report Positive Case
//		 		case '2' -> contactTracer.reportPositive();
//		 		// Change Profile Information
//		 		case '3' -> contactTracer.changeUserInfo();
		 		// Show Case
		 		case '4' -> {
					for(String[] s: contactTracer.showCases(contactTracer)) {
						System.out.println();
						for(String s2: s)
							System.out.print(s2 + " | ");
						System.out.println();
					}
				}
		 		// Trace Specific Case
		 		case '5' -> contactTracer.traceSpecificCase();
//		 		// Inform Citizens Possibly Exposed
//				case '6' -> contactTracer.possiblyExposed();
		 		case '7'-> {
		 			contactTracer.logOut();
		 			inContactTracerMenu = false;
		 		}
		 	}
		 }
	}

	/**
	 * asks the user to input the date of reported positive test result
	 * then records it along with the username.
	 * @param acc the current user's account
	 */
	public static void reportPositive(Citizen acc) {
		int year, month, day;
		Scanner sc = new Scanner(System.in);

		System.out.println("Covid Positive!");
		System.out.print("Enter year: ");
		year = sc.nextInt();
		System.out.print("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if (month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while (month > 12 || month < 1);
		System.out.print("Enter day of month: ");
		do {
			day = sc.nextInt();
			if (day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);

		Calendar time = Calendar.getInstance();
		Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
				Calendar.MONTH, month,
				Calendar.DAY_OF_MONTH, day,
				Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY),
				Calendar.MINUTE, time.get(Calendar.MINUTE)).build();

		acc.reportPositive(cal);
	}

	/**
	 * asks the user to input the establishment code and date
	 * of check in then adds it to the user's record.
	 * @param acc the current user's account
	 */
	public static void checkIn(Citizen acc) {
		int year, month, day;
		Scanner sc = new Scanner(System.in);

		System.out.println("Checking In!");
		System.out.print("Please enter establishment code: ");
		String code = sc.nextLine();

		acc.checkIn(code);
	}

	// Main Menu ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 * 
	 * @param accountType the account's type
	 * @return true when registry succeeds, false otherwise.
	 */
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
		while (ac.verifyUsername(input = sc.next())) {
			Visual.cls();
			System.out.println("|INVALID: Username is already taken...");
			Visual.regUsernameMenu();
			attempt--;

			// Check Number of Attempts
			if (attempt == 0) {
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
		while (!(ac.validPassword(input = sc.next()))) {
			Visual.cls();
			System.out.println("|INVALID: Passwords should contain atleast 6 characters and 1 digit or special character...");
			Visual.regPasswordMenu();
			attempt--;

			// Check Number of Attempts
			if (attempt == 0) {
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

		Visual.cls();
		return ac.register(accountType, username, password, fullname, addresses);
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
		if (ac.verifyUsername(username = sc.next())) {

			Visual.cls();
			System.out.println("|> User is verified...");

			// Ask User for Account Password
			Visual.logPasswordMenu();
			if (ac.logIn(username, sc.next())) {
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
	 * starts a process to change User's personal information
	 *
	 * @author Steven Castro
	 * @param myAccount the user's account
	 */
	public static void changeUserProfileProcess(Citizen myAccount) {
		boolean inChangeMenu = true;
		Scanner sc = new Scanner(System.in);

		while (inChangeMenu) {
			// Prompt User What Personal Info to Change
			Visual.cls();
			Visual.changeUserMainMenu();

			// Call Change Info Proccesses (Name, Address)
			switch (Character.toUpperCase((sc.next().charAt(0)))) {
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
	 * starts a process to change User's name information
	 *
	 * @author Steven Castro
	 * @param myAccount the user's account
	 */
	public static void changeUserNameProfileProcess(Citizen myAccount) {
		char input;
		boolean inEditMenu = true;
		Scanner sc = new Scanner(System.in);

		while (inEditMenu) {
			// Prompt User What Personal Info to Change (Name)
			Visual.cls();
			Visual.changeUserNameMenu(myAccount.fullName);

			input = sc.next().charAt(0);

			// Check Valid Input
			if ('0' < input && input < '4') {
				Visual.cls();
				Visual.enterNewNameMenu();
			}

			// Apply Changes
			switch (input) {
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
	 * starts a process to change User's address information
	 *
	 * @author Steven Castro
	 * @param myAccount the user's account
	 */
	public static void changeUserAddressProfileProcess(Citizen myAccount) {
		char input;
		boolean inEditMenu = true;
		String dump;
		Scanner sc = new Scanner(System.in);

		while (inEditMenu) {
			// Prompt User What Personal Info to Change (Address)
			Visual.cls();
			Visual.changeUserAddressMenu(myAccount.addresses);

			input = sc.next().charAt(0);

			// Check Valid Input
			if ('0' < input && input < '5') {
				Visual.cls();
				Visual.enterNewAddressMenu();
			}

			// Flush
			dump = sc.nextLine();

			// Apply Changes
			switch (input) {
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

	// Analytics ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	starts a process to display analytics based on given user inputStartDateMenu
	 * @param myAccount the user's account
	 */
	public static void analyticsProcess(GovernmentOfficial myAccount) {
		Scanner sc = new Scanner(System.in);
		String dump;
		Calendar start, end;
		String cityName;

		Visual.cls();
		Visual.analyticsMenu();

		// Analytics Preferences Menu
		switch (sc.next().charAt(0)) {
			// Given a Specific City & Duration
			case '1' -> {
				// Buffer
				dump = sc.nextLine();

				// Inputs
				Visual.inputCityMenu();
				cityName = sc.nextLine();
				Visual.inputStartDateMenu();
				start = inputDate();
				Visual.inputEndDateMenu();
				end = inputDate();

				// Print Analytics
				myAccount.analytics(cityName, start, end);
			}
			// Given Only a Specific City
			case '2'-> {
				// Buffer
				dump = sc.nextLine();

				// Inputs
				Visual.inputCityMenu();
				cityName = sc.nextLine();

				// Print Analytics
				myAccount.analytics(cityName);
			}
			// Given Only a Specific Duration
			case '3' -> {
				// Inputs
				Visual.inputStartDateMenu();
				start = inputDate();
				Visual.inputEndDateMenu();
				end = inputDate();

				// Print Analytics
	 			myAccount.analytics(start, end);
			}
			default -> {
				System.out.println("|INVALID: Invalid Input...");
				Visual.pressEnterToContinue();
			}
		}
	}

		// Account Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	starts a process to employ or promote an Account to a Goverment Official
	 * @param myAccount the user's account
	 * @return true if successfully created Government Official, false otherwise
	 */
	public static boolean createGovernmentOfficialProcess(GovernmentOfficial myAccount) {
		boolean inCreateMenu = true;
		MasterList mList =  new MasterList();
		Account ac = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		while(inCreateMenu) {
			Visual.cls();
			Visual.isExistingAccountMenu();

			switch(sc.next().toUpperCase().charAt(0)) {
				// Employ Existing Account
				case 'Y' ->	{
					inCreateMenu = false;

 					Visual.cls();
					Visual.createOfficialMenu();

					// Check If Account is Verified / Existing
					if(ac.verifyUsername(input = sc.next())) {
						// Check Account Role
						if(mList.getMasterRole(input).equals("official")) {
							System.out.println("|INVALID: Account already has Government Official Role...");
							Visual.pressEnterToContinue();
							return false;
						} else {
							// Update Account Role
							myAccount.createGovernmentOfficial(input);
							return true;
						}
					}
				}
				// Register New Account
				case 'N' -> {
					inCreateMenu = false;

					// Register an Official Account
					return registryProcess("official");
				}
			}
		}

		return false;
	}

	/**
	 *	starts a process to employ or promote an Account to a Contact Tracer
	 * @param myAccount the user's account
	 * @return true if successfully created Contact Tracer, false otherwise
	 */
	public static boolean createContactTracerProcess(GovernmentOfficial myAccount) {
		boolean inCreateMenu = true;
		MasterList mList =  new MasterList();
		Account ac = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		while(inCreateMenu) {
			Visual.cls();
			Visual.isExistingAccountMenu();

			switch(sc.next().toUpperCase().charAt(0)) {
				// Employ Existing Account
				case 'Y' ->	{
					inCreateMenu = false;

 					Visual.cls();
					Visual.createTracerMenu();

					// Check If Account is Verified / Existing
					if(ac.verifyUsername(input = sc.next())) {
						// Check Account Role
						if(mList.getMasterRole(input).equals("official")) {
							System.out.println("|INVALID: Account already has Contact Tracer Role...");
							Visual.pressEnterToContinue();
							return false;
						} else {
							// Update Account Role
							myAccount.createGovernmentOfficial(input);
							return true;
						}
					}
				}
				// Register New Account
				case 'N' -> {
					inCreateMenu = false;

					// Register an Official Account
					return registryProcess("tracer");
				}
			}
		}
		return false;
	}

	/**
	 *	starts a process to demote an Account to a Customer
	 * @param myAccount the chosen account
	 * @return true if successfully terminated account, false otherwise
	 */
	public static boolean terminateAccountProcess(GovernmentOfficial myAccount) {
		Scanner sc = new Scanner(System.in);

		// Prompts & Ask for Username of Account to be Terminated
		Visual.cls();
		Visual.terminateAccountMenu();
		return myAccount.terminateAccount(sc.next());
	}

	/**
	 *	starts a process to obtain user input of a date
	 *  @author Steven Castro
	 * @return input date
	 */
	public static Calendar inputDate() {
		Calendar myDate;
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();

		try {
			// Build Calendar
			myDate = new Calendar.Builder().setFields(Calendar.MONTH, (Integer.parseInt(temp.substring(0, 2)) - 1),
					Calendar.DAY_OF_MONTH, Integer.parseInt(temp.substring(3, 5)),
					Calendar.YEAR, Integer.parseInt(temp.substring(6, 10))).build();
		} catch (NumberFormatException e) {
			System.out.println("|INVALID: Invalid Date or Format...");
			return null;
		}
		return myDate;
	}
}