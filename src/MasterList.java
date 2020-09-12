import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*
 *	This object is dedicated to handling a text file that contains a list of all verified user accounts
 *  and roles.
 *	Version - 08-31-2020 10:32PM -
 */

public class MasterList {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private final File FILE;
	private int numAcc;
	private ArrayList<String> masters = new ArrayList<String>();
	private ArrayList<String> roles = new ArrayList<String>();


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	construct a MasterList object with default file path for the Master List (Masters.txt)
	 * 	
	 * 	@author Steven Castro
	 */
	public MasterList() {
		this("Masters.txt");
	}

	/**
	 * 	construct a MasterList object with desired file path parameter for the Master List
	 * 	
	 * 	@author Steven Castro
	 */
	public MasterList(String filename) {
		FILE = new File(filename);
		load();
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Data Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/** 
	 *	returns true if appending a new user on the MasterList arrays is sucessful
	 *	 
	 *	@author Steven Castro 
	 *	@param username new user's username
	 *	@param role new user's role 
	 *	@return boolean 
	 */ 
	public boolean addMaster(String username, String role) { // Check if Username is Unique
		if(!checkMaster(username)) { 
			masters.add(username); roles.add(role); numAcc++;
			save(); return true; 
		}

		return false;
	}

	/**
	 *	returns true if the username exists in MasterList arrays
	 *	
	 *	@author Steven Castro
	 *	@param username username to be searched in the Master List
	 *	@return boolean
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
	 *	returns true if updating the role of an existing username in the Master List is sucessful
	 *	
	 *	@author Steven Castro
	 *	@param username username of the user
	 *	@param role user's new role
	 *	@return boolean
	 */
	public boolean updateMaster(String username, String role) {
		// Check if Username is Unique
		if(checkMaster(username)) {
			roles.set(searchMasterIndex(username), role);
			save();
			return true;
		}
		return false;
	}


	// Getters ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	returns the username of an existing user in the Master List
	 *	
	 *	@author Steven Castro
	 *	@param 	index index of username
	 *	@return String
	 */
	public String getMasterUsername(int index) {
		try {
			return masters.get(index);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Get Username index out of bounds");
			return null;
		}	
	}

	/**
	 *	returns the role of an existing user in the Master List
	 *	
	 *	@author Steven Castro
	 *	@param username username of the user
	 *	@return String
	 */
	public String getMasterRole(String username) throws IndexOutOfBoundsException {
		// Check if Username is Unique
		if(checkMaster(username)) {
			return roles.get(searchMasterIndex(username));
		}

		System.out.println("ERROR: Master Not Found...");
		return null;
	}

	/**
	 * 	return the number of masters or usernames in Master List text file
	 *
	 * 	@author Steven Castro
	 *  @return int
	 */
	public int getNumAcc() {
		return numAcc;
	}

	// File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	Reloads the contents of this Object's Arrays by scanning the text file again
	 *	@author Steven Castro
	 */
	public void refresh() {
		numAcc = 0;
		masters = new ArrayList<String>();
		roles = new ArrayList<String>();

		load();
	}

	/**
	 *	Opens the text file then scan and loads the contents onto this Object's Arrays 
	 *	
	 *	@author Steven Castro
	 */
	private void load() {

		try {
			Scanner sc = new Scanner(FILE);

			// Scans The Text File
			while(sc.hasNext()) {
				numAcc++;
				masters.add(sc.next());
				roles.add(sc.next());
			}

			sc.close();

		} catch (IOException e) {
			System.out.println("ERROR: Master List Text File Not Found (L)...");
		}
	}

	/**
	 *	Opens the text file writes the contents of this Object's Arrays onto it
	 *	
	 *	@author Steven Castro
	 */
	private void save() {

		try {
			PrintStream ps = new PrintStream(FILE);

			// Writes The Text File
			for(int i = 0; i < numAcc; i++) {
				ps.println(masters.get(i) + " " + roles.get(i));
			}

			ps.close();

		} catch (IOException e) {
			System.out.println("ERROR: Master List Text File Not Found (S)...");
		}
	}


	// Data Searching ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	returns the index of the username found in this Object's field masters
	 *	
	 *	@author Steven Castro
	 *	@param username username to be searched in the Master List
	 *	@return int
	 */
	private int searchMasterIndex(String username) {
		for(int i = 0; i < numAcc; i++) {
			if(username.equalsIgnoreCase(masters.get(i))) {
				return i;
			}
		}

		System.out.println("ERROR: Master Not Found...");
		return -1;
	}
}