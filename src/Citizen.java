import java.util.Calendar;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	
	 *	@author Roymaxson Li
	 *  @param code the establishment code
	 *  @param dateTime Calendar object on when the user checked in
	 */
	public void checkIn(String code, Calendar dateTime) {
		RecordList records = new RecordList();
		// Add the Check In Entry to User's Record
		records.addRecordEntry(getUsername(), code, dateTime);
		
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	
	 *	@author Roymaxson Li
	 *  @param cal the calendar object
	 *  @return boolean
	 */
	public boolean reportPositive(Calendar cal) {
		CaseList caseList = new CaseList();

		return caseList.addCase(getUsername(), cal);
	}
}