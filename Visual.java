

import java.io.IOException;

public class Visual {
	public static void mainMenu() {

		System.out.println("| ----------------------------- Main Menu ----------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Register                                                       |");
		System.out.println("|    [2] Login                                                          |");
		System.out.println("|    [3] Exit                                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void usernameMenu() {
		System.out.println("| ----------------------------- Register ------------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Unique Username:                                             |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void passwordMenu() {
		System.out.println("| ----------------------------- Register ------------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Password:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void firstNameMenu() {
		System.out.println("| -------------------------- Personal Details ------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your First Name:                                             |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void middleNameMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Middle Name:                                            |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void lastNameMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Last Name:                                              |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void homeAddMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Home Address:                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void officeAddMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Office Address                                          |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void phoneNumMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Phone Number:                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void emailAddMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Your Email Address:                                          |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void changeUserMainMenu() {
		System.out.println("| ---------------------- Change Personal Details ---------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Name                                                           |");
		System.out.println("|    [2] Addresses                                                      |");
		System.out.println("|    [3] Exit                                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void changeUserNameMenu(Name fullname) {
		System.out.println("| ------------------------ Change Name Details ------------------------ |");
		System.out.println("|                                                                       |");
		 System.out.format("|    Current Name : %-52s|\n", fullname);
		System.out.println("|                                                                       |");
		System.out.println("|    [1] First Name                                                     |");
		System.out.println("|    [2] Middle Name                                                    |");
		System.out.println("|    [3] Last Name                                                      |");
		System.out.println("|    [4] Save & Exit                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void enterNewNameMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter New Name:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void changeUserAddressMenu(Address addresses) {
		System.out.println("| ----------------------- Change Address Details ---------------------- |");
		System.out.println("|                                                                       |");
		 System.out.format("|    HOME  : %-59s|\n", addresses.getHomeAddress());
		 System.out.format("|    OFFICE: %-59s|\n", addresses.getOfficeAddress());
		 System.out.format("|    PHONE : %-59s|\n", addresses.getPhoneNumber());
		 System.out.format("|    EMAIL : %-59s|\n", addresses.getEmailAddress());
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Home Address                                                   |");
		System.out.println("|    [2] Office Address                                                 |");
		System.out.println("|    [3] Phone Address                                                  |");
		System.out.println("|    [4] Email Address                                                  |");
		System.out.println("|    [5] Save & Exit                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void enterNewAddressMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter New Address:                                                 |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void createOfficialMenu() {
		System.out.println("| ---------------------- Create Goverment Official -------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Existing Username:                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void createTracerMenu() {
		System.out.println("| ------------------------ Create Contact Tracer ---------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Existing Username:                                           |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}












	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e){
			System.out.println(e);
		}
	}

}