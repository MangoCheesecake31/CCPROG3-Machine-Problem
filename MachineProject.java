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
							if(myAccount.logIn()) 
								inMainMenu = false;
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
		sc.close();
	}

	public boolean CitizenMenus() {

	}

	public boolean GovermentOfficialMenus() {

	}

	public boolean ContactTracerMenus() {

	}
}