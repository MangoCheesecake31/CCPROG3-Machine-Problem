import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Record {
    // Attributes :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private int numEntries = 0;
    private String username;
    private ArrayList<Calendar> dateList = new ArrayList<>();
    private ArrayList<String> codeList = new ArrayList<String>();


     // Constructors :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     constructor
     @author Roymaxson Li
     @param username the account's username
     */
    public Record(String username) {
        this.username = username;
    }


     // Getters :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     gets the total number of entries
     @author Roymaxson Li
     @return numEntries
     */
    public int getNumEntry() {
        return numEntries;
    }

    /**
     gets the User's username
     @author Roymaxson Li
     @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     gets a date entry in the array list based on the index given
     @author Roymaxson Li
     @param index the chosen index
     @return the date object of a given index in the dateList array list
     */
    public Calendar getCalendarEntry(int index) {
        return dateList.get(index);
    }

    /**
     gets a code in the array list based on the index given
     @author Roymaxson Li
     @param index the chosen index
     @return the establishment code of a given index in the codeList array list
     */
    public String getCodeEntry(int index) {
        return codeList.get(index);
    }

     // Data Manipulation :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     adds the code, date, and time entry into array lists then increments numEntries
     @author Roymaxson Li
     @param code the establishment's code
     @param cal the date of entry
//     @param year the input year
//     @param month the input month
//     @param day the input day
     */
    public void addEntry(String code, Calendar cal) {
//        month -= 1;
//
//        Calendar time = Calendar.getInstance();
//
//        Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
//                Calendar.MONTH, month,
//                Calendar.DAY_OF_MONTH, day,
//                Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY),
//                Calendar.MINUTE, time.get(Calendar.MINUTE)).build();

        dateList.add(cal);
        codeList.add(code);

        numEntries++;
    }

    /**
     * outputs the establishment code and date in simple date format
     * @author Roymaxson Li
     * @param entry the input establishment code and date
     * @return establishment code, date, and time of given index
     */
    public String toString(int entry) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy HHmm");
        return codeList.get(entry)+ " " + sdf.format(dateList.get(entry).getTime());
    }
}