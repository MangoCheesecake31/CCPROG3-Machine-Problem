import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class GovernmentOfficial extends Citizen {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private MasterList mList = new MasterList();
	private CaseList cList = new CaseList();

	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Data Display ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 * prints and display all unassigned cases in Cases.txt
	 * 
	 * @author Steven Castro
	 */
	public void showUnassignedCases() {
		cList.refresh();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		System.out.println("| -------------------------------- Unassigned Cases ---------------------------------- |");
		System.out.println("|                                                                                      |");
		System.out.println("| Case Username                       Report Date Tracername                    Status |");
		// Print Unassigned Cases
		for (int i = 0; i < cList.getNumCases(); i++) {

			if (cList.getTracerName(i).equals("000")) {
				System.out.format("| %-4d %-30s %-10s  %-30s %c     |\n", i + 1, cList.getUsername(i),
																				 sdf.format(cList.getReportDate(i).getTime()),
																				 cList.getTracerName(i),
																				 cList.getStatus(i));
			}
		}
		System.out.println("| -------------------------------------------------------------------------------------|");
		Visual.pressEnterToContinue();
	}

	// B. Show Contact Tracing Updates
	// public void showContactTracingUpdates()

	/**
	 * display analytics of reported cases based on user preference of city
	 *
	 * @author Steven Castro
	 * @param cityName name of the chosen city
	 */
	public void analytics(String cityName) {
		int numCase = 0;
		cList.refresh();
		Account ac;

		// Search & Count
		for (int i = 0; i < cList.getNumCases(); i++) {

			// Account
			if (mList.checkMaster(cList.getUsername(i))) {

				// Load Account
				ac = new Account(cList.getUsername(i));

				// Print Address (Remove)
				System.out.println(ac.addresses.getHomeAddress());

				// Search & Count
				if (ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
					System.out.println(cList.toString(i));
					numCase++;
				}

			}
		}

		// Output
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("| City: " + cityName);
		System.out.println("| Number of Cases: " + numCase);
		System.out.println("| --------------------------------------------------------------------- |");
		Visual.pressEnterToContinue();
	}

	/**
	 * display analytics of reported cases based on user preference of duration
	 *
	 * @author Steven Castro
	 * @param start the starting date
	 * @param end the ending date
	 */
	public void analytics(Calendar start, Calendar end) {
		int numCase = 0;
		cList.refresh();
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");


		// Search & Count Cases
		for (int i = 0; i < cList.getNumCases(); i++) {
			if ((cList.getReportDate(i).compareTo(start)) >= 0) {
				if ((cList.getReportDate(i).compareTo(end)) <= 0) {
					System.out.println(cList.toString(i));
					numCase++;
				}
			}
		}

		// Output
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("| Duration: " + sdf.format(start.getTime()) + " ---> " + sdf.format(end.getTime()));
		System.out.println("| Number of Cases: " + numCase);
		System.out.println("| --------------------------------------------------------------------- |");
		Visual.pressEnterToContinue();
	}

	/**
	 * display analytics of reported cases based on user preference of city and duration
	 *
	 * @author Steven Castro
	 * @param cityName name of the chosen city
	 * @param start the starting date
	 * @param end the ending date
	 */
	public void analytics(String cityName, Calendar start, Calendar end) {
		int numCase = 0;
		cList.refresh();
		Account ac;
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		// Search & Count
		for (int i = 0; i < cList.getNumCases(); i++) {

			// Duration
			if ((cList.getReportDate(i).compareTo(start)) >= 0) {
				if ((cList.getReportDate(i).compareTo(end)) <= 0) {

					// Account
					if (mList.checkMaster(cList.getUsername(i))) {

						// Load Account
						ac = new Account(cList.getUsername(i));

						// Print Address (Remove)
						System.out.println(ac.addresses.getHomeAddress());

						// City
						if (ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
							System.out.println(cList.toString(i));
							numCase++;
						}
					}
				}
			}
		}

		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("| Duration: " + sdf.format(start.getTime()) + " ---> " + sdf.format(end.getTime()));
		System.out.println("| City: " + cityName);
		System.out.println("| Number of Cases: " + numCase);
		System.out.println("| --------------------------------------------------------------------- |");
		Visual.pressEnterToContinue();
	}

	// Account Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 * returns true if government official account creation is successful
	 * 
	 * @return boolean
	 * @author Steven Castro
	 * @param username the username to be turned into a government official
	 */
	public boolean createGovernmentOfficial(String username) {

		if (mList.checkMaster(username)) {
			mList.updateMaster(username, "official");
			return true;
		}

		return false;
	}

	/**
	 * returns true if contact tracer account creation is successful
	 *
	 * @return boolean
	 * @author Steven Castro
	 * @param username the username to be turned into a Contact Tracer
	 */
	public boolean createContactTracer(String username) {

		if (mList.checkMaster(username)) {
			mList.updateMaster(username, "tracer");
			return true;
		}

		return false;
	}

	/**
	 * returns true if termination of account is successful
	 *
	 * @param username username of the user to be demoted to customer account
	 * @return boolean
	 * @author Steven Castro
	 */
	public boolean terminateAccount(String username) {

		// Check If username is the current User
		if (username.equalsIgnoreCase(getUsername())) {
			System.out.println("|INVALID: Cannot Terminate Own Account...");
			Visual.pressEnterToContinue();
			return false;
		}

		// Search Username in MasterList
		if (mList.checkMaster(username)) {
			// Demote User's Role to Customer
			mList.updateMaster(username, "customer");
			System.out.println("|> Termination of Account is Successful...");
			Visual.pressEnterToContinue();
			return true;
		}

		System.out.println("|INVALID: Account Does Not Exist...");
		Visual.pressEnterToContinue();
		return false;
	}

	// Analytics ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 * ask for String input of a Date in (MM,dd,yyyy) format and return a Calendar
	 *
	 * @return Calendar
	 * @author Steven Castro
	 */
	public Calendar inputDate() {
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






