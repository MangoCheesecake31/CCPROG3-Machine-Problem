import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Account {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Personal Information
	public Name fullName;
	public Address addresses;

	// Account Information
	private String username;
	private String password;
	private String role;
	private boolean online;


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public Account() {

	}

	public Account(String username) throws IOException {
		loadUserInfo(username);
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Registry, LogIn & Out ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/** 
	 *	starts a registry process and returns true if it is successful
	 *	if successful creates a file containing user personal information and adds user to the Master List file
	 *	@author Steven Castro
	 *	@param accountType type of account to be registered 
	 *	@return boolean
	 */
	public boolean register(String accountType) {

		// Check account type ::::::::::::::::::::
		boolean valid = false;
		String[] validTypes = {"customer", "tracer", "official"};
		
		for(String x: validTypes) 
			if(x.equalsIgnoreCase(accountType)) {
				valid = true;
				break;
			}

		if(!valid) {
			System.out.println("|INVALID: Account Type Parameter...");
			return false;
		}


		// Registry Process ::::::::::::::::::::
		int attempt = 3;
		Scanner sc = new Scanner(System.in);
		String input, input2;

		// Ask User for Desirable Username
		Visual.cls();
		Visual.regUsernameMenu();

		// Check Username if it is Unique
		while(verifyUsername(input = sc.next())) {
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

		username = input;
		attempt = 3;

		// Ask User for Desirable Password
		Visual.cls();
		Visual.regPasswordMenu();

		// Check Password if it is in Valid Format
		while(!(validPassword(input = sc.next()))) {
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
		fullName = new Name(input, input2, sc.next());
	
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
				

		// Saving User Information ::::::::::::::::::::

		// Add Registered User to MasterList.txt
		MasterList list = new MasterList();

		// Add New User to MasterList
		list.addMaster(username, accountType);

		// Save User Personal and Account Information
		System.out.println("|> Saving User...");
		if(saveUserInfo(username)) {				
			System.out.println("|> User Saved...");
		}

		return true;
	}

	/** 
	 *	starts a login process and returns returns true if it is successful
	 *	if sucessful read and load user's personal information and account details
	 *	@author Steven Castro
	 *	@return boolean
	 */
	public boolean logIn() {

		Scanner input = new Scanner(System.in);
		
		// Login Process ::::::::::::::::::::

		// Ask User for Account Username
		Visual.cls();
		Visual.logUsernameMenu();

		// Check Username if Account is Existing
		if(verifyUsername(input.next())) {
			
			Visual.cls();
			System.out.println("|> User is verified...");

			File fp = new File("./Accounts/" + username + ".act");
			
			try {
				// Scan Account Password
				Scanner sc = new Scanner(fp);
				password = sc.next();

				// Ask User for Password Input
				Visual.logPasswordMenu();
				if(verifyPassword(input.next()) == false) {
					Visual.cls();
					System.out.println("|INVALID: Wrong password...");
					return false;
				}

				input.close();

				// Load User Account and Personal Information
				loadUserInfo(username);
	
				Visual.cls();
				System.out.println("|>User: " + username + " Loaded...");
				
				sc.close();
				return true;

			} catch (IOException e) {
				System.out.println("|>User - " + username + " Loading failed...");
				System.out.println("|ERROR: file not found (accounts) :(");
				return false;
			}
		}

		// Login Process Failure Reset
		username = null;
		role = null;

		Visual.cls();
		System.out.println("> User is not verified...");
		return false;
	}

	/** 
	 *	reset Account class fields to default
	 *	@author Steven Castro
	 */
	public void logOut() {
		username = null;
		password = null;
		role = null;
		fullName = null;
		addresses = null;
		online = false;
	}

	// Getter ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/** 
	 *	returns user's username
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 *	returns user's password
     *	@author Steven Castro
	 *	@return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 *	returns user's role
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getRole() {
		return role;
	}

	/** 
	 *	returns user's online status
     *	@author Steven Castro
     *	@return boolean
	 */
	public boolean getOnline() {
		return online;
	}

	// Data Validty ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	returns true if username exists in the MasterList.txt
	 *	sets the username & role attribute of Class Account when true
	 *	@author Steven Castro
	 *	@param username current user's inputted username/
	 *	@return boolean
	 */
	public boolean verifyUsername(String username) {

		// Master List
		MasterList list = new MasterList();

		// Search Username in MasterList
		// when true update Account Class username and role
		if(list.checkMaster(username)) {
			this.username = username;
			return true;
		}

		return false;	
	}

	/**
	 *	returns true if password is equivalent to account password
	 *	sets the attribute online of Class Account to true
	 *	@author Steven Castro
	 *	@param password current user's inputted password
	 *	@return boolean
	 */
	private boolean verifyPassword(String password) {
		try {
			if(this.password.equals(password)) {
				online = true;
				return true; 
			}
		} catch (NullPointerException e) {
			return false;
		}	

		return false;
	}

	/**
	 *	returns true if password is in valid format
	 *	(Minimum of 6 characters, Includes at least 1 special character)
	 *	@author Steven Castro
	 *	@param password current user's inputted password
	 *	@return boolean
	 */
	private boolean validPassword(String password) {

		// every digit and special character
		String special = "0123456789~`!@#$%^&*()-_+={}[]|\\/:;\"'<>,.?";

		// checks password length (minimum of 6 characters)
		if(5 < password.length()) {

			// check if password contains atleast 1 special character or digit
			for(int i = 0; i < password.length(); i++) {
				for(int j = 0; j < special.length(); j++) {
					if(password.charAt(i) == special.charAt(j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	scans and loads User's personnal and account information
	 *	@author Steven Castro
	 *	@param username current user's username
	 */
	public void loadUserInfo(String username) throws IOException {

		MasterList list = new MasterList();
		
		try {
			File fp = new File("./Accounts/" + username + ".act");
			Scanner sc = new Scanner(fp);
			String dump;

			// Username
			this.username = username;

			// Scan Password
			password = sc.next();

			// Scan Role
			role = list.getMasterRole(username);

			// Scan Fullname
			fullName = new Name((sc.next()).replaceAll(",", ""), (sc.next()).replaceAll(",", ""), sc.next());

			// Flush
			dump = sc.nextLine();

			// Scan Address Information
			addresses = new Address();
			addresses.setHomeAddress((sc.nextLine()).substring(6));
			addresses.setOfficeAddress((sc.nextLine()).substring(8));
			dump = sc.next();
			addresses.setPhoneNumber((sc.next()).substring(1));
			dump = sc.nextLine();
			addresses.setEmailAddress((sc.nextLine()).substring(7));
			sc.close();

		} catch (IOException e) {
			System.out.println("|ERROR: Account File Not Found...");
		}
	}

	/**
		returns true if writing User's personal and account information to respective files is sucessful
		@author Steven Castro
		@param username current user's username
		@return boolean
	*/
	public boolean saveUserInfo(String username) {

		try {
			File file = new File("./Accounts/" + username + ".act");
			PrintStream ps = new PrintStream(file);

			// Password & Fullname
			ps.println(password);
			ps.println(fullName.getFirstName() + ", " + fullName.getMiddleName() + ", " + fullName.getLastName());

			// Address
			ps.println("HOME: " + addresses.getHomeAddress());
			ps.println("OFFICE: " + addresses.getOfficeAddress());
			ps.println("PHONE: " + addresses.getPhoneNumber());
			ps.println("EMAIL: " + addresses.getEmailAddress());

			ps.close();
			return true;

		} catch (IOException e) {
			return false;
		}	
	}

	// Could Be Useful ::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	copies Account class attributes
	 *	@author Steven Castro
	 *	@param Account class parameter
	 */
	public void copyAccountInfo(Account newUser) {

		// Account Information
		username = newUser.getUsername();
		password = newUser.getPassword();
		role = newUser.getRole();
		online = newUser.getOnline();

		// Personal Information
		fullName = newUser.fullName;
		addresses = newUser.addresses;
	}
}