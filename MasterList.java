import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MasterList {
	
	// Attributes

	private int numAcc = 0;
	private boolean isLoaded = false;
	private ArrayList<String> masters = new ArrayList<String>();
	private ArrayList<String> roles = new ArrayList<String>();

	// Methods

	public boolean loadList() {

		if(isLoaded) {
			return false;
		}

		try {
			File fp = new File("MasterList.txt");
			Scanner sc = new Scanner(fp);

			// Read MasterList.txt
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

	public boolean saveList() {

		if(!isLoaded) {
			return false;
		}
		
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

	public boolean addMaster(String username, String role) {

		if(!checkMaster(username)) {
			masters.add(username);
			roles.add(role);
			numAcc++;
			return true;

		}
		return false;
	}

	public boolean checkMaster(String username) {

		for(int i = 0; i < numAcc; i++) {
			if(username.equalsIgnoreCase(masters.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean updateMaster(String username, String role) {

		if(checkMaster(username)) {
			roles.set(searchMasterIndex(username), role);
			return true;
		}
		return false;
	}

	public String getMasterRole(String username) throws IndexOutOfBoundsException {
		
		if(checkMaster(username)) {
			return roles.get(searchMasterIndex(username));
		}
		return "user not found";
	}

	private int searchMasterIndex(String username) {

		for(int i = 0; i < numAcc; i++) {
			if(username.equalsIgnoreCase(masters.get(i))) {
				return i;
			}
		}
		return -1;
	}
}