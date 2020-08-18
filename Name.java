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

	public void setFirstName(String n) {
		firstName = n;
	}

	public void setMiddleName(String n) {
		middleName = n;
	}

	public void setLastName(String n) {
		lastName = n;
	}

	// Getters

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + " " + middleName;
	}

}