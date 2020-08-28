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

	public static void regUsernameMenu() {
		System.out.println("| ----------------------------- Register ------------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Username:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void logUsernameMenu() {
		System.out.println("| ------------------------------ Login -------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Username:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void regPasswordMenu() {
		System.out.println("| ----------------------------- Register ------------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Password:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void logPasswordMenu() {
		System.out.println("| ------------------------------ Login  ------------------------------- |");
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

	public static void isExistingAccountMenu() {
		System.out.println("| ------------------------- Existing Account -------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Does the Account already Exist? (Y/N)                              |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void createOfficialMenu() {
		System.out.println("| --------------------- Create Goverment Official --------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Username:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void createTracerMenu() {
		System.out.println("| ------------------------ Create Contact Tracer ---------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Username:                                                    |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void analyticsMenu() {
		System.out.println("| ----------------------------- Analytics ----------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Show Number of Cases in a...                                       |");
		System.out.println("|    [1] Given City and Duration                                        |");
		System.out.println("|    [2] Given City                                                     |");
		System.out.println("|    [3] Given Duration                                                 |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void inputStartDateMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Start Date: (MM,dd,yyyy)                                     |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void inputEndDateMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter End Date: (MM,dd,yyyy)                                       |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void inputCityMenu() {
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter City:                                                        |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void citizenMenu() {
		System.out.println("| ------------------------------ Citizen ------------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Check In                                                       |");
		System.out.println("|    [2] Report Positive Test Result                                    |");
		System.out.println("|    [3] Update Profile Information                                     |");
		System.out.println("|    [4] Log Out                                                        |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void governmentOfficialMenu() {
		System.out.println("| ------------------------ Government Official ------------------------ |");
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Check In                                                       |");
		System.out.println("|    [2] Report Positive Test Result                                    |");
		System.out.println("|    [3] Update Profile Information                                     |");
		System.out.println("|    [4] Show Unassigned Cases                                          |");
		System.out.println("|    [5] Show Contact Tracing Updates                                   |");
		System.out.println("|    [6] Analytics                                                      |");
		System.out.println("|    [7] Create Government Official Account                             |");
		System.out.println("|    [8] Create Contact Tracer Account                                  |");
		System.out.println("|    [9] Terminate Account                                              |");
		System.out.println("|    [0] Log Out                                                        |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		  System.out.print("|>>> ");
	}

	public static void contactTracerMenu() {
		System.out.println("| -------------------------- Contact Tracer --------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    [1] Check In                                                       |");
		System.out.println("|    [2] Report Positive Test Result                                    |");
		System.out.println("|    [3] Update Profile Information                                     |");
		System.out.println("|    [4] Show Cases                                                     |");
		System.out.println("|    [5] Trace Specific Case                                            |");
		System.out.println("|    [6] Inform Citizens Possibly Exposed                               |");
		System.out.println("|    [7] Log Out                                                        |");
		System.out.println("|                                                                       |");
		System.out.println("| --------------------------------------------------------------------- |");
		System.out.print("|>>> ");
	}


	public static void terminateAccountMenu() {
		System.out.println("| ------------------------- Terminate Account ------------------------- |");
		System.out.println("|                                                                       |");
		System.out.println("|    Enter Username:                                                    |");
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

	public static void pressEnterToContinue()
	{
		System.out.println("|> Press Enter to Continue...");
		try {
			System.in.read();
		} catch (Exception e){

		}
	}

}