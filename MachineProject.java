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
					case '1':
							myAccount.register("customer");
						break;
					case '2':
							if(myAccount.logIn()) {
								if(myAccount.getRole().equalsIgnoreCase("customer")) {
									CitizenMenus();
								} else if(myAccount.getRole().equalsIgnoreCase("official")) {
									GovermentOfficialMenus();
								} else if(myAccount.getRole().equalsIgnoreCase("tracer")) {
									ContactTracerMenus();
								}
							}
						break;
					case '3':
							programIsOn = false;
				}
			}
			

			try {
				System.out.println(myAccount.getOnline());
				System.out.println(myAccount.getUsername());
				System.out.println(myAccount.getPassword());
				System.out.println(myAccount.getRole());
				System.out.println(myAccount.fullName);
			} catch (NullPointerException e) {
				System.out.println("Nobody!");
			}
			
			break;
						
			// // Account Type Menus and Actions
			// if(myAccount.getOnline()) {
			// 	if(myAccount.getRole().equalsIgnoreCase("official")) {
			// 		GovermentOfficial currentUser = new GovermentOfficial();

			// 	} else if (myAccount.getRole().equalsIgnoreCase("tracer")) {
			// 		ContactTracer currentUser = new ContactTracer();

			// 	} else {
			// 		Citizen currentUser = new Citizen();
			// 	}

			// 	currentUser.copyAccountInfo(myAccount);

			// 	while(currentUser.getOnline()) {

			// 		if(myAccount.getRole().equalsIgnoreCase("official")) {
			// 			//officialmethodmenus
						

			// 		} else if (myAccount.getRole().equalsIgnoreCase("tracer")) {
			// 			//tracerslmethodmenus

			// 		} else {
			// 			//customersmethodmenus
			// 		}	

			// 	}
			// }


			
			
		}
		

		System.out.println("> Program is terminating..");
	}

	public static void CitizenMenus() {
		Citizen citizen = new Citizen();
		Scanner sc = new Scanner(System.in);

		boolean inCitizenMenu = true;

		while(inCitizenMenu) {
			Visual.cls();
			Visual.citizenMenu();

			switch (sc.next().charAt(0)) {
				case '1':
						citizen.checkIn();
					break;
				case '2':
						citizen.reportPositive();
					break;
				case '3':
						citizen.changeUserInfo();
					break;
				case '4':
					inCitizenMenu = false;
			}
		}
	}

	public static void GovermentOfficialMenus() {
		GovernmentOfficial gov = new GovernmentOfficial();
		Scanner	sc = new Scanner(System.in);

		boolean inGovernmentOfficialMenu = true;

		while(inGovernmentOfficialMenu) {
			Visual.cls();
			Visual.governmentOfficialMenu();

			switch(sc.next().charAt(0)) {
				case '1':
						gov.showUnassignedCases();
					break;
				case '2':
						// Show Contact Tracing Updates !PHASE 2
					break;
				case '3':
						gov.analytics();
					break;
				case '4':
						gov.createGovernmentOfficial();
					break;
				case '5':
						gov.createContactTracer();
					break;
				case '6':
						if(gov.terminateAccount(sc.nextLine()))
							System.out.println("User demoted to citizen!");
						else
							System.out.println("Username does not exist.");
							Visual.pressEnterToContinue();
					break;
				case '7':
						inGovernmentOfficialMenu = false;
			}
		}
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