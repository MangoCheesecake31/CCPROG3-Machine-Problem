import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MasterList {
	// Attributes
	private int numAcc;
	private boolean isLoaded = false;
	private ArrayList<String> masters = new ArrayList<String>();
	private ArrayList<String> roles = new ArrayList<String>();


	// Constructors
	public MasterList() {
		loadList();
	}


	// Methods
	/**
		appends a new username in MasterList arrays
		@author Steven Castro
		@param username new user's username
		@param role new user's role
	*/
	public boolean addMaster(String username, String role) {
		// Check if Username is Unique
		if(!checkMaster(username)) {
			masters.add(username);
			roles.add(role);
			numAcc++;
			saveList();
			return true;
		}

		return false;
	}

	/**
		returns true if the username exists in MasterList array
		@author Steven Castro
		@param username username to be searched in MasterList array
	*/
	public boolean checkMaster(String username) {
		for(int i = 0; i < numAcc; i++) {
			if(username.equalsIgnoreCase(masters.get(i))) {
				return true;
			}
		}

		return false;
	}

	/**
		update the role of an existing username in the MasterList
		@author Steven Castro
		@param username username of the user's role to be updated
		@param role user's new role
	*/
	public boolean updateMaster(String username, String role) {
		// Check if Username is Unique
		if(checkMaster(username)) {
			roles.set(searchMasterIndex(username), role);
			saveList();
			return true;
		}

		return false;
	}

	/**
		return the role of an existing user in the MasterList
		@author Steven Castro
		@param username username of the user's role to be returned
	*/
	public String getMasterRole(String username) throws IndexOutOfBoundsException {
		// Check if Username is Unique
		if(checkMaster(username)) {
			return roles.get(searchMasterIndex(username));
		}

		return "user not found";
	}
	
	/**
		scan and loads the contents of MasterList.txt onto an array
		@author Steven Castro
	*/
	private boolean loadList() {
		// Check if the List is Already Loaded
		if(isLoaded) {
			return false;
		}

		// Load List
		try {
			File fp = new File("MasterList.txt");
			Scanner sc = new Scanner(fp);

			// Scan MasterList.txt
			while(sc.hasNext()) {
				numAcc++;
				masters.add(sc.next());
				roles.add(sc.next());
			}

			isLoaded = true;
			sc.close();
			return true;

		} catch (IOException e) {
			System.out.println("ERROR: file not found! (L) :(");
			return false;
		}

	}

	/**
		writes the contents of the arrays to MasterList.txt 
		@author Steven Castro
	*/
	private boolean saveList() {
		// Check if the List is Not Yet Loaded
		if(!isLoaded) {
			return false;
		}
		
		// Save List
		try {
			File fp = new File("MasterList.txt");
			PrintStream ps = new PrintStream(fp);

			// Write MasterList.txt
			for(int i = 0; i < numAcc; i++) {
				ps.println(masters.get(i) + " " + roles.get(i));
			}

			ps.close();
			return true;

		} catch (IOException e) {
			System.out.println("ERROR: file not found! (S) :(");
			return false;
		}

	}

	/**
		returns the index of the username found in the MasterList arrays
		@author Steven Castro
		@param username username to be searched in the MasterList
	*/
	private int searchMasterIndex(String username) {
		for(int i = 0; i < numAcc; i++) {
			if(username.equalsIgnoreCase(masters.get(i))) {
				return i;
			}
		}

		return -1;
	}
}