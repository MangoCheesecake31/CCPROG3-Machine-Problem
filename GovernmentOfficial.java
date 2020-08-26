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
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");
		// System.out.format("|    HOME  : %-59s|\n", addresses.getHomeAddress());

		System.out.println("| -------------------------------- Unassigned Cases ---------------------------------- |");
		System.out.println("|                                                                                      |");
		System.out.println("| Case Username                       Report Date Tracername                    Status |");
		// Print Unassigned Cases
		for(int i = 0; i < cList.getNumEntries(); i++) {
			
			if(cList.getTracerName(i).equals("000")) {	
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
	 *	display analytics of cases based on user preference of city and duration
     * 	@author Steven Castro
	 */
	public void analytics()  {
		Scanner sc = new Scanner(System.in);

		Visual.cls();
		Visual.analyticsMenu();

		// Analytics Preferences Menu
		switch(sc.next().charAt(0)) {
			// Given a Specific City & Duration
			case '1' -> givenCityDuration();
			// Given Only a Specific City
			case '2' -> givenCity();
			// Given Only a Specific Duration
			case '3' -> givenDuration();
			default  -> {
				System.out.println("|INVALID: Invalid Input...");
				Visual.pressEnterToContinue();
			}
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
		boolean inCreateMenu = true;
		Account ac = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		while(inCreateMenu) {
			Visual.cls();
			Visual.isExistingAccountMenu();

			switch(sc.next().toUpperCase().charAt(0)) {
				// Employ Existing Account
				case 'Y' ->	{
					inCreateMenu = false;

 					Visual.cls();
					Visual.createOfficialMenu();

					// Check If Account is Verified / Existing
					if(ac.verifyUsername(input = sc.next())) {
						// Check Account Role
						if(mList.getMasterRole(input).equals("official")) {
							System.out.println("|INVALID: Account already has Goverment Official Role...");
							Visual.pressEnterToContinue();
							return false;
						}
					}

					// Update Account Role
					mList.updateMaster(input, "official");
				}
				// Register New Account
				case 'N' -> {
					inCreateMenu = false;
					// Register an Official Account
					return ac.register("official");
				}
			}
		}
		return false;
	}

	/**
	 *	returns true if contact tracer account creation is sucessful
	 *	undergo registry process if username does not exist in MasterList.txt 
	 *	@author Steven Castro
	 * 	@return boolean
	 */
	public boolean createContactTracer() {
		boolean inCreateMenu = true;
		Account ac = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		while(inCreateMenu) {
			Visual.cls();
			Visual.isExistingAccountMenu();

			switch(sc.next().toUpperCase().charAt(0)) {
				// Employ Existing Account
				case 'Y' ->	{
					inCreateMenu = false;

 					Visual.cls();
					Visual.createTracerMenu();

					// Check If Account is Verified / Existing
					if(ac.verifyUsername(input = sc.next())) {
						// Check Account Role
						if(mList.getMasterRole(input).equals("tracer")) {
							System.out.println("|INVALID: Account already has Contact Tracer Role...");
							Visual.pressEnterToContinue();
							return false;
						}
					}

					// Update Account Role
					mList.updateMaster(input, "tracer");
				}
				// Register New Account
				case 'N' -> {
					inCreateMenu = false;
					// Register a Contact Tracer Account
					return ac.register("tracer");
				}
			}
		}
		return false;
	}

	/**
	 *	returns true if termination of account is sucessful
	 *	@author Steven Castro
	 *	@param username username of the user to be demoted to customer account
	 *	@return boolean
	 */
	public boolean terminateAccount() {
		String dump;
		Scanner sc = new Scanner(System.in);

		// Prompts & Ask for Username of Account to be Terminated
		Visual.cls();
		Visual.terminateAccountMenu();
		String username = sc.next();

		// Check If username is the current User
		if(username.equalsIgnoreCase(getUsername())) {
			System.out.println("|INVALID: Cannot Terminite Own Account...");
			Visual.pressEnterToContinue();
			return false;
		}

		// Search Username in MasterList
		if(mList.checkMaster(username)) {
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
	 *	ask for String input of a Date in (MM,dd,yyyy) format and return a Calendar
	 *	@author Steven Castro
	 *	@return Calendar	
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
		Visual.pressEnterToContinue();
	}

	/**
	 * display analytics of cases based on a given city
	 * @author Steven Castro
	 */
	private void givenCity()  {  
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

				// Load Account
				ac = new Account(cList.getUsername(i));

				// Print Address (Remove)
				System.out.println(ac.addresses.getHomeAddress());

				// Search & Count
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
		Visual.pressEnterToContinue();
	}

	/**
	 * display analytics of cases based on a given city and duration
	 * @author Steven Castro
	 */
	private void givenCityDuration() {  
		int numCase = 0;
		Account ac;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		// Prompts and Ask for Duration
		Visual.inputStartDateMenu();
		Calendar start = inputDate();

		Visual.inputEndDateMenu();
		Calendar end = inputDate();

		// Prompts and Ask for City
		// Ask Duration
		Visual.inputCityMenu();
		String cityName = sc.nextLine();

		// Search & Count
		for(int i = 0; i < cList.getNumEntries(); i++) {

			// Duration
			if((cList.getReportDate(i).compareTo(start)) >= 0) {
				if((cList.getReportDate(i).compareTo(end)) <= 0) {

					// Account
					if(mList.checkMaster(cList.getUsername(i))) {

						// Load Account
						ac = new Account(cList.getUsername(i));
						
						// Print Address (Remove)
						System.out.println(ac.addresses.getHomeAddress());

						// City
						if(ac.addresses.getHomeAddress().toUpperCase().contains(cityName.toUpperCase())) {
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
}






