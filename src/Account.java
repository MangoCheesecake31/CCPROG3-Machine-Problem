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

	public Account(String username) {
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
	public void register(String accountType, String username, String password, Name fullName, Address addresses) {

		// Load to Account Object Fields
		this.username = username;
		this.password = password;
		this.role = accountType;
		this.fullName = fullName;
		this.addresses = addresses;

		// Saving User Information ::::::::::::::::::::

		// Add Registered User to MasterList.txt
		MasterList list = new MasterList();

		// Add New User to MasterList
		list.addMaster(username, accountType);

		// Save User Personal and Account Information
		saveUserInfo(username);
	}

	/** 
	 *	starts a login process and returns returns true if it is successful
	 *	if sucessful read and load user's personal information and account details
	 *	@author Steven Castro
	 *	@param username Account username
	 *	@param password inpuuted password
	 *	@return boolean
	 */
	public boolean logIn(String username, String password) {

		try {
			File fp = new File("./Accounts/" + username + ".act");
			Scanner sc =  new Scanner(fp);

			// Get Account Password
			this.password = sc.next();

			return verifyPassword(password);

		} catch (IOException e) {
			System.out.println("|ERROR: Account File Not Found...");
		}

		// Login Process Failure Reset
		username = null;
		role = null;

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
			if(password.equals(this.password)) {
				online = true;
				return true;
			}
		} catch (NullPointerException e) {
			System.out.println("|ERROR: Account Password Not Loaded...");
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
	 *	scans and loads User's personnal and account information
	 *	@author Steven Castro
	 *	@param username current user's username
	 */
	public void loadUserInfo(String username) {

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
	 *	@param newUser class parameter
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