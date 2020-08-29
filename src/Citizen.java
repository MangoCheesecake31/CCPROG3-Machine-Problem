import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	@author Roymaxson Li
	 * @param acc
	 * @param code
	 * @param year
	 * @param month
	 * @param day
	 */
	public void checkIn(Account acc, String code, int year, int month, int day) {
		Record rec = new Record(acc.getUsername());

		rec.addEntry(code, year, month, day);
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	@author Roymaxson Li
	 */
	public void reportPositive(Account acc, Calendar cal) {
		CaseList caseList = new CaseList();

		caseList.addCase(getUsername(), cal);
	}


}