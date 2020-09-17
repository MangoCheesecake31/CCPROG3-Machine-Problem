import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ContactTracer extends Citizen {

	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public String[][] showCases(Account user) {
        CaseList cases = new CaseList();
        SimpleDateFormat sdf = new SimpleDateFormat("MM,dd,yyyy");

        int count = 0;
        String[][] temp = new String[cases.getNumCases()][5];

        // Size of Number of Cases
        for (int i = 0; i < cases.getNumCases(); i++) {
            if (cases.getTracerName(i).equals(getUsername()) && cases.getStatus(i) == 'P') {
                temp[count][0] = String.valueOf(i + 1);
                temp[count][1] = cases.getUsername(i);
                temp[count][2] = sdf.format(cases.getReportDate(i).getTime());
                temp[count][3] = cases.getTracerName(i);
                temp[count][4] = String.valueOf(cases.getStatus(i));

                count++;
            }
        }

        // Size of Number of Unassigned Cases
        String[][] data = new String[count][5];
        for (int i = 0; i < count; i ++) {
            data[i][0] = temp[i][0];
            data[i][1] = temp[i][1];
            data[i][2] = temp[i][2];
            data[i][3] = temp[i][3];
            data[i][4] = temp[i][4];
        }
        return data;
    }

    public void traceSpecificCase() {
        CaseList cases = new CaseList();
        ArrayList<Integer> tracerCaseNum = new ArrayList<>();

        for(int i = 0; i < cases.getNumCases(); i++) {
            if(cases.getStatus(i) == 'P') {
                if(cases.getTracerName(i).equals(getUsername())) {
                    tracerCaseNum.add(i);
                } else {
                    // TODO: move for loop so it no repeat
                    for(int j = 0; j < tracerCaseNum.size(); j++) {
                        Calendar tempCal = (Calendar) cases.getReportDate(tracerCaseNum.get(j)).clone();
                        tempCal.add(Calendar.DAY_OF_YEAR, -8);

                        // TODO: add establishment condition
                        if (cases.getReportDate(i).after(tempCal)
                                || cases.getReportDate(i).equals(tempCal)) {
                            System.out.println(cases.getUsername(i));
                        }
                    }
                }
            }
        }
    }

    public void informCitizens() {

    }
}