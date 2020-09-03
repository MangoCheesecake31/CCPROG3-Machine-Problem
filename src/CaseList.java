import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*
 *	This object is dedicated to handling a text file that contains a list of all user reported postives cases.
 *  
 *	Version - 08-31-2020 10:32PM -
 */

public class CaseList {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private final File FILE;
	private int numCases;
	private ArrayList<Integer> caseNo = new ArrayList<>();
	private ArrayList<String> usernames = new ArrayList<>();
	private ArrayList<Calendar> reportDates = new ArrayList<>();
	private ArrayList<String> tracernames = new ArrayList<>();
	private ArrayList<Character> statuses = new ArrayList<>();


	// Constructors
	public CaseList() {
		this("Cases.txt");
	}

	public CaseList(String filename) {
		FILE = new File(filename);
		load();
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Getters ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	returns numCases field/attribute
	 * 	@author Steven Castro
	 *	@return int
	 */
	public int getNumCases() {
		return numCases;
	}

	/**
	 *	returns the index parameter caseNum of ArrayList usernames field/attribute
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getUsername(int caseNum) {
		return usernames.get(caseNum);
	}

	/**
	 *	returns the index parameter caseNum of ArrayList reportDates field/attribute
	 *	@author Steven Castro
	 *	@return String
	 */
	public Calendar getReportDate(int caseNum) {
		return reportDates.get(caseNum);
	}

	/**
	 *	returns the index parameter caseNum of ArrayList tracernames field/attribute
	 *	@author Steven Castro
	 *	@return String
	 */
	public String getTracerName(int caseNum) {
		return tracernames.get(caseNum);
	}

	/**
	 *	returns the index parameter caseNum of ArrayList status field/attribute
	 *	@author Steven Castro
	 *	@return char
	 */
	public char getStatus(int caseNum) {
		return statuses.get(caseNum);
	}

	/**
	 *	returns a String representation of all data of a specific case
	 *	@author Steven Castro
	 *	@param caseNum case number of a case to be returned in String
	 *	@return String
	 */
	public String toString(int caseNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

		String caseEntryText =  String.format("%-4d %-30s %-10s  %-30s %c", caseNo.get(caseNum), 
																		    usernames.get(caseNum),
																		    sdf.format(reportDates.get(caseNum).getTime()),
																		    tracernames.get(caseNum),
																		    statuses.get(caseNum));

		return caseEntryText;
	}

	// Data Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	adds or files a new reported case onto Object's Arrays
	 *	@author Steven Castro
	 *	@param user username of the user
	 *	@param date the date the case was reported
	 */
	public void addCase(String user, Calendar date) {
		caseNo.add(++numCases);
		usernames.add(user);
		reportDates.add(date);
		tracernames.add("000");
		statuses.add('P');

		save();
	}

	/**
	 *	returns true if assigning a tracer to a case is sucessful
	 *	@author Steven Castro
	 *	@param caseNum case number
	 *	@param tracer tracer username
	 *	@return boolean
	 */
	public boolean assignTracer(int caseNum, String tracer) {
		MasterList list = new MasterList();

		if(0 < caseNum && caseNum < numCases) {
			// Check tracer if it has a verified account
			if(list.checkMaster(tracer)) {
				tracernames.set(caseNum - 1, tracer);
				save();
				return true;
			}
			
		}
		return false;
	}

	/**
	 *	returns true if updating a status of a case is sucessful
	 *	@author Steven Castro
	 *	@param caseNum case number
	 *	@param status tracing status
	 *	@return boolean
	 */
	public boolean updateStatus(int caseNum, char state) {

		if(0 < caseNum && caseNum < numCases) {
			// Valid States of a Case
			switch(state) {
				case'p':
				case'P':
				case't':
				case'T': 
					statuses.set(caseNum - 1, state);
					save();
					return true;
			}
		}
		return false;
	}
	

	// File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	Reloads the contents of this Object's Arrays by scanning the text file again
	 *	@author Steven Castro
	 */
	public void refresh() {
		numCases = 0;
		caseNo = new ArrayList<>();
		usernames = new ArrayList<>();
		reportDates = new ArrayList<>();
		tracernames = new ArrayList<>();
		statuses = new ArrayList<>();

		load();
	}

	/**
	 *	Opens the text file then scan and loads the contents onto this Object's Arrays 
	 *	@author Steven Castro
	 */
	private void load() {
		String dump;
		Calendar date;

		try {
			Scanner sc = new Scanner(FILE);

			while(sc.hasNext()) {
				numCases++;

				// Case No. and Usernames
				caseNo.add(sc.nextInt());
				usernames.add(sc.next());

				// Report Date
				dump = sc.next();
				date = new Calendar.Builder().setFields(Calendar.MONTH, (Integer.parseInt(dump.substring(0, 2)) - 1),
                                                        Calendar.DAY_OF_MONTH, Integer.parseInt(dump.substring(3, 5)),
                                                	    Calendar.YEAR, Integer.parseInt(dump.substring(6, 10))).build();
				reportDates.add(date);
				
				// tracernames and Statuses
				tracernames.add(sc.next());
				statuses.add(sc.next().charAt(0));
			}

			sc.close();

		} catch (IOException e) {
			System.out.println("ERROR: Case List File Not Found (L)...");
		}
	}

	/**
	 *	Opens the text file writes the contents of this Object's Arrays onto it
	 *	@author Steven Castro
	 */
	private void save() {

		try {
			PrintStream ps = new PrintStream(FILE);

			for(int i = 0; i < numCases; i++) {
				ps.println(toString(i));
			}

		} catch (IOException e) {
			System.out.println("ERROR: Case List File Not Found (S)...");
		}
	}	
}