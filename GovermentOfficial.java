import java.util.Scanner;

public class GovermentOfficial extends Citizen {
	// Attributes
	private MasterList list = new MasterList();


	// Methods ::::::::::::::::::::
	public void showCases() {

	}

	// b. trace specificc aes method

	public void analytics() {

	}

	/**
		returns true if goverment offical account creation is sucessful
		undergo registry process if username does not exist in MasterList.txt 
		@author Steven Castro
	*/
	public boolean createGovernmentOfficial() {

		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Ask User for Desirable Username
		Visual.cls();
		Visual.createOfficialMenu();
		
		// If Username does not Exist in MasterList undergo registry process
		if(newUser.verifyUsername(input = sc.next())) {
			// Check Account Role
			if(list.getMasterRole(input).equals("official")) {
				System.out.println("|INVALID: Account already has Goverment Official Role...");
				return false;
			}

			// If Account is Existing Update Role of User in MasterList.txt
			list.updateMaster(input, "official");

		} else if(!(newUser.register("official"))) {
			return false;
		}

		return true;
	}

	/**
		returns true if contact tracer account creation is sucessful
		undergo registry process if username does not exist in MasterList.txt 
		@author Steven Castro
	*/
	public boolean createContactTracer()
	{
		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Ask User for Desirable Username
		Visual.cls();
		Visual.createTracerMenu();

		// If Username does not Exist in MasterList undergo registry process
		if(newUser.verifyUsername(input = sc.next())) {
			// Check Account Role
			if(list.getMasterRole(input).equals("tracer")) {
				System.out.println("|INVALID: Account already has Contact Tracer Role...");
				return false;
			}

			// If Account is Existing Update Role of User in MasterList.txt
			list.updateMaster(input, "tracer");

		} else if(!(newUser.register("tracer"))) {
			return false;
		}

		return true;
	}

	/**
		returns true if termination of account is sucessful
		@author Steven Castro
		@param username username of the user to be demoted to customer account
	*/
	public boolean terminateAccount(String username) {
		// Search Username in MasterList
		if(list.checkMaster(username)) {
			// Demote User's Role to Customer
			list.updateMaster(username, "customer");
			return true;
		}

		return false;
	}
}

