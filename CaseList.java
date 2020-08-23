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

	public int getNumEntries() {
		return numEntries;
	}

	public void addCase(String user, Calendar date) {
		caseNumbers.add(++numEntries);
		usernames.add(user);
		reportDates.add(date);
		tracerNames.add("000");
		status.add('P');

		saveList();
	}

	public String toString(int caseNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");
		return caseNumbers.get(caseNum) 
				+ " " + usernames.get(caseNum) 
				+ " " + sdf.format(reportDates.get(caseNum).getTime())
				+ " " + tracerNames.get(caseNum) 
				+ " " + status.get(caseNum);
	}

	public void assignTracer(String tracer, int caseNum) {
	
	}

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

		}
	}

	private void saveList() {

		try {
			File fp = new File("Cases.txt");
			PrintStream ps = new PrintStream(fp);

			for(int i = 0; i < numEntries; i++) {
			ps.println(toString(i));
			}	
		} catch (IOException e) {
			System.out.println("File Not Found!");
		}
		
	}	
}