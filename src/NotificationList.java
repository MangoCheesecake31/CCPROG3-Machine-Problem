import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class NotificationList {
    // Attributes :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private final File FILE;
    private int numNotifications;
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> codes = new ArrayList<>();


    // Constructors :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * Constructs a	default NotficationList object with a file path to Notfications.txt
     *
     * @author Steven Castro
     */
    public NotificationList() {
        this("Notifications.txt");

    }

    /**
     * 	Constructs a	default NotficationList object with a file path to Notfications.txt
     *
     * 	@author Steven Castro
     * 	@param  filename [description]
     */
    public NotificationList(String filename) {
        FILE = new File(filename);
        load();

    }


    // Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    // Getter ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * 	returns the establishment code of where the use is possibly infected given by the parameter username
     *
     *  @param  username 	username of the recipient of a pending notification
     *  @return String
     */
    public String getEstablishmentCode(String username) {

        for (int i = 0; i < numNotifications; i++) {
            if (usernames.get(i).equals(username)) {
                return codes.get(i);
            }
        }
        System.out.println("Username has No Pending Notification!");
        return null;
    }


    // Data Manipulation ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * 	adds a username and an establishment code onto this Object's arrays
     *
     *  @param  username username of the account to be notified
     *  @param  code     the establishment code were he or she was possibly infected
     *  @return boolean
     */
    public boolean addNotification(String username, String code) {

        // Check If It Already has a Pending Notification
        if (!(hasNotification(username))) {
            usernames.add(username);
            codes.add(code);
            numNotifications++;
            save();

            return true;
        }
        return false;
    }

    /**
     * 	removes a pending notification from this Object's arrays
     *
     *  @param  username recipient of the notification to be deleted
     *  @return boolean
     */
    public boolean deleteNotification(String username) {

        for (int i = 0; i < numNotifications; i++) {
            if (username.equals(usernames.get(i))) {
                usernames.remove(i);
                codes.remove(i);
                numNotifications--;
                save();

                return true;
            }
        }
        return false;
    }

    /**
     *  returns true if this given parameter username already has a pending notification
     *
     *  @param  username username to be searched among the arrays
     *  @return boolean
     */
    public boolean hasNotification(String username) {

        for (String x: usernames) {
            if (x.equals(username)) {
                return true;
            }
        }
        return false;
    }


    // File Handling ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * 	Opens the text file and writes the contents of this object's arrays onto it
     */
    private void save() {
        try {
            PrintWriter pw = new PrintWriter(FILE);

            for(int i = 0; i < numNotifications; i++) {
                pw.println(usernames.get(i) + " " + codes.get(i));
            }

            pw.close();
        } catch(IOException e) {
            System.out.println("ERROR: Record List Text File Not Found...");
        }
    }

    /**
     * 	Opens the text file then scan and loads the contents onto this Object's Arrays
     */
    private void load() {
        try {
            Scanner sc = new Scanner(FILE);

            // Read Text File
            while (sc.hasNext()) {
                usernames.add(sc.next());
                codes.add(sc.next());
                numNotifications++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found :(");
        }
    }
}
