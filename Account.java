import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Account {

	// ::::::::::::::::::::
	// 		Attributes
	// ::::::::::::::::::::

	// Personal Information
	public Name fullName;
	public Address addresses;

	// Account Information
	private String username;
	private String password;
	private String role;
	private boolean online;

	// ::::::::::::::::::::
	// 		Methods
	// ::::::::::::::::::::
	
	/** 
		starts a registry process and returns true if it is successful
		if successful creates a file containing user personal information and adds user to the Master List file
		@author Steven Castro
	*/
	public boolean register(String accountType) {

		int attempt = 3;
		Scanner sc = new Scanner(System.in);
		String input, input2;

		// Obtain username input
		Visual.cls();
		Visual.usernameMenu();

		while(verifyUsername(input = sc.next())) {
			Visual.cls();
			System.out.println("|INVALID: Username is already taken...");
			Visual.usernameMenu();
		 attempt--;

			if(attempt == 0) {
				Visual.cls();
				System.out.println("|INVALID: Too Many Wrong Attempts...");
				return false;
			}
		}

		username = input;
		attempt = 3;

		// Obtain password input
		Visual.cls();
		Visual.passwordMenu();

		while(!(validPassword(input = sc.next()))) {
			Visual.cls();
			System.out.println("|INVALID: Passwords should contain atleast 6 characters and 1 digit or special character...");
			Visual.passwordMenu();
			attempt--;

			if(attempt == 0) {
				Visual.cls();
				System.out.println("|INVALID: Too Many Wrong Attempts...");
				return false;
			}
		}

		// Obtain user's personal information
		password = input;
		role = accountType;

		// Obtain user inputs for Full Name
		Visual.cls();

		// First Name
		Visual.firstNameMenu();
		input = sc.next();

		// Middle Name
		Visual.middleNameMenu();
		input2 = sc.next();

		// Last Name
		Visual.lastNameMenu();
		fullName = new Name(input, input2, sc.next());

				
		// Flush
		input = sc.nextLine();
				
		// Obtain user inputs for Address Informations
		addresses = new Address();
		// Home Address
		Visual.homeAddMenu();
		addresses.setHomeAddress(sc.nextLine());

		// Office Address
		Visual.officeAddMenu();
		addresses.setOfficeAddress(sc.nextLine());
				
		// Phone Address
		Visual.phoneNumMenu();
		addresses.setPhoneNumber(sc.next());

		// Flush
		input = sc.nextLine();

		// Email Address
		Visual.emailAddMenu();
		addresses.setEmailAddress(sc.nextLine());
				

		// Summary
		// System.out.println("| --------------------------------------------------------------------- |");
		// System.out.println("|Full Name: " + fullName);
		// System.out.println("|     HOME: " + addresses.getHomeAddress());
		// System.out.println("|   OFFICE: " + addresses.getOfficeAddress());
		// System.out.println("|    PHONE: " + addresses.getPhoneNumber());
		// System.out.println("|    EMAIL: " + addresses.getEmailAddress());
		// System.out.println("| --------------------------------------------------------------------- |");


		// Adds new user to MasterList.txt
		MasterList list = new MasterList();

		list.loadList();
		list.addMaster(username, accountType);
		list.saveList();
			
		// Save User Personal and Account Information
		System.out.println("|> Saving User...");
		if(saveUserInfo(username)) {				
			System.out.println("|> User Saved...");
		}

		return true;
	}

	/** 
		starts a login process and returns returns true if it is successful
		if sucessful read and load user's personal information and account details
		@author Steven Castro
	*/
	public boolean logIn() {

		Scanner input = new Scanner(System.in);
		
		// Obtain username input
		Visual.cls();
		Visual.usernameMenu();

		if(verifyUsername(input.next())) {
			
			Visual.cls();
			System.out.println("|> User is verified...");

			File fp = new File("./Accounts/" + username + ".act");
			
			try {
				Scanner sc = new Scanner(fp);

				// Read user's correct password to Account class attribute password
				password = sc.next();

				// Obtain password input
				Visual.passwordMenu();
				if(verifyPassword(input.next()) == false) {
					Visual.cls();
					System.out.println("|INVALID: Wrong password...");
					return false;
				}

				input.close();

				// Read and Load User's information
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

		username = null;
		role = null;

		Visual.cls();
		System.out.println("> User is not verified...");
		return false;
	}

	/** 
		set all Class Account attributes to null and online attribute to false
		@author Steven Castro
	*/
	public void logOut() {
		username = null;
		password = null;
		role = null;
		fullName = null;
		addresses = null;
		online = false;
	}

	// ::::::::::::::::::::::::::::::
	// 		GETTERS
	// ::::::::::::::::::::::::::::::

	/** 
		returns user's role
		@author Steven Castro
	*/
	public String getRole() {
		return role;
	}

	/** 
		returns user's username
		@author Steven Castro
	*/
	public String getUsername() {
		return username;
	}

	/** 
		returns user's online status
		@author Steven Castro
	*/
	public boolean getOnline() {
		return online;
	}

	// ::::::::::::::::::::::::::::::
	// 		DATA VALIDITY
	// ::::::::::::::::::::::::::::::

	/**
		returns true if username exists in the MasterList.txt
		sets the username & role attribute of Class Account when true
		@author Steven Castro
		@param username current user's inputted username
	*/
	public boolean verifyUsername(String username) {

		MasterList list = new MasterList();

		list.loadList();

		if(list.checkMaster(username)) {
			this.username = username;
			role = list.getMasterRole(username);
			return true;
		}
		return false;	
	}

	/**
		returns true if password is equivalent to account password
		sets the attribute online of Class Account to true
		@author Steven Castro
		@param password current user's inputted password
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
		returns true if password is in valid format
		(Minimum of 6 characters, Includes at least 1 special character)
		@author Steven Castro
		@param password current user's inputted password
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

	// ::::::::::::::::::::::::::::::
	// 		FILE HANDLING
	// ::::::::::::::::::::::::::::::

	/**
		read and loads user's personal and account information
		@author Steven Castro
		@param username current user's username
	*/
	public void loadUserInfo(String username) throws IOException {

		File fp = new File("./Accounts/" + username + ".act");
		Scanner sc = new Scanner(fp);

		// Scan Password (ignored)
		String dump = sc.next();

		// Scan User's Full Name
		fullName = new Name((sc.next()).replaceAll(",", ""), (sc.next()).replaceAll(",", ""), sc.next());

		// Flush
		dump = sc.nextLine();

		// Scan User's Addresses Information
		addresses = new Address();
		addresses.setHomeAddress((sc.nextLine()).substring(6));
		addresses.setOfficeAddress((sc.nextLine()).substring(8));
		dump = sc.next();
		addresses.setPhoneNumber((sc.next()).substring(1));
		dump = sc.nextLine();
		addresses.setEmailAddress((sc.nextLine()).substring(7));

		sc.close();
	}

	/**
		saves user's personal and account information
		@author Steven Castro
		@param username current user's username
	*/
	public boolean saveUserInfo(String username) {

		try {
			File file = new File("./Accounts/" + username + ".act");
			PrintStream ps = new PrintStream(file);

			ps.println(password);
			ps.println(fullName.getFirstName() + ", " + fullName.getMiddleName() + ", " + fullName.getLastName());

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
}