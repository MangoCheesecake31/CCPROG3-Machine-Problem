import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ContactTracer extends Citizen {
    // Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    /**
     * Shows the list of case numbers assigned to this contact tracer that have
     * not undergone contact tracing yet
     *
     * @return the list of case numbers
     */
    public String[][] showCases() {
        CaseList cases = new CaseList();
        SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

        int count = 0;
        String[][] temp = new String[cases.getNumCases()][3];

        // Size of Number of Cases
        for (int i = 0; i < cases.getNumCases(); i++) {
            if (cases.getTracerName(i).equals(getUsername()) && cases.getStatus(i) == 'P') {
                temp[count][0] = String.valueOf(i + 1);
                temp[count][1] = sdf.format(cases.getReportDate(i).getTime());
                temp[count][2] = String.valueOf(cases.getStatus(i));

                count++;
            }
        }

        // Size of Number of Unassigned Cases
        String[][] data = new String[count][3];

        for (int i = 0; i < count; i++) {
            data[i][0] = temp[i][0];
            data[i][1] = temp[i][1];
            data[i][2] = temp[i][2];
        }
        return data;
    }

    /**
     *  returns a 2D array of Strings containing data of possibly infected users traced from a specific case number
     *
     *  @author Roymaxson Li, Steven Castro
     *  @param  caseNum     specific case number to be traced
     *  @return boolean
     */
    public String[][] traceSpecificCase(int caseNum) {
        CaseList cases = new CaseList();
        RecordList records = new RecordList();
        SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");
        ArrayList<Integer> tracerCaseNum = new ArrayList<>();

        // List
        ArrayList<String> possiblyInfectedUsers = new ArrayList<>();
        ArrayList<String> possiblyInfectedCodes = new ArrayList<>();

        // Assigned
        if (cases.getStatus(caseNum) == 'P' && cases.getTracerName(caseNum).equals(getUsername())) {
            // Records of the Case Issuer
            Record caseHolderRecord = records.getUserRecord(cases.getUsername(caseNum));



            // Record Entries of the Case Issuer
            for (int i = 0; i < caseHolderRecord.getNumEntry(); i++) {

                // Number of Users with Records
                for (int j = 0; j < records.getNumRecord(); j++) {
                    Record temp = records.getUserRecord(j);

                    // Check He or She is already Infected
                    if (!(cases.hasReportedCase(temp.getUsername())) && checkFoundPossiblyInfected(temp.getUsername(), possiblyInfectedUsers)) {

                        // Comparing Temp Entries
                        for (int k = 0; k < temp.getNumEntry(); k++) {

                            // Same Establishment Code
                            if (caseHolderRecord.getCodeEntry(i).equalsIgnoreCase(temp.getCodeEntry(k))) {

                                // Same Date
                                String dateTextC = sdf.format(caseHolderRecord.getCalendarEntry(i).getTime());
                                String dateTextT = sdf.format(temp.getCalendarEntry(k).getTime());
                                if (dateTextC.equals(dateTextT)) {

                                    // Around the Same Tim
                                    Date dateC1 = caseHolderRecord.getCalendarEntry(i).getTime();
                                    Date dateT1 = temp.getCalendarEntry(k).getTime();
                                    Date dateC2;
                                    Date dateT2;
                                    Calendar dump;

                                    if (i + 1 < caseHolderRecord.getNumEntry()) {    // Next Entry
                                        dateC2 = caseHolderRecord.getCalendarEntry(i + 1).getTime();
                                    } else {                                         // Next Day
                                        dump = (Calendar) caseHolderRecord.getCalendarEntry(i).clone();
                                        dump.add(Calendar.DAY_OF_YEAR, 1);
                                        dateC2 = dump.getTime();
                                    }

                                    if (k + 1 < temp.getNumEntry()) {               // Next Entry
                                        dateT2 = temp.getCalendarEntry(k + 1).getTime();
                                    } else {
                                        dump = (Calendar) temp.getCalendarEntry(k).clone();
                                        dump.add(Calendar.DAY_OF_YEAR, 1);
                                        dateT2 = dump.getTime();
                                    }

                                    // Same Check In || Temp Check In within Span of Case Check In Time
                                    if ((dateT1.after(dateC1) && dateT1.before(dateC2)) || dateT1.equals(dateC1)) {
                                        possiblyInfectedUsers.add(temp.getUsername());
                                        possiblyInfectedCodes.add(temp.getCodeEntry(k));
                                        break;

                                    // Same Check In / Check out || Temp Check In / Check Out within Span of Case Check In Time
                                    } else if (((dateT2.after(dateC1) && dateT2.before(dateC2)) || dateT2.equals(dateC1))) {
                                        possiblyInfectedUsers.add(temp.getUsername());
                                        possiblyInfectedCodes.add(temp.getCodeEntry(k));
                                        break;

                                    // Case Check In within Span of Temp Check In Time
                                    } else if ((dateC1.after(dateT1) && dateC1.before(dateT2))) {
                                        possiblyInfectedUsers.add(temp.getUsername());
                                        possiblyInfectedCodes.add(temp.getCodeEntry(k));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return null;

        }
        
        String[][] data = new String[possiblyInfectedUsers.size()][2];

        // Create 2D array of Strings containing a list of possibly infected users
        for (int i = 0; i < possiblyInfectedUsers.size(); i++) {
            data[i][0] = possiblyInfectedUsers.get(i);
            data[i][1] = possiblyInfectedCodes.get(i);
        }
        return data;
    }

    /**
     * Sends a notification to a citizen stating that he/she is advised to get tested
     * as he/she may have been in contact with a positive patie
     * @param lists
     */
    public void informCitizens(String[][] lists) {
        NotificationList nfl = new NotificationList();

        // Write onto Notfications.txt
        for (String[] x: lists) {
            if (!(nfl.hasNotification(x[0]))) {
                nfl.addNotification(x[0], x[1]);

            }
        }
    }

    /**
     *  returns true when a username has not yet been marked as possibly infected
     *
     *  @author Steven Castro
     *  @param  username    username
     *  @param  array       array containing usernames of possibly infected users
     *  @return boolean
     */
    private boolean checkFoundPossiblyInfected(String username, ArrayList<String> array) {
        for (String x: array) {
            if (x.equals(username)) {
                return false;
            }
        }
        return true;
    }
}