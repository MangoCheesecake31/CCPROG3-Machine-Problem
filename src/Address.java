public class Address {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private String homeAddress;
	private String officeAddress;
	private String emailAddress;
	private String phoneNumber;


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	Constructs a Address object with null fields
	 *
	 * 	@author Steven Castro
	 */
	public Address() {

	}
	
	/**
	 * 	Constructs a Address object while also settings it's fields
	 *
	 * 	@author Steven Castro
	 *  @param  home   home address
	 *  @param  office office address
	 *  @param  phone  phone address
	 *  @param  email  email address
	 */
	public Address(String home, String office, String phone, String email) {
		setHomeAddress(home);
		setOfficeAddress(office);
		setPhoneNumber(phone);
		setEmailAddress(email);
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		
	// Setters ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	sets value of homeAddress field
	 *	
	 *	@author Steven Castro
	 *	@param a home address
	 */
	public void setHomeAddress(String a) {
		homeAddress = a;
	}

	/**
	 *	sets value of officeAddress field
	 *	
	 *	@author Steven Castro
	 *	@param a office address
	 */
	public void setOfficeAddress(String a) {
		officeAddress = a;
	}

	/**
	 *	returns true if setting the value of phoneNumber field is sucessful
	 *	@author Steven Castro
	 *	@param n phone number
	 *	@return boolean
	 */
	public boolean setPhoneNumber(String n) {
		if(validPhoneNumber(n)) {
			phoneNumber = n;
			return true;
		}
		return false;
	}

	/**
	 *	sets value of emailAddress field
	 *	
	 *	@author Steven Castro
	 *	@param a email address
	 */
	public void setEmailAddress(String a) {
		emailAddress = a;
	}

	// Getters ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	returns the value of homeAddress field
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 *	returns the value of officeAddress field
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 *	returns the value of phoneNumber field
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 *	returns the value of emailAddress field
	 *	
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	// Data Validity ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	returns true if the number is valid
	 *	
	 *	@author Steven Castro
	 *	@param n phone number
	 *	@return boolean
	 */
	private boolean validPhoneNumber(String n) {
		try {										
			double num = Double.parseDouble(n);
			
		} catch (NumberFormatException e) {			
			System.out.print("Invalid Format!");
			return false;
		}
		return true;
	}
}