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
					case '1' -> myAccount.register("customer");
					case '2' -> {
						if (myAccount.logIn()) {
							if (myAccount.getRole().equalsIgnoreCase("customer")) {
								CitizenMenus();
							} else if (myAccount.getRole().equalsIgnoreCase("official")) {
								GovernmentOfficialMenus();
							} else if (myAccount.getRole().equalsIgnoreCase("tracer")) {
								ContactTracerMenus();
							}
						}
					}
					case '3' -> programIsOn = false;
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
		Account acc = new Account();
		Scanner sc = new Scanner(System.in);

		boolean inCitizenMenu = true;

		while(inCitizenMenu) {
			Visual.cls();
			Visual.citizenMenu();

			switch (sc.next().charAt(0)) {
				case '1' -> citizen.checkIn();
				case '2' -> citizen.reportPositive();
				case '3' -> citizen.changeUserInfo();
				case '4' -> {
					acc.logOut();
					inCitizenMenu = false;
				}
			}
		}
	}

	public static void GovernmentOfficialMenus() {
		GovernmentOfficial gov = new GovernmentOfficial();
		Citizen citizen = new Citizen();
		Account acc = new Account();
		Scanner	sc = new Scanner(System.in);

		boolean inGovernmentOfficialMenu = true;

		while(inGovernmentOfficialMenu) {
			Visual.cls();
			Visual.governmentOfficialMenu();

			switch(sc.next().charAt(0)) {
				case '1' -> citizen.checkIn();
				case '2' -> citizen.reportPositive();
				case '3' -> citizen.changeUserInfo();
				case '4' -> gov.showUnassignedCases();
				case '5' -> System.out.println("Show Contact Tracing Updates !PHASE 2"); // !PHASE 2
				case '6' -> gov.analytics();
				case '7' -> gov.createGovernmentOfficial();
				case '8' -> gov.createContactTracer();
				case '9' -> {
					if (gov.terminateAccount(sc.nextLine()))
						System.out.println("User demoted to citizen!");
					else
						System.out.println("Username does not exist.");
					Visual.pressEnterToContinue();
				}
				case '0' -> {
					acc.logOut();
					inGovernmentOfficialMenu = false;
				}
			}
		}
	}

	public static void ContactTracerMenus() {
		ContactTracer contactTracer = new ContactTracer();
		Citizen citizen = new Citizen();
		Account acc = new Account();
		Scanner	sc = new Scanner(System.in);

		boolean inContactTracerMenu = true;

		while(inContactTracerMenu) {
			Visual.cls();
			Visual.contactTracerMenu();

			switch(sc.next().charAt(0)) {
				case '1' -> citizen.checkIn();
				case '2' -> citizen.reportPositive();
				case '3' -> citizen.changeUserInfo();
				case '4' -> System.out.println("Show Cases !PHASE 2"); // !PHASE 2
				case '5' -> System.out.println("Trace Specific Case !PHASE 2"); // !PHASE 2
				case '6' -> System.out.println("Inform Citizens Possibly Exposed !PHASE 2"); // !PHASE 2
				case '7' -> {
					acc.logOut();
					inContactTracerMenu = false;
				}
			}
		}
	}
}