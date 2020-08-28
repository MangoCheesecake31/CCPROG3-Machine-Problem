import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Citizen extends Account {
	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 *	asks the User to input the establishment code, date, and time of check in
	 *	then adds it to the User's record.
	 *	@author Roymaxson Li
	 */
	public void checkIn() {
		int year, month, day;
		Record rec = new Record(getUsername());
		Scanner sc = new Scanner(System.in);

		System.out.println("Checking In!");
		System.out.print("Please enter establishment code: ");
		String code = sc.nextLine();
		System.out.print("Enter year: ");
		year = sc.nextInt();
		System.out.print("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.print("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);

		rec.addEntry(code, year, month, day);
	}

	/**
	 *	asks the User to input the date and time of reported positive
	 *	test result then records it along with the user name
	 *	@author Roymaxson Li
	 */
	public void reportPositive() {
		int month, day;
		Record rec = new Record(getUsername());
		CaseList caseList = new CaseList();
		Scanner sc = new Scanner(System.in);

		System.out.println("Covid Positive!");
		System.out.print("Enter year: ");
		int year = sc.nextInt();
		System.out.print("Enter month (1-12): ");
		do {
			month = sc.nextInt();
			if(month > 12 || month < 1)
				System.out.println("Invalid input.");
		} while(month > 12 || month < 1);
		System.out.print("Enter day of month: ");
		do {
			day = sc.nextInt();
			if(day > 31 || day < 1)
				System.out.println("Invalid input.");
		} while (day > 31 || day < 1);

		Calendar time = Calendar.getInstance();
		Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
														Calendar.MONTH, month,
														Calendar.DAY_OF_MONTH, day,
														Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY),
														Calendar.MINUTE, time.get(Calendar.MINUTE)).build();
		caseList.addCase(getUsername(), cal);
	}


}