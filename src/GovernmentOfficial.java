import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class GovernmentOfficial extends Citizen {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Data Display ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	returns a two dimensional array of strings containing data of unassigned cases
	 * 
	 * 	@author Steven Castro
	 */
	public String[][] showUnassignedCases() {
		CaseList cases = new CaseList();
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		int count = 0;
		String[][] temp = new String[cases.getNumCases()][5];

		// Size of Number of Cases
		for (int i = 0; i < cases.getNumCases(); i++) {
			if (cases.getTracerName(i).equals("000")) {
				temp[count][0] = String.valueOf(i + 1);
				temp[count][1] = cases.getUsername(i);
				temp[count][2] = sdf.format(cases.getReportDate(i).getTime());
				temp[count][3] = cases.getTracerName(i);
				temp[count][4] = String.valueOf(cases.getStatus(i));

				count++;
			}
		}

		// Size of Number of Unassigned Cases
		String[][] data = new String[count][5];
		for (int i = 0; i < count; i ++) {
			data[i][0] = temp[i][0];
			data[i][1] = temp[i][1];
			data[i][2] = temp[i][2];
			data[i][3] = temp[i][3];
			data[i][4] = temp[i][4];
		}
		return data;		
	}

	// B. Show Contact Tracing Updates
	// public void showContactTracingUpdates()

	/**
	 * 	returns the number of cases in a given city
	 *
	 * 	@author Steven Castro
	 *  @param cityName name of the chosen city
	 */
	public int analytics(String cityName) {
		int numCases = 0;
		MasterList masters = new MasterList();
		CaseList cases = new CaseList();
		Account ac;

		// Search & Count
		for (int i = 0; i < cases.getNumCases(); i++) {

			// Account
			if (masters.checkMaster(cases.getUsername(i))) {

				// Load Account
				ac = new Account(cases.getUsername(i));

				// Compare Address with City
				if (ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
					numCases++;

				}
			}
		}
		return numCases;
	}

	/**
	 * 	returns the number of cases in a given duration
	 *
	 * 	@author Steven Castro
	 *  @param 	start	the starting date
	 *  @param 	end 	the ending date
	 */
	public int analytics(Calendar start, Calendar end) {
		int numCases = 0;
		MasterList masters = new MasterList();
		CaseList cases = new CaseList();
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		// Search & Count Cases
		for (int i = 0; i < cases.getNumCases(); i++) {
			// Duration
			if ((cases.getReportDate(i).compareTo(start)) >= 0) {
				if ((cases.getReportDate(i).compareTo(end)) <= 0) {
					numCases++;

				}
			}
		}
		return numCases;
	}

	/**
	 * 	returns the number of cases in a given duration
	 *
	 *  @author Steven Castro
	 *  @param 	cityName 	name of the chosen city
	 *  @param 	start 	 	the starting date
	 *  @param 	end 		the ending date
	 */
	public int analytics(String cityName, Calendar start, Calendar end) {
		int numCases = 0;
		MasterList masters = new MasterList();
		CaseList cases = new CaseList();
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");
		Account ac;

		// Search & Count
		for (int i = 0; i < cases.getNumCases(); i++) {
			// Duration
			if ((cases.getReportDate(i).compareTo(start)) >= 0) {
				if ((cases.getReportDate(i).compareTo(end)) <= 0) {

					// Account
					if (masters.checkMaster(cases.getUsername(i))) {

						// Load Account
						ac = new Account(cases.getUsername(i));

						// Compare Address with City
						if (ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
							numCases++;

						}
					}
				}
			}
		}
		return numCases;
	}


	// Account Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *  returns true if government official account creation is successful
	 * 
	 *  @author Steven Castro
	 *  @param 	username 	the username to be turned into a government official
	 *  @return boolean
	 */
	public boolean createGovernmentOfficial(String username) {
		MasterList masters = new MasterList();

		if (masters.checkMaster(username)) {
			if (!(masters.getMasterRole(username).equals("official"))) {
				masters.updateMaster(username, "official");
				return true;
			} 
			//System.out.println("User Already has This Role!");

		}
		return false;
	}

	/**
	 * 	returns true if contact tracer account creation is successful
	 *
	 *  @author Steven Castro
	 *  @param 	username 	the username of the account
	 * 	@return boolean
	 */
	public boolean createContactTracer(String username) {
		MasterList masters = new MasterList();

		if (masters.checkMaster(username)) {
			if (!(masters.getMasterRole(username).equals("tracer"))) {
				masters.updateMaster(username, "tracer");
				return true;
			}
			//System.out.println("User Already has This Role!");
		}
		return false;
	}

	/**
	 *  returns true if termination of account is successful
	 *
	 *  @author Steven Castro
	 *  @param 	username 	username of the user to be demoted to customer account
	 *  @return boolean
	 */
	public boolean terminateAccount(String username) {
		MasterList masters = new MasterList();

		// Check If username is the current User
		if (username.equalsIgnoreCase(getUsername())) {
			// System.out.println("|INVALID: Cannot Terminate Own Account...");	
			return false;
		}

		// Search Username in MasterList
		if (masters.checkMaster(username)) {
			// Demote User's Role to Customer
			masters.updateMaster(username, "customer");
			// System.out.println("|> Termination of Account is Successful...");
			return true;
		}

		//System.out.println("|INVALID: Account Does Not Exist...");
		return false;
	}
}