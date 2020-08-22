import java.util.ArrayList;
import java.util.Calendar;

public class PositiveResults {
    private int numCases = 0;
    private ArrayList<Calendar> dateList = new ArrayList<>();
    private ArrayList<String> userList = new ArrayList<>();

    /**
     gets the total number of cases
     @author Roymaxson Li
     @return numCases
     */
    public int getNumCases() {
        return numCases;
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
     gets a user in the array list based on the index given
     @author Roymaxson Li
     @param index
     @returns the username of a given index in the userList array list
     */
    public String getCodeEntry(int index) {
        return userList.get(index);
    }

    /**
     adds the username, date, and time entry into array lists then increments numCases
     @author Roymaxson Li
     @param username
     @param year
     @param month
     @param day
     @param hour
     @param minute
     */
    public void addEntry(String username, int year, int month, int day, int hour, int minute) {
        month -= 1;

        Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
                                                        Calendar.MONTH, month,
                                                        Calendar.DAY_OF_MONTH, day,
                                                        Calendar.HOUR, hour,
                                                        Calendar.MINUTE, minute).build();
        dateList.add(cal);
        userList.add(username);

        numCases++;
    }
}
