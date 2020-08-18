import java.util.Scanner;

public class MachineProject {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		boolean programIsOn = true;
		boolean inMainMenu = true;


		while(programIsOn) {
			// New User
			Account currentUser = new Account();

			while(inMainMenu && programIsOn) {

				Visual.mainMenu();

				switch(sc.next().charAt(0)) {
					case '1':
							currentUser.register("customer");
						break;
					case '2': 
						if(currentUser.logIn()) 
							inMainMenu = false;
						break;
					case '3':
							programIsOn = false;
				}
			}

			try {
				System.out.println(currentUser.fullName);
				System.out.println(currentUser.addresses.getEmailAddress());
			} catch (NullPointerException e) {
				System.out.println("Hotdog!");
			}
			

			

			// if(currentUser.getStatus()) {
				
			// 	// Goverment Official Menus
			// 	while(currentUser.getRole().equals("official") && currentUser.getStatus()) {

			// 	}

			// 	// Contact Tracer Menus
			// 	while(currentUser.getRole().equals("tracer") && currentUser.getStatus()) {

			// 	}

			// 	// Customer Menus
			// 	while(currentUser.getRole().equals("customer") && currentUser.getStatus()) {

			// 	}
			// }

			break;


		}
		

		System.out.println("> Program is terminating..");
		sc.close();
	}
}