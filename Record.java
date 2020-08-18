import java.util.Calendar;
import java.util.ArrayList;

public class Record {
    private int numEntries;
    private String username;
    private ArrayList<Code> codeList;
    private Calendar dateTimeList[];

    public Record(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public addEntry(Code code, int year, int month, int day, int hour, int minute) {
        month--;

        Calendar cal = new GregorianCalendar(year, month, day);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);

        
}