import java.util.Scanner;

public class MachineProject {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		boolean programIsOn = true;
		boolean inMainMenu = true;

		while(programIsOn) {
			// New User
			Account myAccount = new Account();

			// Main Menu
			while(inMainMenu && programIsOn) {

				Visual.mainMenu();

				switch(sc.next().charAt(0)) {
					// Register
					case '1' -> myAccount.register("customer");
					// Login & Account Methods
					case '2' -> {
						if(myAccount.logIn()) {
							if(myAccount.getRole().equalsIgnoreCase("customer")) {
								CitizenMenus(myAccount);
							} else if(myAccount.getRole().equalsIgnoreCase("official")) {
								GovernmentOfficialMenus(myAccount);
							} else {
								ContactTracerMenus();	// Pass Account
							}	
						}
					}
					// Exit Program	
					case '3' -> programIsOn = false;	
				}
			}
			// Log Out Object (Not sure if needed at this point)
			myAccount.logOut();
		}

		System.out.println("> Program is terminating..");
	}



	public static void CitizenMenus(Account user) {
		boolean inCitizenMenu = true;
		Scanner sc = new Scanner(System.in);

		// Load Account onto User Object
		Citizen cz =  new Citizen();
		cz.copyAccountInfo(user);

		while(inCitizenMenu) {
			Visual.cls();
			Visual.citizenMenu();

			switch (sc.next().charAt(0)) {
				// Check In
				case '1' -> cz.checkIn();
				// Report Positive Case
				case '2' -> cz.reportPositive();
				// Change Profile Information
				case '3' -> cz.changeUserInfo();
				// Exit / LogOut
				case '4' -> {
					cz.logOut();
					inCitizenMenu = false;
				}
			}
		}
		Visual.cls();
	}



	public static void GovernmentOfficialMenus(Account user) {
		boolean inGovernmentOfficialMenu = true;
		Scanner	sc = new Scanner(System.in);

		GovernmentOfficial gv = new GovernmentOfficial();
		gv.copyAccountInfo(user);

		while(inGovernmentOfficialMenu) {
			Visual.cls();
			Visual.governmentOfficialMenu();

			switch(sc.next().charAt(0)) {
				// Check In
				case '1' -> gv.checkIn();
				// Report Positive Case
				case '2' -> gv.reportPositive();
				// Change Profile Information
				case '3' -> gv.changeUserInfo();
				// Display Unassigned Cases
				case '4' -> gv.showUnassignedCases();
				// Display Contact Tracing Updates (PHASE 2 IMPLEMENTATION)
				case '5' -> System.out.println("Contact Tracing Updates!");
				// Display Analytics
				case '6' -> gv.analytics();
				// Employ or Register Government Official Accounts
				case '7' -> gv.createGovernmentOfficial();
				// Employ or Register Contact Tracer Accounts
				case '8' -> gv.createContactTracer();
				// Terminate or Demote an Existing Account
				case '9' -> gv.terminateAccount();
				// Exit / Log Out
				case '0' -> {
					gv.logOut();
					inGovernmentOfficialMenu = false;
				}
			}
		}
		Visual.cls();
	}



	public static void ContactTracerMenus() {
		ContactTracer contactTracer = new ContactTracer();
		Scanner	sc = new Scanner(System.in);

		boolean inContactTracerMenu = true;

		while(inContactTracerMenu) {
			Visual.cls();
			Visual.contactTracerMenu();

			switch(sc.next().charAt(0)) {
				// Check In
				case '1' -> contactTracer.checkIn();
				// Report Positive Case
				case '2' -> contactTracer.reportPositive();
				// Change Profile Information
				case '3' -> contactTracer.changeUserInfo();
				// Show Cases (PHASE 2 IMPLEMENTATION)
				case '4' -> System.out.println("Show Cases!");
				// Trace Specific Case (PHASE 2 IMPLEMENTATION)
				case '5' -> System.out.println("Trace Specific Case!");
				// Inform Citizens Possibly Exposed (PHASE 2 IMPLEMENTATION)
				case '6' -> System.out.println("Inform Citizens Possibly Exposed!");
				case '7'-> {
					contactTracer.logOut();
					inContactTracerMenu = false;
				}
			}
		}
	}
}