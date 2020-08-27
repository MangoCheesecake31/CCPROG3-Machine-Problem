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
								GovermentOfficialMenus(myAccount);
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
				case '4' -> inCitizenMenu = false;
			}
		}
		Visual.cls();
	}



	public static void GovermentOfficialMenus(Account user) {
		boolean inGovernmentOfficialMenu = true;
		Scanner	sc = new Scanner(System.in);

		GovernmentOfficial gv = new GovernmentOfficial();
		gv.copyAccountInfo(user);

		while(inGovernmentOfficialMenu) {
			Visual.cls();
			Visual.governmentOfficialMenu();

			switch(sc.next().charAt(0)) {
				// Display Unassigned Cases
				case '1' -> gv.showUnassignedCases();
				// Display Contact Tracing Updates (PHASE 2 IMPLEMENTATION)
				case '2' -> System.out.println("Contact Tracing Updates!");
				// Display Analytics
				case '3' -> gv.analytics();
				// Employ or Register Government Offical Accounts		
				case '4' -> gv.createGovernmentOfficial();
				// Employ or Register Contact Tracer Accounts
				case '5' -> gv.createContactTracer();
				// Terminate or Demote an Existing Account
				case '6' -> gv.terminateAccount();
				// Exit / Log Out
				case '7' -> inGovernmentOfficialMenu = false;	
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
				case '1':
					// Show Cases !PHASE 2
					break;
				case '2':
					// Trace Specific Case !PHASE 2
					break;
				case '3':
					// Inform Citizens Possibly Exposed !PHASE 2
					break;
				case '4':
						inContactTracerMenu = false;
			}
		}
	}
}