import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	
	 *	@author Roymaxson Li, Steven Castro
	 *  @param code the establishment code
	 */
	public void checkIn(String code) {
		RecordList records = new RecordList();
		records.addRecordEntry(getUsername(), code);
		
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	
	 *	@author Roymaxson Li
	 *  @param cal the calendar object
	 */
	public void reportPositive(Calendar cal) {
		CaseList caseList = new CaseList();
		caseList.addCase(getUsername(), cal);
	}
}