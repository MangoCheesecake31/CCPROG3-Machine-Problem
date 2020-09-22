public class Testing {
	public static void main(String[] args) {
		
		Account ac = new Account();

		ac = Account.logIn("asdasd1", "asdasd1");

		GovernmentOfficial gv = (GovernmentOfficial) ac;

		gv.terminateAccount("wakanda");

	}
}