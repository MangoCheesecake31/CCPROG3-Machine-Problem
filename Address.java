public class Address {
	
	// ::::::::::::::::::::
	// 		Attributes
	// ::::::::::::::::::::

	private String emailAddress;
	private String homeAddress;
	private String officeAddress;
	private String phoneNumber;

	// Constructors

	public Address() {

	}
	
	public Address(String home, String office, String phone, String email) {
		setHomeAddress(home);
		setOfficeAddress(office);
		setPhoneNumber(phone);
		setEmailAddress(email);
	}

	// ::::::::::::::::::::
	// 		Methods
	// ::::::::::::::::::::
		
	// Setters

	public void setHomeAddress(String a) {
		homeAddress = a;
	}

	public void setOfficeAddress(String a) {
		officeAddress = a;
	}

	public boolean setPhoneNumber(String n) {
		if(validPhoneNumber(n)) {
			phoneNumber = n;
			return true;
		}
		return false;
	}

	public void setEmailAddress(String a) {
		emailAddress = a;
	}

	// Getters

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}



	private boolean validPhoneNumber(String n) {

		if(n.length() != 11) {							
			return false;
		}

		try {										
			double num = Double.parseDouble(n);
			
		} catch (NumberFormatException e) {			
			System.out.print("Invalid Format!");
			return false;

		}

		return true;
	}
}