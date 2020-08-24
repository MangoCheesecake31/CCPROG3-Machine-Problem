import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;

public class CaseList {
	// Attributes
	private int numEntries;
	private ArrayList<Integer> caseNumbers = new ArrayList<Integer>();
	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<Calendar> reportDates = new ArrayList<Calendar>();
	private ArrayList<String> tracerNames = new ArrayList<String>();
	private ArrayList<Character> status = new ArrayList<Character>();


	// Constructors
	public CaseList() {
		loadList();
	}


	// Methods
	/**
		returns the value of numEntries
		@author Steven Castro
		@return int
	*/
	public int getNumEntries() {
		return numEntries;
	}

	/**
		adds a new case onto CaseList.txt
		@author Steven Castro
		@param user
		@param date
	*/
	public void addCase(String user, Calendar date) {
		caseNumbers.add(++numEntries);
		usernames.add(user);
		reportDates.add(date);
		tracerNames.add("000");
		status.add('P');

		saveList();
	}

	/**
		returns a String output of a case in a format
		@author Steven Castro
		@param caseNum number of the case to be return in String
		@return String
	*/
	public String toString(int caseNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");
		return caseNumbers.get(caseNum) 
				+ " " + usernames.get(caseNum) 
				+ " " + sdf.format(reportDates.get(caseNum).getTime())
				+ " " + tracerNames.get(caseNum) 
				+ " " + status.get(caseNum);
	}

	/**
		returns true if assigning a tracer to a case is sucessful
		@author Steven Castro
		@param caseNum case number
		@param tracer tracer username
		@return boolean
	*/
	public boolean assignTracer(int caseNum, String tracer) {
		if(0 < caseNum && caseNum < numEntries) {
			tracerNames.set(caseNum - 1, tracer);
			saveList();
			return true;
		}
		return false;

	}

	/**
		returns true if updating a status of a case is sucessful
		@author Steven Castro
		@param caseNum case number
		@param status tracing status
		@return boolean
	*/
	public boolean updateStatus(int caseNum, char state) {
		if(0 < caseNum && caseNum < numEntries) {
			status.set(caseNum - 1, state);
			saveList();
			return true;
		}
		return false;

	}
	
	/**
		scans and loads CaseList.txt onto CaseList class arrays
		@author Steven Castro
	*/
	private void loadList() {
		Calendar cal;
		String temp;

		try {
			File fp = new File("Cases.txt");
			Scanner sc = new Scanner(fp);

			while(sc.hasNext()) {
				numEntries++;

				// Case Number and Username
				caseNumbers.add(sc.nextInt());
				usernames.add(sc.next());

				// Report Date
				temp = sc.next();
				cal = new Calendar.Builder().setFields(Calendar.MONTH, (Integer.parseInt(temp.substring(0, 2)) - 1),
                                                       Calendar.DAY_OF_MONTH, Integer.parseInt(temp.substring(3, 5)),
                                                	   Calendar.YEAR, Integer.parseInt(temp.substring(6, 10))).build();
				reportDates.add(cal);
				
				// Tracer Name and Status
				tracerNames.add(sc.next());
				status.add(sc.next().charAt(0));
			}
			
		} catch (IOException e) {
			System.out.println("file not found...");
		}
	}

	/**
		saves CaseList class arrays onto CaseList.txt
		@author Steven Castro
	*/
	private void saveList() {

		try {
			File fp = new File("Cases.txt");
			PrintStream ps = new PrintStream(fp);

			for(int i = 0; i < numEntries; i++) {
			ps.println(toString(i));
			}	
		} catch (IOException e) {
			System.out.println("file not found...");
		}
		
	}	
}