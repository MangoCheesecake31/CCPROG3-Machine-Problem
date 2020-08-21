import java.util.Calendar;
import java.util.ArrayList;

public class Record {
    private int numEntries;
    private String username;
    private ArrayList<Calendar> dateList = new ArrayList<>();
    private ArrayList<Code> codeList = new ArrayList<>();

    /**
        @author Roymaxson Li
        @param username
    */
    public Record(String username) {
        this.username = username;
    }

    /**
        @author Roymaxson Li
    */
    public int getNumEntry() {
        return numEntries;
    }

    /**
        @author Roymaxson Li
    */
    public String getUsername() {
        return username;
    }

    /**
        @author Roymaxson Li
        @param index
    */
    public Calendar getCalendarEntry(int index) {
        return dateList.get(index);
    }

    /**
        @author Roymaxson Li
        @param index
    */
    public Code getCodeEntry(int index) {
        return codeList.get(index);
    }

    /**
        @author Roymaxson Li
        @param code
        @param year
        @param month
        @param day
        @param hour
        @param minute
    */
    public void addEntry(Code code, int year, int month, int day, int hour, int minute) {
        month -= 1;

        Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
                                                        Calendar.MONTH, month,
                                                        Calendar.DAY_OF_MONTH, day,
                                                        Calendar.HOUR, hour,
                                                        Calendar.MINUTE, minute).build();
        dateList.add(cal);
        codeList.add(code);
    }
}