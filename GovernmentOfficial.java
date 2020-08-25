import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Calendar;

public class GovernmentOfficial extends Citizen {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private MasterList mList = new MasterList();
	private CaseList cList = new CaseList();

	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Data Display ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	prints and display all unassigned cases	
     * 	@author Steven Castro
	 */
	public void showUnassignedCases() {
		Scanner sc = new Scanner(System.in);
		String dump;

		// [X] TODO: format it better
		System.out.println("| ------------------------- Unassigned Cases -------------------------- |");
		System.out.println("|                                                                       |");
		// Print Unassigned Cases
		for(int i = 0; i < cList.getNumEntries(); i++) {
			
			if(cList.getTracerName(i).equals("000")) {
				System.out.println("| " + cList.toString(i));
			}
		}
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.print("|> Press Enter to Continue...");
		dump = sc.nextLine();
	}

	// b. trace specificc aes method


	/**
	 *	display analytics of cases based on user preference of city and duration
     * 	@author Steven Castro
	 */
	public void analytics() throws IOException {
		Scanner sc = new Scanner(System.in);
		Visual.cls();
		Visual.analyticsMenu();

		switch(sc.next().charAt(0)) {
			case '1': givenCityDuration();
					break;
			case '2': givenCity();
					break;				
			case '3': givenDuration();
					break;
			default: System.out.println("|INVALID: Invalid Input...");	
		}	
	}

	// Account Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	returns true if goverment offical account creation is sucessful
	 *	undergo registry process if username does not exist in MasterList.txt 
	 *	@author Steven Castro
	 *	@return boolean
	 */
	public boolean createGovernmentOfficial() {
		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Ask User for Desirable Username
		Visual.cls();
		Visual.createOfficialMenu();
		
		// If Username does not Exist in MasterList undergo registry process
		if(newUser.verifyUsername(input = sc.next())) {
			// Check Account Role
			if(mList.getMasterRole(input).equals("official")) {
				System.out.println("|INVALID: Account already has Goverment Official Role...");
				return false;
			}

			// If Account is Existing Update Role of User in MasterList.txt
			mList.updateMaster(input, "official");

		} else if(!(newUser.register("official"))) {
			return false;
		}

		return true;
	}

	/**
	 *	returns true if contact tracer account creation is sucessful
	 *	undergo registry process if username does not exist in MasterList.txt 
	 *	@author Steven Castro
	 * 	@return boolean
	 */
	public boolean createContactTracer() {
		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Ask User for Desirable Username
		Visual.cls();
		Visual.createTracerMenu();

		// If Username does not Exist in MasterList undergo registry process
		if(newUser.verifyUsername(input = sc.next())) {
			// Check Account Role
			if(mList.getMasterRole(input).equals("tracer")) {
				System.out.println("|INVALID: Account already has Contact Tracer Role...");
				return false;
			}

			// If Account is Existing Update Role of User in MasterList.txt
			mList.updateMaster(input, "tracer");

		} else if(!(newUser.register("tracer"))) {
			return false;
		}
		return true;
	}

	/**
	 *	returns true if termination of account is sucessful
	 *	@author Steven Castro
	 *	@param username username of the user to be demoted to customer account
	 *	@return boolean
	 */
	public boolean terminateAccount(String username) {

		// Search Username in MasterList
		if(mList.checkMaster(username)) {
			// Demote User's Role to Customer
			mList.updateMaster(username, "customer");
			return true;
		}
		return false;
	}

	// Analytics ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    /** 
	 *	ask for String input of a Date in (MM,dd,yyyy) format and return a Calendar
	 *	@author Steven Castro
	 *	@return Calendar	
	 */
	public Calendar inputDate() {
		Scanner sc = new Scanner(System.in);
		Calendar myDate;
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

	/**
	 * display analytics of cases based on a given duration
	 * @author Steven Castro
	 */
	private void givenDuration() {
		int numCase = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		// Prompts and Ask for Duration
		Visual.inputStartDateMenu();
		Calendar start = inputDate();

		Visual.inputEndDateMenu();
		Calendar end = inputDate();

		// Search & Count Cases
		for(int i = 0; i < cList.getNumEntries(); i++) {
			if((cList.getReportDate(i).compareTo(start)) >= 0) {
				 if((cList.getReportDate(i).compareTo(end)) <= 0) {
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
		  System.out.print("|> Press Enter to Continue...");
		Scanner sc = new Scanner(System.in);
		String dump = sc.nextLine();
		sc.close();
	}

	/**
	 * display analytics of cases based on a given city
	 * @author Steven Castro
	 */
	private void givenCity() throws IOException {  // FUCKING IO
		int numCase = 0;
		Account ac;
		Scanner sc = new Scanner(System.in);

		// Ask Duration
		Visual.inputCityMenu();
		String cityName = sc.nextLine();

		// Search & Count
		for(int i = 0; i < cList.getNumEntries(); i++) {
			
			// Account
			if(mList.checkMaster(cList.getUsername(i))) {
				ac = new Account(cList.getUsername(i));
				
				System.out.println(ac.addresses.getHomeAddress());

				if(ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
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
		  System.out.print("|> Press Enter to Continue...");
		String dump = sc.nextLine();
	}

	/**
	 * display analytics of cases based on a given city and duration
	 * @author Steven Castro
	 */
	private void givenCityDuration() {  

	}
}






