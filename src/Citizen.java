import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	@author Roymaxson Li
	 * @param code
	 * @param year
	 * @param month
	 * @param day
	 */
	public void checkIn(String code, int year, int month, int day) {
		Record rec = new Record(getUsername());

		rec.addEntry(code, year, month, day);

		System.out.print("Output: ");
		System.out.println(rec.toString(0));
		Visual.pressEnterToContinue();
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	@author Roymaxson Li
	 */
	public void reportPositive(Calendar cal) {
		CaseList caseList = new CaseList();

		caseList.addCase(getUsername(), cal);
	}


}