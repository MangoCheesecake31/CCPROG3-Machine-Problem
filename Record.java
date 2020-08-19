import java.util.Calendar;
import java.util.ArrayList;

public class Record {
    private int numEntries;
    private String username;
    public ArrayList<Calendar> dateList = new ArrayList<Calendar>(); // TODO: public(?)
    private ArrayList<Code> codeList = new ArrayList<Code>();

    public Record(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // TODO: implement public Calendar getCalendarEntry(int index), public Code getCodeEntry(int index) --> new class

    public void addEntry(Code code, int year, int month, int day, int hour, int minute) {
        month -= 1;
        // TODO: error checking
        Calendar cal = new Calendar.Builder().setFields(Calendar.YEAR, year,
                                                        Calendar.MONTH, month,
                                                        Calendar.DAY_OF_MONTH, day,
                                                        Calendar.HOUR, hour,
                                                        Calendar.MINUTE, minute).build();
        dateList.add(cal);
        codeList.add(code);
    }
}