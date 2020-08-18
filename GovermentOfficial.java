import java.util.Scanner;

public class GovermentOfficial extends Citizen {
	
	public void showCases() {

	}

	// b. trace specificc aes method

	public void analytics() {

	}

	public boolean createGovernmentOfficialAccount() {

		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Username Input
		Visual.cls();
		Visual.createOfficialMenu();

		// If username is not existing register an government official account
		if(newUser.verifyUsername(input = sc.next())) {
			// If account is existing update role in MasterList.txt
			MasterList list = new MasterList();
			list.loadList();
			list.updateMaster(input, "official");
			list.saveList();

		} else if(!(newUser.register("official"))) {
			return false;
		}

		return true;
	}

	public boolean createContactTracerAccount()
	{
		Account newUser = new Account();
		Scanner sc = new Scanner(System.in);
		String input;

		// Username Input
		Visual.cls();
		Visual.usernameMenu();

		// If username is not existing register an government official account
		if(!(newUser.verifyUsername(input = sc.next()))) {
			if(newUser.register("tracer")) {
				return true;
			} else {
				return false;
			}
		}

		// If account is already existing update role in masterlist
		MasterList list = new MasterList();
		list.loadList();
		list.updateMaster(input, "tracer");
		list.saveList();

		return true;
	}

	public boolean terminateAccount(String username) {

		MasterList list = new MasterList();
		list.loadList();

		if(list.checkMaster(username)) {
			list.updateMaster(username, "customer");
			list.saveList();
			return true;
		}

		return false;
	}
}