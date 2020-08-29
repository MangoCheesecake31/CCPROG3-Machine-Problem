import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MasterList {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private int numAcc;
	private boolean isLoaded = false;
	private ArrayList<String> masters = new ArrayList<String>();
	private ArrayList<String> roles = new ArrayList<String>();


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public MasterList() {
		loadList();
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Data Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/** *	returns true if appending a new username in MasterList arrays is
sucessful *	@author Steven Castro *	@param username new user's username
*	@param role new user's role *	@return boolean */ public boolean
addMaster(String username, String role) { // Check if Username is Unique
if(!checkMaster(username)) { masters.add(username); roles.add(role); numAcc++;
saveList(); return true; }

		return false;
	}

	/**
	 *	returns true if the username exists in MasterList array
	 *	@author Steven Castro
	 *	@param username username to be searched in MasterList array
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
		returns true if updating the role of an existing username in the MasterList is sucessful
		@author Steven Castro
		@param username username of the user's role to be updated
		@param role user's new role
		@return boolean
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

	// Getters ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
		return the role of an existing user in the MasterList
		@author Steven Castro
		@param username username of the user's role to be returned
		@return String
	*/
	public String getMasterRole(String username) throws IndexOutOfBoundsException {
		// Check if Username is Unique
		if(checkMaster(username)) {
			return roles.get(searchMasterIndex(username));
		}

		return null;
	}
	
	// File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	returns true if scanning and loading the contents of MasterList.txt onto an array is sucessful
	 *	@author Steven Castro
	 *	@return boolean
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
			System.out.println("ERROR: MasterList File Not Found...");
			return false;
		}

	}

	/**
	 *	returns true if writing the contents of the arrays to MasterList.txt is sucessful
	 *	@author Steven Castro
	 *	@return boolean
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

	// Data Searching ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	returns the index of the username found in the MasterList arrays
	 *	@author Steven Castro
	 *	@param username username to be searched in the MasterList
	 *	@return int
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