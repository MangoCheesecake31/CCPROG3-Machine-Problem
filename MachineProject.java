import java.util.Scanner;

public class MachineProject {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		boolean programIsOn = true;
		boolean inMainMenu = true;

		while(programIsOn) {
			// New User
			Account accountInfo = new Account();

			// Main Menu
			while(inMainMenu && programIsOn) {

				Visual.mainMenu();

				switch(sc.next().charAt(0)) {
					case '1':
							accountInfo.register("customer");
						break;
					case '2': 
							if(accountInfo.logIn()) 
								inMainMenu = false;
						break;
					case '3':
							programIsOn = false;
				}
			}
						
			// Account Type Menus and Actions
			if(accountInfo.getOnline()) {
				if(accountInfo.getRole().equalsIgnoreCase("official")) {
					GovermentOfficial currentUser = new GovermentOfficial();

				} else if (accountInfo.getRole().equalsIgnoreCase("tracer")) {
					ContactTracer currentUser = new ContactTracer();

				} else {
					Citizen currentUser = new Citizen();
				}

				currentUser.copyAccountInfo(accountInfo);
			}


			while(currentUser.getOnline()) {

				if(accountInfo.getRole().equalsIgnoreCase("official")) {
					//officialmethodmenus
					

				} else if (accountInfo.getRole().equalsIgnoreCase("tracer")) {
					//tracerslmethodmenus

				} else {
					//customersmethodmenus
				}	

			}

			inMainMenu = true;
		}
		

		System.out.println("> Program is terminating..");
		sc.close();
	}
}