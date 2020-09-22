import java.util.ArrayList;
import java.util.StringTokenizer;
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
	/**
	 * 	Constructs a default Account Object 
	 *
	 * 	@author Steven Castro
	 */
	public Account() {

	}

	/**
	 * 	Constructs a Account Object loaded with account information given by the username
	 *
	 * 	@author Steven Castro
	 *  @param username username of the account to be loaded
	 */
	public Account(String username) {
		MasterList list = new MasterList();

		if (list.checkMaster(username)) {
			loadUserInfo(username);
		}
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Registry, LogIn & Out ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/** 
	 *	registers or creates an account by creating a file that contains all user information and also adding the username to the master list
	 *
	 *	@author Steven Castro
	 *	@param 	accountType type of account to be registered
	 *  @param 	username 	username of account
	 *  @param 	password 	account's password
	 *  @param 	fullName 	object Name of user
	 *  @param 	addresses 	object Address of user
	 *	@return boolean
	 */
	public boolean register(String accountType, String username, String password, Name fullName, Address addresses) {
		final String[] VALIDTYPES = {"customer", "tracer", "official"};
		boolean valid = false;

		// Load to Account Object Fields
		this.username = username;
		this.password = password;
		this.role = accountType;
		this.fullName = fullName;
		this.addresses = addresses;

		// Checking Validity of Account Information ::::::::::::::::::::
		// Account Type Checking
		for(String x: VALIDTYPES) {
			if(x.equalsIgnoreCase(accountType)) {
				valid = true;
				break;
			}
		}

		if(!valid) {		
			return false;
		}

		// Account Username Checking (If Unique)
		MasterList masters = new MasterList();
		if(masters.checkMaster(username)) {
			return false;
		}

		// Account Password Checking (If Valid)
		if(!(validPassword(password))) {
			return false;
		}


		// Saving User Information ::::::::::::::::::::::::::::::::::::::::
		// Add Registered User to MasterList.txt
		masters.addMaster(username, accountType);

		// Create & Save File for User Personal and Account Information
		saveUserInfo(username);
		return true;
	}

	/** 
	 *	returns true if the inputted account credentials parameters are correct
	 *	
	 *	@author Steven Castro
	 *	@param 	username 	Account username
	 *	@param 	password 	inputted password
	 *	@return boolean
	 */
	public static Account logIn(String username, String password) {
		MasterList masters = new MasterList();

		try {
			File fp = new File("./Accounts/" + username + ".act");
			Scanner sc =  new Scanner(fp);

			String accountPassword = sc.next();

			// Verify Password
			if (accountPassword.equals(password)) {

				// return Role Specific Account Objects
				switch (masters.getMasterRole(username)) {
					case"customer":
						Citizen cz = new Citizen();
						cz.loadUserInfo(username);
						return cz;
					case"official":
						GovernmentOfficial gv = new GovernmentOfficial();
						gv.loadUserInfo(username);
						return gv;
					case"tracer":
						ContactTracer ct = new ContactTracer();
						ct.loadUserInfo(username);
						return ct;
					default:
						System.out.println("Account Type is Not Found in Login Process");
				}
			} 

		} catch (FileNotFoundException e) {
			System.out.println("Account File Not Found!");
			System.out.println("Username is not Verified!");
		}

		return null;
	}

	/** 
	 *	resets this Object's fields to default
	 *	
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

	/**
	 * 	changes the account's password
	 *
	 * 	@author Steven Castro
	 * 	@param 	newPass 	new desired password
	 * 	@return boolean
	 */
	public boolean changePassword(String newPass) {
		if (validPassword(newPass)) {
			password = newPass;
			saveUserInfo(username);
			return true;
		} 
		return false;
	}


	// Getter ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/** 
	 *	returns username field/attribute
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 *	returns role field/attribute
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getRole() {
		return role;
	}

	/** 
	 *	returns online field/attribute
	 *	
     *	@author Steven Castro
     *	@return boolean
	 */
	public boolean getOnline() {
		return online;
	}


	// Data Validity ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	returns true if parameter password is in valid format
	 *	(Minimum of 6 characters, Includes at least 1 special character)
	 *	
	 *	@author Steven Castro
	 *	@param 	password 	current user's inputted password
	 *	@return boolean
	 */
	public boolean validPassword(String password) {

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
	 *	scans and loads user's personnal and account information onto Account Class fields
	 *	
	 *	@author Steven Castro
	 *	@param 	username 	current user's username
	 */
	public void loadUserInfo(String username) {
		MasterList masters = new MasterList();
		
		try {
			File fp = new File("./Accounts/" + username + ".act");
			Scanner sc = new Scanner(fp);
			String dump;

			// Username
			this.username = username;

			// Scan Password
			password = sc.next();

			// Get Role from Masters.txt
			role = masters.getMasterRole(username);

			// Account is Loaded & Online
			online = true;

			// Flsuh
			dump = sc.nextLine();

			// Scan Fullname
			StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
			fullName = new Name(st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim());

			// Scan Address Information
			addresses = new Address();
			addresses.setHomeAddress((sc.nextLine()).substring(6));
			addresses.setOfficeAddress((sc.nextLine()).substring(8));
			addresses.setPhoneNumber((sc.nextLine()).substring(7));
			addresses.setEmailAddress((sc.nextLine()).substring(7));
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Account File Not Found!");
		}
	}

	/**
	 *	returns true when writing user's personal and account information to respective files is successful
	 *
	 *	@author Steven Castro
	 *	@param 	username 	current user's username
	 *	@return boolean
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

		} catch (FileNotFoundException e) {
			return false;
		}	
	}
}