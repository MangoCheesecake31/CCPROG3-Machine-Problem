import java.io.*;
import java.text.*;
import java.util.*;

/*
 *	This object is dedicated to handling a text file that contains all user's records.
 *
 *
 */

public class RecordList {
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private final File FILE;
	private int numAcc;
	private int numRecords;
	private ArrayList<Record> records = new ArrayList<>();


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	Constructs a RecordList object with default file path to Record List text file (Records.txt)
	 * 	
	 *  @author Steven Castro
	 */
	public RecordList() {
		this("Records.txt");
	}

	/**
	 * 	Constructs a RecordList object with desired file path to Record List text file (Records.txt)
	 * 	
	 *  @author Steven Castro
	 */
	public RecordList(String filename) {
		FILE = new File(filename);
		load();
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 
	// Getter ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	return a Record found in the ArrayList records based on the username
	 * 
	 *	@author Steven Castro
	 *	@param username username of the Record holder
	 */
	public Record getUserRecord(String username) {
		for(Record x: records) {
			if(x.getUsername().equalsIgnoreCase(username)) {
				return x;

			}
		}
		return null;
	}

	/**
	 *	return a Record found in the ArrayList records based on the index
	 * 
	 * 	@author Steven Castro
	 *  @param index index of the Record in ArrayList records
	 */
	public Record getUserRecord(int index) {
		return records.get(index); 

	}


	// Data Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	Appends or Add a Record parameter in the ArrayList records
	 * 
	 *	@author Steven Castro
	 *	@param rc Record to be added onto the text file
	 */
	public void addRecord(Record rc) {
		records.add(rc);
		save();
		numAcc++;
	}

	/**
	 *	Add a record entry to a user's Record in the ArrayList records
	 * 
	 *	@author Steven Castro
	 *	@param username username of the Record holder
	 *	@param code establishment code to be added in the new entry
	 */
	public void addRecordEntry(String username, String code) {
		if (getUserRecord(username) != null) {
			getUserRecord(username).addEntry(code, Calendar.getInstance());

		} else {
			Record rc = new Record(username);
			rc.addEntry(code, Calendar.getInstance());
			addRecord(rc);

		}
		save();
	}


	// File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 *	Reloads the contents of this Object's Arrays by scanning the text file again
	 * 
	 *	@author Steven Castro
	 */
	public void refresh() {
		numRecords = 0;
		records = new ArrayList<>();

		load();
	}

	/**
	 * 	Opens the text file then scan and loads the contents onto this Object's Arrays
	 * 	
	 *	@author Roymaxson Li
	 */
	private void load() {
		Record rec = null;
		String username;
		String code;
		String date;
		String time;

		try {
			Scanner sc = new Scanner(FILE);
			StringTokenizer st;
			String dump;

			while(sc.hasNext()) {

				dump = sc.nextLine();
				st = new StringTokenizer(dump, " ");

				// Username Line
				if (st.countTokens() == 1) {
					username = st.nextToken();
					numAcc++;
					rec = new Record(username);

				// Record Entry Lines
				} else if (st.countTokens() == 3) {

					code = st.nextToken();
					date = st.nextToken();
					time = st.nextToken();

					Calendar cal = buildCalendar(date, time);

					rec.addEntry(code, cal);

				// Blank Lines '\n'
				} else {
					// Add to list of Records
					records.add(rec);

				}
			}
			// Add the Last Record
			records.add(rec);

		} catch (IOException e) {
			System.out.println("ERROR: Record List Text File Not Found...");

		}
	} 

	/**
	 * 	Opens the text file and writes the contents of this Object's Arrays onto it
	 * 	
	 *	@author Roymaxson Li
	 */
	private void save() {
		try {
			PrintWriter pw = new PrintWriter(FILE);

			for(Record rec : records) {
				pw.println(rec.getUsername());

				for(int i = 0; i < rec.getNumEntry(); i++) {
					pw.println(rec.toString(i));

				}
				pw.println();
			}

			pw.close();
		
		} catch (IOException e) {
			System.out.println("ERROR: Record List Text File Not Found...");

		}
	} 

	// Data Searching & Creation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	returns the index of a Record based on the parameter username
	 *
	 * 	@author Steven Castro
	 * 	@param username username of record holder			
	 */
	private int searchUsernameIndex(String username) {

		for(int i = 0; i < numAcc; i++) {
			if(records.get(i).getUsername().equalsIgnoreCase(username))
				return i;
		}

		System.out.println("Username Not Found...");
		return -1;
	}

	/**
	 * 	builds and return a Calendar Object based on the String parameters
	 *
	 * 	@author Steven Castro
	 * 	@param date String represendation of a date (MM,dd,yyyy)
	 * 	@param time String represendation of a military time (hhmm)
	 */
	public static Calendar buildCalendar(String date, String time) {
		try {
			// Tokenize Information
			StringTokenizer st = new StringTokenizer(date, ",");
	
			// Date
			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
	
			// Time
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = Integer.parseInt(time.substring(2, 4));
	
			// Check Validity
			// Date
			if (!(1 <= month && month <= 12) || !(1 <= year && year < 9999)) {
				// System.out.println("Month or Year");
				return null;
			}

			if (1 <= day) {
				switch (month) {
					case 1, 3, 5, 7, 8, 10, 12:
						if (!(day <= 31)) {
						// System.out.println("Invalid Day (31)");
						return null;
						}
					break;
					case 4, 6, 9,11:
						if (!(day <= 30)) {
							// System.out.println("Invalid Day (30)");
							return null;
						}
					break;
					default:
						if (!(day <= 28)) {
							// System.out.println("Invalid Day (28)");
							return null;
						}
					}
			} else {
				return null;

			}

			// Time
			if (!(0 <= hour && hour <= 24) || !(0 <= minute && minute <= 60)) {
				// System.out.println("Invalid Time");
				return null;
			}  

			// Build Calendar Object
			Calendar calendar = new Calendar.Builder().setFields(Calendar.MONTH, month - 1,
															 Calendar.DAY_OF_MONTH, day,
															 Calendar.YEAR, year,
                										 	 Calendar.HOUR_OF_DAY, hour,
                										 	 Calendar.MINUTE, minute).build();
			return calendar;

		} catch (NullPointerException e) {
			return null;

		} catch (NumberFormatException e) {
			return null;

		} catch (NoSuchElementException e) {
			return null;
			
		}
	}
}