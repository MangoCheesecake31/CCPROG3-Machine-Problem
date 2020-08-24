import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Record {
    private int numEntries = 0;
    private String username;
    private ArrayList<Calendar> dateList = new ArrayList<>();
    private ArrayList<String> codeList = new ArrayList<String>();

    /**
        constructor
        @author Roymaxson Li
        @param username
    */
    public Record(String username) {
        this.username = username;
    }

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
        @param index
        @returns the date object of a given index in the dateList array list
    */
    public Calendar getCalendarEntry(int index) {
        return dateList.get(index);
    }

    /**
        gets a code in the array list based on the index given
        @author Roymaxson Li
        @param index
        @returns the establishment code of a given index in the codeList array list
    */
    public String getCodeEntry(int index) {
        return codeList.get(index);
    }

    /**
        adds the code, date, and time entry into array lists then increments numEntries
        @author Roymaxson Li
        @param code
        @param year
        @param month
        @param day
        @param hour
        @param minute
    */
    public void addEntry(String code, int year, int month, int day, int hour, int minute) {
        month -= 1;

        Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
                                                        Calendar.MONTH, month,
                                                        Calendar.DAY_OF_MONTH, day,
                                                        Calendar.HOUR, hour,
                                                        Calendar.MINUTE, minute).build();
        dateList.add(cal);
        codeList.add(code);

        numEntries++;
    }

    /**
     * outputs the establishment code and date in simple date format
     * @author Roymaxson Li
     * @param entry
     * @return establishment code, date, and time of given index
     */
    public String toString(int entry) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy HHmm");
        return codeList.get(entry)+ " " + sdf.format(dateList.get(entry).getTime());
    }
}