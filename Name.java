public class Name {
	
	// ::::::::::::::::::::
	// 		Attributes
	// ::::::::::::::::::::

	private String firstName;
	private String middleName;
	private String lastName;

	// Constructors

	public Name(String first, String mid, String last) {
		setFirstName(first);
		setMiddleName(mid);
		setLastName(last);
	}

	// ::::::::::::::::::::
	// 		Methods
	// ::::::::::::::::::::
		
	// Setters
	/**
		sets the value of firstName field
		@author Steven Castro
		@param n first name
	*/
	public void setFirstName(String n) {
		firstName = n;
	}

	/**
		sets the value of middleName field
		@author Steven Castro
		@param n middle name
	*/
	public void setMiddleName(String n) {
		middleName = n;
	}

	/**
		sets the value of lastName field
		@author Steven Castro
		@param n last name
	*/
	public void setLastName(String n) {
		lastName = n;
	}

	// Getters
	/**
		returns the value of firstName field
		@author Steven Castro
		@return String
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
		returns the value of middleName field
		@author Steven Castro
		@return String
	*/
	public String getMiddleName() {
		return middleName;
	}

	/**
		returns the value of lastName field
		@author Steven Castro
		@return String
	*/
	public String getLastName() {
		return lastName;
	}

	/**
		returns a String in a format containing fields of the Name Class
		@author Steven Castro
		@return String
	*/
	@Override
	public String toString() {
		return lastName + ", " + firstName + " " + middleName;
	}
	
}