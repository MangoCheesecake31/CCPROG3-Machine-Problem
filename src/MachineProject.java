import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class MachineProject {
	// Main Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private Account currentAccount = new Account(); 

	// Swing Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JFrame frame;
	private JTextField[] textBoxes = new JTextField[8];
	private JButton[] buttons = new JButton[12];

	private JPasswordField passBoxA, passBoxB;
	
	private JLabel errorBoxA, messageBoxA;


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	 
	public MachineProject() {
		// Start Program
		//reportCaseMenu();
		//checkInMenu();
		loginMenu();
	}


	// Views ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	
	/**
	 * 	Login Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void loginMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Login Menu", 520, 480);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 480);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Sign In", 32);
		JLabel usernameLabel = ComponentFactory.createLabel("Username", 16);
		JLabel passwordLabel = ComponentFactory.createLabel("Password", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		usernameLabel.setBounds(64, 128, 112, 32);
		passwordLabel.setBounds(64, 200, 112, 32);

		// Errors
		errorBoxA = ComponentFactory.createLabel("", 14);
		errorBoxA.setBounds(64, 272, 160, 32);

		// Icons
		JLabel registerIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/user-plus.png");
		JLabel loginIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-in.png");
		JLabel userIconLabel = ComponentFactory.createIconLabel(32, 32, "./Icons/user.png");
		JLabel lockIconLabel = ComponentFactory.createIconLabel(32, 32, "./Icons/lock.png");
		userIconLabel.setBounds(32, 164, 32, 32);
		lockIconLabel.setBounds(32, 236, 32, 32);
		loginIconLabel.setBounds(17, 308, 40, 40);
		registerIconLabel.setBounds(17, 372, 40, 40);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel();
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel();
		upperColorLabel.setBounds(0, 0, 520, 32);
		lowerColorLabel.setBounds(0, 464, 520, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Login", new LoginEvents());
		buttons[1] = ComponentFactory.createButton("Create An Account?", new LoginEvents());
		buttons[0].setBounds(65, 304, 390, 48);
		buttons[1].setBounds(65, 368, 390, 48);

		// Text & Password Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		passBoxA = ComponentFactory.createPassField(16);
		textBoxes[0].setBounds(64, 160, 280, 40);
		passBoxA.setBounds(64, 232, 280, 40);

		// Add Components Together
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxes[0]);
		panel.add(passBoxA);
		panel.add(userIconLabel);
		panel.add(lockIconLabel);
		panel.add(registerIconLabel);
		panel.add(loginIconLabel);
		panel.add(errorBoxA);

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Register Menu GUI (Username & Password)
	 * 	
	 * 	@author Steven Castro
	 */
	public void registerMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Registry Menu", 520, 480);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 480);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Sign Up", 32);
		JLabel usernameLabel = ComponentFactory.createLabel("Username: ", 16);
		JLabel passwordLabel = ComponentFactory.createLabel("Password: ", 16);
		JLabel confirmLabel = ComponentFactory.createLabel("Confirm Password: ", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		usernameLabel.setBounds(64, 128, 200, 32);
		passwordLabel.setBounds(64, 200, 200, 32);
		confirmLabel.setBounds(64, 272, 200, 32);

		// Error
		errorBoxA = ComponentFactory.createLabel("", 14);
		errorBoxA.setBounds(64, 344, 300, 32);

		// Icons
		JLabel registerIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/user-plus.png");
		JLabel loginIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-in.png");
		JLabel userIconLabel = ComponentFactory.createIconLabel(32, 32, "./Icons/user.png");
		JLabel lockIconLabel = ComponentFactory.createIconLabel(32, 32, "./Icons/lock.png");
		userIconLabel.setBounds(32, 164, 32, 32);
		lockIconLabel.setBounds(32, 236, 32, 32);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel();
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel();
		upperColorLabel.setBounds(0, 0, 520, 32);
		lowerColorLabel.setBounds(0, 464, 520, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Next", new RegisterEvents());
		buttons[1] = ComponentFactory.createButton("Cancel", new RegisterEvents());
		buttons[0].setBounds(65, 376, 179, 48);
		buttons[1].setBounds(260, 376, 179, 48);

		// Text & Password Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		passBoxA = ComponentFactory.createPassField(16);
		passBoxB = ComponentFactory.createPassField(16);
		textBoxes[0].setBounds(64, 160, 280, 40);
		passBoxA.setBounds(64, 232, 280, 40);
		passBoxB.setBounds(64, 304, 280, 40);

		// Add Components Together
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(confirmLabel);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxes[0]);
		panel.add(passBoxA);
		panel.add(passBoxB);
		panel.add(userIconLabel);
		panel.add(lockIconLabel);
		panel.add(errorBoxA);

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Account Information Form GUI
	 * 	
	 * 	@author Steven Castro
	 * 	@param 	username 	desired unique username to be registered
	 * 	@param 	password 	desired valid password to be registered
	 */
	public void accountFormMenu(String username, String password) {
		// Frame Settings
		frame = ComponentFactory.createFrame("Account Information Form", 616, 640);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(616, 640);
		
		// Label
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account Details", 32);
		JLabel fullNameLabel = ComponentFactory.createLabel("   Full Name ", 24);
		JLabel firstNameLabel = ComponentFactory.createLabel("First Name ", 16);
		JLabel middleNameLabel = ComponentFactory.createLabel("Middle Name ", 16);
		JLabel lastNameLabel = ComponentFactory.createLabel("Last Name ", 16);

		JLabel addressesLabel = ComponentFactory.createLabel("   Addresses ", 24);
		JLabel homeLabel = ComponentFactory.createLabel("Home ", 16);
		JLabel officeLabel = ComponentFactory.createLabel("Office ", 16);
		JLabel emailLabel = ComponentFactory.createLabel("Email ", 16);
		JLabel phoneLabel = ComponentFactory.createLabel("Phone ", 16);
		
		titleLabel.setBounds(0, 32, 616, 80);
		fullNameLabel.setBounds(0, 144, 200, 40);
		firstNameLabel.setBounds(32, 184, 150, 32);
		middleNameLabel.setBounds(32, 256, 150, 32);
		lastNameLabel.setBounds(32, 328, 150, 32);

		addressesLabel.setBounds(264, 144, 200, 40);
		homeLabel.setBounds(296, 184, 150, 32);
		officeLabel.setBounds(296, 256, 150, 32);
		emailLabel.setBounds(296, 328, 150, 32);
		phoneLabel.setBounds(296, 400, 150, 32);

		// Icons
		JLabel confirmIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/check-square.png");
		JLabel cancelIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/x-square.png");
		confirmIconLabel.setBounds(36, 500, 40, 40);
		cancelIconLabel.setBounds(36, 564, 40, 40);

		// Error
		errorBoxA = ComponentFactory.createLabel("", 14);
		errorBoxA.setBounds(32, 400, 200, 32);

		// Colored Blocks 
		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel(); 
		upperColorLabel.setBounds(0, 0, 616, 32);
		lowerColorLabel.setBounds(0, 624, 616, 16);

		// Text Field Settings
		textBoxes[1] = ComponentFactory.createTextField(14);
		textBoxes[2] = ComponentFactory.createTextField(14);
		textBoxes[3] = ComponentFactory.createTextField(14);
		textBoxes[4] = ComponentFactory.createTextField(14);
		textBoxes[5] = ComponentFactory.createTextField(14);
		textBoxes[6] = ComponentFactory.createTextField(14);
		textBoxes[7] = ComponentFactory.createTextField(14);
		textBoxes[1].setBounds(32, 216, 200, 40);
		textBoxes[2].setBounds(32, 288, 200, 40);
		textBoxes[3].setBounds(32, 360, 200, 40);
		textBoxes[4].setBounds(296, 216, 300, 40);
		textBoxes[5].setBounds(296, 288, 300, 40);
		textBoxes[6].setBounds(296, 360, 250, 40);
		textBoxes[7].setBounds(296, 432, 150, 40); 

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Confirm Register", new AccountFormEvents(username, password));
		buttons[1] = ComponentFactory.createButton("Cancel Registry", new AccountFormEvents(username, password));
		buttons[0].setBounds(80, 496, 504, 48);
		buttons[1].setBounds(80, 560, 504, 48);
		
		// Add Componenets
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(fullNameLabel);
		panel.add(firstNameLabel);
		panel.add(middleNameLabel);
		panel.add(lastNameLabel);
		panel.add(addressesLabel);
		panel.add(homeLabel);
		panel.add(officeLabel);
		panel.add(emailLabel);
		panel.add(phoneLabel);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxes[1]);
		panel.add(textBoxes[2]);
		panel.add(textBoxes[3]);
		panel.add(textBoxes[4]);
		panel.add(textBoxes[5]);
		panel.add(textBoxes[6]);
		panel.add(textBoxes[7]);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(errorBoxA);
		panel.add(confirmIconLabel);
		panel.add(cancelIconLabel);

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Customer Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void customerMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Customer Menu", 520, 520);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Customer Account Menu", 32);
		titleLabel.setBounds(0, 32, 520, 80);

		// Console/Message
		messageBoxA = ComponentFactory.createLabel("> Welcome! " + currentAccount.fullName, 14);
		messageBoxA.setBounds(65, 112, 390, 32);

		//Icons
		JLabel checkInIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/arrow-up.png");
		JLabel reportCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/alert-triangle.png");
		JLabel changeProfileIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/edit.png");
		JLabel changePasswordIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/lock.png");
		JLabel logOutIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-out.png");
		checkInIconLabel.setBounds(21, 144, 40, 40);
		reportCaseIconLabel.setBounds(21, 216, 40, 40);
		changeProfileIconLabel.setBounds(21, 288, 40, 40);
		changePasswordIconLabel.setBounds(21, 360, 40, 40);
		logOutIconLabel.setBounds(21, 432, 40, 40);

		// Colored Blocks
		JLabel upperBlock  = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock  = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 504, 520, 16);

		buttons[0] = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttons[1] = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttons[2] = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttons[3] = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttons[4] = ComponentFactory.createButton("Log Out", new CitizenEvents());
		buttons[0].setBounds(65, 144, 390, 48);
		buttons[1].setBounds(65, 216, 390, 48);
		buttons[2].setBounds(65, 288, 390, 48);
		buttons[3].setBounds(65, 360, 390, 48);
		buttons[4].setBounds(65, 432, 390, 48);

		// Add Compoenents	
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(messageBoxA);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(checkInIconLabel);
		panel.add(reportCaseIconLabel);
		panel.add(changeProfileIconLabel);
		panel.add(changePasswordIconLabel);
		panel.add(logOutIconLabel);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(buttons[3]);
		panel.add(buttons[4]);

		// Display
		frame.setVisible(true); 
	}

	/**
	 * 	Government Official Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void governmentOfficialMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Government Menu", 1040, 600);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(1040, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Government Official Account Menu", 32);
		titleLabel.setBounds(0, 32, 1040, 80);

		// Console / Message 
		messageBoxA = ComponentFactory.createLabel("> Welcome! " + currentAccount.fullName, 14);
		messageBoxA.setBounds(65, 112, 780, 32);

		//Icons
		JLabel checkInIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/arrow-up.png");
		JLabel reportCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/alert-triangle.png");
		JLabel changeProfileIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/edit.png");
		JLabel changePasswordIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/lock.png");
		JLabel showListIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/list.png");
		JLabel logOutIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-out.png");

		JLabel showCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/file-text.png");
		JLabel showUpdateIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/bell.png");
		JLabel analyticIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/activity.png");
		JLabel createOfficialIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/user-plus.png");
		JLabel createTracerIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/user-plus.png");
		JLabel terminateIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/user-minus.png");

		checkInIconLabel.setBounds(21, 144, 40, 40);
		reportCaseIconLabel.setBounds(21, 216, 40, 40);
		changeProfileIconLabel.setBounds(21, 288, 40, 40);
		changePasswordIconLabel.setBounds(21, 360, 40, 40);
		showListIconLabel.setBounds(21, 432, 40, 40);
		logOutIconLabel.setBounds(21, 504, 40, 40);

		showCaseIconLabel.setBounds(541, 144, 40, 40);
		showUpdateIconLabel.setBounds(541, 216, 40, 40);
		analyticIconLabel.setBounds(541, 288, 40, 40);
		createOfficialIconLabel.setBounds(541, 360, 40, 40);
		createTracerIconLabel.setBounds(541, 432, 40, 40);
		terminateIconLabel.setBounds(541, 504, 40, 40);

		// Colored Blocks
		JLabel upperBlock  = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock  = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 1040, 32);
		lowerBlock.setBounds(0, 584, 1040, 16);

		// Citizen & Account Methods
		buttons[0] = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttons[1] = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttons[2] = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttons[3] = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttons[5] = ComponentFactory.createButton("Show Account Listings", new GovernmentOfficialEvents());
		buttons[4] = ComponentFactory.createButton("Log Out", new CitizenEvents());

		// Government Offical Methods
		buttons[6] = ComponentFactory.createButton("Show Unassigned Cases", new GovernmentOfficialEvents());
		buttons[7] = ComponentFactory.createButton("Show Contact Tracing Updates", new GovernmentOfficialEvents());
		buttons[8] = ComponentFactory.createButton("Show Analytics", new GovernmentOfficialEvents());
		buttons[9] = ComponentFactory.createButton("Create Government Official Account", new GovernmentOfficialEvents());
		buttons[10] = ComponentFactory.createButton("Create Contact Tracer Account", new GovernmentOfficialEvents());
		buttons[11] = ComponentFactory.createButton("Terminate Account", new GovernmentOfficialEvents());

		// Left
		buttons[0].setBounds(65, 144, 390, 48);	// Check In
		buttons[1].setBounds(65, 216, 390, 48);	// Report Case
		buttons[2].setBounds(65, 288, 390, 48);	// Change Profile
		buttons[3].setBounds(65, 360, 390, 48);	// Change Password
		buttons[5].setBounds(65, 432, 390, 48);	// Account List
		buttons[4].setBounds(65, 504, 390, 48);	// Log Out

		// Right
		buttons[6].setBounds(585, 144, 390, 48);	// Show Unassigned Cases
		buttons[7].setBounds(585, 216, 390, 48);	// Show Contact Tracing Updates
		buttons[8].setBounds(585, 288, 390, 48);	// Show Analytics
		buttons[9].setBounds(585, 360, 390, 48);	// Create Government Official
		buttons[10].setBounds(585, 432, 390, 48);	// Create Contact Tracer
		buttons[11].setBounds(585, 504, 390, 48);	// Terminate Account

		// Add Compoenents	
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(messageBoxA);
		panel.add(upperBlock);
		panel.add(lowerBlock);

		panel.add(checkInIconLabel);
		panel.add(reportCaseIconLabel);
		panel.add(changeProfileIconLabel);
		panel.add(changePasswordIconLabel);
		panel.add(showListIconLabel);
		panel.add(logOutIconLabel);

		panel.add(showCaseIconLabel);
		panel.add(showUpdateIconLabel);
		panel.add(analyticIconLabel);
		panel.add(createOfficialIconLabel);
		panel.add(createTracerIconLabel);
		panel.add(terminateIconLabel);

		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(buttons[3]);
		panel.add(buttons[4]);
		panel.add(buttons[5]);
		panel.add(buttons[6]);
		panel.add(buttons[7]);
		panel.add(buttons[8]);
		panel.add(buttons[9]);
		panel.add(buttons[10]);
		panel.add(buttons[11]);

		// Display
		frame.setVisible(true); 
	}

	/**
	 * 	Contact Tracer Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void contactTracerMenu() {
	 	// Frame Settings
		frame = ComponentFactory.createFrame("Contact Tracer Menu", 520, 656);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 656);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Contact Tracer Account Menu", 32);
		titleLabel.setBounds(0, 32, 520, 80);

		// Console/Message
		messageBoxA = ComponentFactory.createLabel("> Welcome! " + currentAccount.fullName, 14);
		messageBoxA.setBounds(65, 112, 390, 32);

		//Icons
		JLabel checkInIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/arrow-up.png");
		JLabel reportCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/alert-triangle.png");
		JLabel changeProfileIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/edit.png");
		JLabel changePasswordIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/lock.png");
		JLabel logOutIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-out.png");
		JLabel showCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/file-text.png");
		JLabel traceCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/map-pin.png");
		checkInIconLabel.setBounds(21, 144, 40, 40);
		reportCaseIconLabel.setBounds(21, 216, 40, 40);
		changeProfileIconLabel.setBounds(21, 288, 40, 40);
		changePasswordIconLabel.setBounds(21, 360, 40, 40);
		showCaseIconLabel.setBounds(21, 432, 40, 40);
		traceCaseIconLabel.setBounds(21, 504, 40, 40);
		logOutIconLabel.setBounds(21, 576, 40, 40);

		// Colored Blocks
		JLabel upperBlock  = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock  = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 640, 520, 16);

		buttons[0] = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttons[1] = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttons[2] = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttons[3] = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttons[4] = ComponentFactory.createButton("Log Out", new CitizenEvents());

		buttons[5] = ComponentFactory.createButton("Show Assigned Cases", new ContactTracerEvents());
		buttons[6] = ComponentFactory.createButton("Trace Specific Case", new ContactTracerEvents());
		buttons[0].setBounds(65, 144, 390, 48);
		buttons[1].setBounds(65, 216, 390, 48);
		buttons[2].setBounds(65, 288, 390, 48);
		buttons[3].setBounds(65, 360, 390, 48);
		buttons[5].setBounds(65, 432, 390, 48);
		buttons[6].setBounds(65, 504, 390, 48);
		buttons[4].setBounds(65, 576, 390, 48);

		// Add Compoenents	
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(messageBoxA);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(checkInIconLabel);
		panel.add(reportCaseIconLabel);
		panel.add(changeProfileIconLabel);
		panel.add(changePasswordIconLabel);
		panel.add(logOutIconLabel);
		panel.add(showCaseIconLabel);
		panel.add(traceCaseIconLabel);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(buttons[3]);
		panel.add(buttons[4]);
		panel.add(buttons[5]);
		panel.add(buttons[6]);

		// Display
		frame.setVisible(true); 
	}

	/**
	 * 	Check In Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void checkInMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Checking In", 520, 400);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 400);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Checking In", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Establishment Code", 16);
		JLabel dateLabel = ComponentFactory.createLabel("Date (MM,dd,yyyy)", 16);
		JLabel timeLabel = ComponentFactory.createLabel("Time (hhmm)", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);
		dateLabel.setBounds(64, 216, 200, 32);
		timeLabel.setBounds(64, 288, 200, 32);


		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 384, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[1] = ComponentFactory.createTextField(16);
		textBoxes[2] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);
		textBoxes[1].setBounds(64, 248, 200, 40);
		textBoxes[2].setBounds(64, 320, 200, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Check In", new CheckInEvents());
		buttons[1] = ComponentFactory.createButton("Cancel", new CheckInEvents());
		buttons[0].setBounds(292, 176, 200, 48);
		buttons[1].setBounds(292, 248, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(dateLabel);
		panel.add(timeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(textBoxes[1]);
		panel.add(textBoxes[2]);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Report Case Positive GUI
	 *
	 * 	@author Steven Castro
	 */
	private void reportCaseMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Reporting Case", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Report Case Positive", 32);
		JLabel dateLabel = ComponentFactory.createLabel("Date (MM,dd,yyyy)", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		dateLabel.setBounds(64, 144, 200, 32);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 344, 520, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Report", new ReportCaseEvents());
		buttons[1] = ComponentFactory.createButton("Cancel", new ReportCaseEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 216, 200, 48);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(dateLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(textBoxes[0]);
		panel.add(buttons[0]);
		panel.add(buttons[1]);

		// Display
		frame.setVisible(true);
	}
	
	/**
	 * 	Change Profile Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void changeProfileMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Change User Profile Information", 616, 640);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(616, 640);
		
		// Label
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account Information", 32);
		JLabel fullNameLabel = ComponentFactory.createLabel("   Full Name ", 24);
		JLabel firstNameLabel = ComponentFactory.createLabel("First Name ", 16);
		JLabel middleNameLabel = ComponentFactory.createLabel("Middle Name ", 16);
		JLabel lastNameLabel = ComponentFactory.createLabel("Last Name ", 16);

		JLabel addressesLabel = ComponentFactory.createLabel("   Addresses ", 24);
		JLabel homeLabel = ComponentFactory.createLabel("Home ", 16);
		JLabel officeLabel = ComponentFactory.createLabel("Office ", 16);
		JLabel emailLabel = ComponentFactory.createLabel("Email ", 16);
		JLabel phoneLabel = ComponentFactory.createLabel("Phone ", 16);
		
		titleLabel.setBounds(0, 32, 616, 80);
		fullNameLabel.setBounds(0, 144, 200, 40);
		firstNameLabel.setBounds(32, 184, 150, 32);
		middleNameLabel.setBounds(32, 256, 150, 32);
		lastNameLabel.setBounds(32, 328, 150, 32);

		addressesLabel.setBounds(264, 144, 200, 40);
		homeLabel.setBounds(296, 184, 150, 32);
		officeLabel.setBounds(296, 256, 150, 32);
		emailLabel.setBounds(296, 328, 150, 32);
		phoneLabel.setBounds(296, 400, 150, 32);

		// Icons
		JLabel confirmIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/check-square.png");
		JLabel cancelIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/x-square.png");
		confirmIconLabel.setBounds(36, 500, 40, 40);
		cancelIconLabel.setBounds(36, 564, 40, 40);

		// Error
		errorBoxA = ComponentFactory.createLabel("", 14);
		errorBoxA.setBounds(32, 400, 200, 32);

		// Colored Blocks 
		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel(); 
		upperColorLabel.setBounds(0, 0, 616, 32);
		lowerColorLabel.setBounds(0, 624, 616, 16);

		// Text Field Settings
		textBoxes[1] = ComponentFactory.createTextField(14);
		textBoxes[2] = ComponentFactory.createTextField(14);
		textBoxes[3] = ComponentFactory.createTextField(14);
		textBoxes[4] = ComponentFactory.createTextField(14);
		textBoxes[5] = ComponentFactory.createTextField(14);
		textBoxes[6] = ComponentFactory.createTextField(14);
		textBoxes[7] = ComponentFactory.createTextField(14);
		textBoxes[1].setBounds(32, 216, 200, 40);
		textBoxes[2].setBounds(32, 288, 200, 40);
		textBoxes[3].setBounds(32, 360, 200, 40);
		textBoxes[4].setBounds(296, 216, 300, 40);
		textBoxes[5].setBounds(296, 288, 300, 40);
		textBoxes[6].setBounds(296, 360, 250, 40);
		textBoxes[7].setBounds(296, 432, 150, 40); 

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Save Changes", new ChangeProfileEvents());
		buttons[1] = ComponentFactory.createButton("Cancel", new ChangeProfileEvents());
		buttons[0].setBounds(80, 496, 504, 48);
		buttons[1].setBounds(80, 560, 504, 48);
		
		// Add Componenets
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(fullNameLabel);
		panel.add(firstNameLabel);
		panel.add(middleNameLabel);
		panel.add(lastNameLabel);
		panel.add(addressesLabel);
		panel.add(homeLabel);
		panel.add(officeLabel);
		panel.add(emailLabel);
		panel.add(phoneLabel);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxes[1]);
		panel.add(textBoxes[2]);
		panel.add(textBoxes[3]);
		panel.add(textBoxes[4]);
		panel.add(textBoxes[5]);
		panel.add(textBoxes[6]);
		panel.add(textBoxes[7]);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(errorBoxA);
		panel.add(confirmIconLabel);
		panel.add(cancelIconLabel);

		// Set Texts
		// Full Name
		textBoxes[1].setText(currentAccount.fullName.getFirstName());
		textBoxes[2].setText(currentAccount.fullName.getMiddleName());
		textBoxes[3].setText(currentAccount.fullName.getLastName());
		// Addresses
		textBoxes[4].setText(currentAccount.addresses.getHomeAddress());
		textBoxes[5].setText(currentAccount.addresses.getOfficeAddress());
		textBoxes[6].setText(currentAccount.addresses.getEmailAddress());
		textBoxes[7].setText(currentAccount.addresses.getPhoneNumber());

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Change Password Menu GUI
	 * 	
	 * 	@author Steven Castro
	 */
	private void changePasswordMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Changing Password Account", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Change Password", 32);
		JLabel codeLabel = ComponentFactory.createLabel("New Password", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Message
		errorBoxA = ComponentFactory.createLabel("", 12);
		errorBoxA.setBounds(32, 216, 240, 48);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Change Password", new ChangePasswordEvents());
		buttons[1] = ComponentFactory.createButton("Back", new ChangePasswordEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(errorBoxA);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Display Account List GUI
	 *
	 * 	@author Steven Castro
	 */
	private void showAccountListMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Account List", 520, 520);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account List", 32);
		titleLabel.setBounds(0, 32, 520, 80);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel(); 
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 504, 520, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttons[0].setBounds(65, 424, 390, 48);

		// Table Settings
		String[] col = {"Username", "Role"};
		
		MasterList masters = new MasterList();
		String[][] data = new String[masters.getNumAcc()][2];

		// Obtain Table Data
		for (int i = 0; i < masters.getNumAcc(); i++) {
			data[i][0] = masters.getMasterUsername(i);
			data[i][1] = masters.getMasterRole(masters.getMasterUsername(i));
		}
		 
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 456, 248);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(table);
		
		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Display Unassigned Cases GUI
	 * 	
	 *  @author Steven Castro
	 *  @param 	data 	two dimensional array of strings containing table data  
	 */
	private void showUnassignedCasesMenu(String[][] data) {
		// Frame Settings
		frame = ComponentFactory.createFrame("Unassigned Cases", 780, 520);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(780, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Unassigned Cases", 32);
		titleLabel.setBounds(0, 32, 780, 80);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel(); 
		upperBlock.setBounds(0, 0, 780, 32);
		lowerBlock.setBounds(0, 504, 780, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttons[0].setBounds(65, 424, 585, 48);

		// Table Settings
		String[] col = {"Case No.", "Username", "Date", "Tracer", "Status"};
	
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 716, 248);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(table);
		
		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Display Contact Tracing Updates GUI
	 *
	 * 	@author Steven Castro
	 */
	private void showContactTracingUpdatesMenu(String[][] data) {
		// Frame Settings
		frame = ComponentFactory.createFrame("Show Contact Tracng Updates", 1040, 680);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(1040, 680);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Contact Tracing Updates", 32);
		JLabel startDateLabel = ComponentFactory.createLabel("Start Date (MM,dd,yyyy)", 16);
		JLabel endDateLabel = ComponentFactory.createLabel("End Date (MM,dd,yyyy)", 16);
		JLabel statusLabel = ComponentFactory.createLabel("Status (P or T)", 16);
		JLabel tracerLabel = ComponentFactory.createLabel("Tracer", 16);
		JLabel caseNumLabel = ComponentFactory.createLabel("Case No.", 16);
		titleLabel.setBounds(0, 32, 1040, 80);
		startDateLabel.setBounds(780, 144, 336, 32);
		endDateLabel.setBounds(780, 216, 336, 32);
		statusLabel.setBounds(780, 288, 116, 32);
		tracerLabel.setBounds(780, 464, 120, 40);
		caseNumLabel.setBounds(912, 464, 120, 40);	
		
		// Message Box
		messageBoxA = ComponentFactory.createLabel("", 16);
		messageBoxA.setBounds(32, 568, 488	, 48);	

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel(); 
		upperBlock.setBounds(0, 0, 1040, 32);
		lowerBlock.setBounds(0, 664, 1040, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Display", new showContactTracingUpdatesEvents());
		buttons[1] = ComponentFactory.createButton("Assign", new showContactTracingUpdatesEvents());
		buttons[2] = ComponentFactory.createButton("Back", new showContactTracingUpdatesEvents());
		buttons[0].setBounds(780, 384, 196, 48);
		buttons[1].setBounds(780, 568, 196, 48);
		buttons[2].setBounds(552, 568, 196, 48);
		

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);	
		textBoxes[1] = ComponentFactory.createTextField(16);
		textBoxes[2] = ComponentFactory.createTextField(16);	
		textBoxes[3] = ComponentFactory.createTextField(16);	
		textBoxes[4] = ComponentFactory.createTextField(16);	
		textBoxes[0].setBounds(780, 176, 196, 40);
		textBoxes[1].setBounds(780, 248, 196, 40);
		textBoxes[2].setBounds(780, 320, 196, 40);
		textBoxes[3].setBounds(780, 504, 116, 40);	
		textBoxes[4].setBounds(912, 504, 64, 40);

		// Table Settings
		String[] col = {"Case No.", "Username", "Date", "Tracer", "Status"};
	
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 716, 400);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(startDateLabel);
		panel.add(endDateLabel);
		panel.add(statusLabel);
		panel.add(tracerLabel);
		panel.add(caseNumLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(textBoxes[0]);
		panel.add(textBoxes[1]);
		panel.add(textBoxes[2]);
		panel.add(textBoxes[3]);
		panel.add(textBoxes[4]);
		panel.add(table);
		panel.add(messageBoxA);
		
		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Display Analytics GUI
	 *
	 * 	@author Steven Castro
	 */
	private void showAnalyticsMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Analytics", 520, 520);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Analytics", 32);
		JLabel cityLabel = ComponentFactory.createLabel("City", 16);
		JLabel startDateLabel = ComponentFactory.createLabel("Start Date", 16);
		JLabel endDateLabel = ComponentFactory.createLabel("End Date", 16);

		titleLabel.setBounds(0, 32, 520, 80);
		cityLabel.setBounds(32, 146, 200, 32);
		startDateLabel.setBounds(32, 218, 200, 32);
		endDateLabel.setBounds(32, 290, 200, 32);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel(); 
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 504, 520, 16);

		// Message & Error
		messageBoxA = ComponentFactory.createTitleLabel("0", 64);
		errorBoxA = ComponentFactory.createLabel("", 16);
		messageBoxA.setBounds(260, 146, 200, 200);
		errorBoxA.setBounds(32, 352, 250, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Display", new ShowAnalyticEvents());
		buttons[1] = ComponentFactory.createButton("Clear", new ShowAnalyticEvents());
		buttons[2] = ComponentFactory.createButton("Back", new ShowAnalyticEvents());
		buttons[0].setBounds(260, 360, 200, 48);
		buttons[1].setBounds(32, 424, 200, 48);
		buttons[2].setBounds(260, 424, 200, 48);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);	
		textBoxes[1] = ComponentFactory.createTextField(16);
		textBoxes[2] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(32, 176, 200, 40);
		textBoxes[1].setBounds(32, 248, 120, 40);
		textBoxes[2].setBounds(32, 320, 120, 40);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);

		panel.add(cityLabel);
		panel.add(startDateLabel);
		panel.add(endDateLabel);
		panel.add(textBoxes[0]);
		panel.add(textBoxes[1]);
		panel.add(textBoxes[2]);
		panel.add(messageBoxA);
		panel.add(errorBoxA);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Create Government Official Account GUI
	 *
	 * 	@author Steven Castro
	 */
	private void createOfficialMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Creating Government Official Account", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account Creation", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Username", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Message
		errorBoxA = ComponentFactory.createLabel("", 12);
		errorBoxA.setBounds(32, 216, 240, 48);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Create Official", new CreateTerminateAccountEvents());
		buttons[1] = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(errorBoxA);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Create Contact Tracer Account GUI
	 *
	 * 	@author Steven Castro
	 */
	private void createTracerMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Creating Contact Tracer Account", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account Creation", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Username", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Message
		errorBoxA = ComponentFactory.createLabel("", 12);
		errorBoxA.setBounds(32, 216, 240, 48);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Create Tracer", new CreateTerminateAccountEvents());
		buttons[1] = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(errorBoxA);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Terminate Account GUI
	 *
	 * 	@author Steven Castro
	 */
	private void terminateAccountMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Terminating Account", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Terminate Account", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Username", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Message
		errorBoxA = ComponentFactory.createLabel("", 12);
		errorBoxA.setBounds(32, 216, 240, 48);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 200, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Terminate", new CreateTerminateAccountEvents());
		buttons[1] = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(errorBoxA);

		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Show Assgined Cases Menu GUI
	 *
	 * 	@author Steven Castro
	 */
	private void showAssignedCases(String[][] data) {
		// Frame Settings
		frame = ComponentFactory.createFrame("Show Assigned Cases", 520, 520);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 520);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Assigned Cases", 32);
		titleLabel.setBounds(0, 32, 520, 80);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel(); 
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 504, 520, 16);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttons[0].setBounds(65, 424, 390, 48);

		// Table Settings
		String[] col = {"Case No.", "Date", "Status"};
	
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 456, 248);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(table);
		
		// Display
		frame.setVisible(true);
	}

	/**
	 * 	Trace Spefic Cases Menu GUI
	 *
	 *  @author Steven Castro
	 */
	private void traceSpecificCaseMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Tracing Specific Case", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Trace Specific Case", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Assigned Case Number", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxes[0] = ComponentFactory.createTextField(16);
		textBoxes[0].setBounds(64, 176, 100, 40);

		// Message 
		messageBoxA = ComponentFactory.createLabel(" ", 14);
		messageBoxA.setBounds(16, 216, 240, 40);

		// Button Settings
		buttons[0] = ComponentFactory.createButton("Trace Case", new TraceCaseEvents());
		buttons[1] = ComponentFactory.createButton("Back", new TraceCaseEvents());
		buttons[0].setBounds(292, 144, 200, 48);
		buttons[1].setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(textBoxes[0]);
		panel.add(messageBoxA);

		// Display
		frame.setVisible(true);
	}

	// Controller	// Event Handling	// Inner Classess	// ActionListener Classes 	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Account Methods ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {						// Login Button	

				// Get currentAccount Text Field Inputs
				String inputUsername = textBoxes[0].getText().trim();
				String inputPassword = String.valueOf((passBoxA.getPassword())).trim();
				MasterList masters = new MasterList();

				// Search Username in Masters.txt
				if (masters.checkMaster(inputUsername)) {

					// Log In Account
					currentAccount = Account.logIn(inputUsername, inputPassword);

					if (currentAccount != null) {
						printConsoleMessage("Loading User Information");

						currentAccount.loadUserInfo(inputUsername);
						printConsoleMessage("Fullname: " + currentAccount.fullName);
						printConsoleMessage("Role:     " + currentAccount.getRole());
						printConsoleMessage("Online:   " + currentAccount.getOnline());

						// Proceed to Role Specific Menus
						frame.dispose();
						returnToAccountMenu();

						// Notify User If He/She has a Pending Notification
						NotificationList nfl = new NotificationList();
						if (nfl.hasNotification(currentAccount.getUsername())) {
							messageBoxA.setText("> Notice! You Might be Infected from " + nfl.getEstablishmentCode(currentAccount.getUsername()));
						}					
					} else {
						errorBoxA.setText("> Invalid Password!");
						printConsoleMessage("Error > Invalid Password");

					}
				} else {
					errorBoxA.setText("> User Not Found!");
					printConsoleMessage("Error > User Not Found");

				}

				// Clear Text Fields
				textBoxes[0].setText("");
				passBoxA.setText("");

			} else {											// Create An Account Button
				printConsoleMessage("Register Menu GUI");

				frame.dispose();
				registerMenu();
			}
		}
	}

	private class RegisterEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == buttons[0]) {				// Next Button (Confirm Username & Password Validity)

				MasterList masters = new MasterList();

				// Get currentAccount Text Field Inputs
				String inputUsername = textBoxes[0].getText().trim();
				String inputPassword = String.valueOf(passBoxA.getPassword()).trim();
				String confirmPassword = String.valueOf(passBoxB.getPassword()).trim();

				// Check for currentAccount Input & Validity (Unique Username)
				if (!(masters.checkMaster(inputUsername) || inputUsername.isEmpty())) {
					// Check Valid Password
					if (currentAccount.validPassword(inputPassword) && !(inputPassword.isEmpty())) {
						// Check Confirmation of Password
						if (inputPassword.equals(confirmPassword)) {
							printConsoleMessage("Registering currentAccount > " + inputUsername + " : " + inputPassword);
							printConsoleMessage("Account Info Forms GUI");

							frame.dispose();
							accountFormMenu(inputUsername, inputPassword);

						} else {
							// Error Messages
							errorBoxA.setText("> Invalid Confirmation of Password");
							printConsoleMessage("Error > Invalid Confirmation of Password");
						}
					} else {
						// Error Messages
						if (inputPassword.isEmpty()) {
							errorBoxA.setText("> Missing Password Input");
							printConsoleMessage("Error > No Password Input");
						} else {
							errorBoxA.setText("> Invalid Password Format");
							printConsoleMessage("Error > Invalid Password Format");
						}
					}

				} else {
					// Error Messages
					if (inputUsername.isEmpty()) {  
						errorBoxA.setText("> Missing Username Input");
						printConsoleMessage("Error > No Username Input");
					} else {
						errorBoxA.setText("> Username is Already Taken");
					 	printConsoleMessage("Error > Username Input is Taken");
					}
				}

				// Clear Password Text Fields
				passBoxA.setText("");
				passBoxB.setText("");

			} else {									// Cancel Button
				printConsoleMessage("Login Menu GUI");
				
				
				frame.dispose();
				loginMenu();							// Call & Proceed back to Login Menu GUI
			}
		}
	}

	private class AccountFormEvents implements ActionListener {
		private String inputUsername;
		private String inputPassword;

		public AccountFormEvents(String username, String password) {
			inputUsername = username;
			inputPassword = password;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean missing = false;
			String[] userInputs = new String[7];
			
			if (e.getSource() == buttons[0]) {			// Register Button

				// Get Form's Inputs
				userInputs[0] = textBoxes[1].getText().trim();	// First Name
				userInputs[1] = textBoxes[2].getText().trim();	// Middle Name
				userInputs[2] = textBoxes[3].getText().trim();	// Last name
				userInputs[3] = textBoxes[4].getText().trim();	// Home Address
				userInputs[4] = textBoxes[5].getText().trim();	// Office Address
				userInputs[5] = textBoxes[6].getText().trim();	// Phone Address
				userInputs[6] = textBoxes[7].getText().trim();	// Email Addresse
				
				// Check for Missing Inputs
				for (String x: userInputs) {
					if(x.length() == 0) {
						missing = true;
						break;
					}
				}

				// Check if there are Missing Inputs 	
				if (!missing) {
					// Create currentAccount Account Variables
					Name fullName = new Name(userInputs[0], userInputs[1], userInputs[2]);
					Address addresses = new Address(userInputs[3], userInputs[4], userInputs[6], userInputs[5]);

					// Register a Citizen Account (Customer Role)
					if (currentAccount.register("customer", inputUsername, inputPassword, fullName, addresses)) {
						printConsoleMessage("Registry Success");
						printConsoleMessage("Main Menu GUI");

						frame.dispose();
						loginMenu();

					} else {
						printConsoleMessage("Registry Failed");

					}
				} else {
					errorBoxA.setText("> Missing Inputs");
					printConsoleMessage("Error > Incomplete Form Inputs");

				}
			} else {								// Cancel Button
				printConsoleMessage("Login Menu GUI");

				frame.dispose();
				loginMenu();
			}
		}
	}


	// Account Type Menus ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class CitizenEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {						// Check In Button		
				printConsoleMessage("Check In Menu GUI");
				
				frame.dispose();
				checkInMenu();
			} else if (e.getSource() == buttons[1]) {				// Report Positive Button
				printConsoleMessage("Report Case Menu GUI");

				frame.dispose();
				reportCaseMenu();
			} else if (e.getSource() == buttons[2]) {				// Change Profile Information Button
				printConsoleMessage("Change Profile Menu GUI");

				frame.dispose();
				changeProfileMenu();
			} else if (e.getSource() == buttons[3]) {				// Change Password Button
				printConsoleMessage("Change Password Menu GUI");

				frame.dispose();
				changePasswordMenu();
			} else {											// Log Out Button
				printConsoleMessage("Login Menu GUI");

				currentAccount.logOut();
				frame.dispose();
				loginMenu();
			}
		}
	}

	private class GovernmentOfficialEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[5]) {								// Show Account Listings Button
				printConsoleMessage("Displaying Account Listings (gv)");	

				frame.dispose();
				showAccountListMenu();
			} else if (e.getSource() == buttons[6]) {						// Show Unassigned Cases Button
				printConsoleMessage("Displaying Unassigned Cases (gv)");

				frame.dispose();
				GovernmentOfficial gv = (GovernmentOfficial) currentAccount;
				showUnassignedCasesMenu(gv.showUnassignedCases());

			} else if (e.getSource() == buttons[7]){						// Show Contact Tracing Updates Button
				printConsoleMessage("Displaying Contact Tracing Updates (gv)");

				frame.dispose();
				GovernmentOfficial gv = (GovernmentOfficial) currentAccount;

				// Default Duration
				Calendar startDate = RecordList.buildCalendar("01,01,2000", "0000");
				Calendar endDate = Calendar.getInstance();

				showContactTracingUpdatesMenu(gv.showContactTracingUpdates(startDate, endDate, 'P'));
				messageBoxA.setText("> Displaying Cases from " + "01,01,2000" + " -> Today");

			} else if (e.getSource() == buttons[8]) {						// Show Analytics
				printConsoleMessage("Displaying Analytics (gv)");

				frame.dispose();
				showAnalyticsMenu();

			} else if (e.getSource() == buttons[9]) {						// Create Government Official Account
				printConsoleMessage("Creating or Employing Government Official Account");

				frame.dispose();
				createOfficialMenu();

			} else if (e.getSource() == buttons[10]) {						// Create Contact Tracer Account
				printConsoleMessage("Creating or Employing Contact Tracer Account");

				frame.dispose();
				createTracerMenu();

			} else {														// Terminate Account
				printConsoleMessage("Terminating Account");

				frame.dispose();
				terminateAccountMenu();
			} 
		}
	}

	private class ContactTracerEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[5]) {					// Show Unassigned Cases Button
				printConsoleMessage("Displaying Assigned Cases (ct)");
				
				ContactTracer ct = (ContactTracer) currentAccount;
				frame.dispose();

				showAssignedCases(ct.showCases());

			} else {											// Trace Specific Case Button
				printConsoleMessage("Tracing Specific Case (ct)");

				frame.dispose();
				traceSpecificCaseMenu();

			}
		}
	}


	// Citizen Account Options ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class CheckInEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {			// Check In Button
				String code = textBoxes[0].getText().trim();
				String date = textBoxes[1].getText().trim();
				String time = textBoxes[2].getText().trim();
				printConsoleMessage("Checking In > " + code + " " + date + " " + time);

				Calendar checkInDate = RecordList.buildCalendar(date, time);

				frame.dispose();
				returnToAccountMenu();

				// Checking In
				if (checkInDate != null) {
					// Checking In
					Citizen cz = (Citizen) currentAccount;

					cz.checkIn(code, checkInDate);
					messageBoxA.setText("> Checked In - " + code + date + " " + time);
				} else {
					messageBoxA.setText("> Check In Failed! Invalid Inputs");
				}
			} else {								// Cancel Button
				printConsoleMessage("Checking In Canceled");

				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class ReportCaseEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {			// Report Case Button
				String date = textBoxes[0].getText().trim();

				// Reporting Case
				Citizen cz = (Citizen) currentAccount;
				Calendar reportDate = RecordList.buildCalendar(date, "0000");

				frame.dispose();
				returnToAccountMenu();

				if (cz.reportPositive(reportDate)) {
					printConsoleMessage("Reported Case");
					messageBoxA.setText("> Case Reported!");

					// Remove Notification
					NotificationList nfl = new NotificationList();
					nfl.deleteNotification(currentAccount.getUsername());
				} else {
					// Error Messages
					if (reportDate == null) {
						printConsoleMessage("Reporting Case Failed (Invalid Input)");
						messageBoxA.setText("> Invalid Date Input!");
					} else {
						printConsoleMessage("Reporting Case Failed (Already Reported Before)");
						messageBoxA.setText("> You Already Reported a Case!");
					}
				}
			} else {								// Cancel Button
				printConsoleMessage("Reporting Case Canceled");

				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class ChangeProfileEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {			// Save Changes Button
				
				printConsoleMessage("Saving New Profile Changes");

				// Set Changes
				currentAccount.fullName = new Name(textBoxes[1].getText(), textBoxes[2].getText(), textBoxes[3].getText());
				currentAccount.addresses.setHomeAddress(textBoxes[4].getText()); 
				currentAccount.addresses.setOfficeAddress(textBoxes[5].getText()); 
				currentAccount.addresses.setEmailAddress(textBoxes[6].getText()); 
				currentAccount.addresses.setPhoneNumber(textBoxes[7].getText()); 
				
				// Save
				currentAccount.saveUserInfo(currentAccount.getUsername());

				frame.dispose();
				returnToAccountMenu();
			} else {								// Cancel Button
				printConsoleMessage("Changing Profile Information Canceled");

				frame.dispose();
				returnToAccountMenu();
			} 
		}
	}

	private class ChangePasswordEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {						// Change Password Button
				String password = textBoxes[0].getText().trim();

				if (currentAccount.setPassword(password)) {
					currentAccount.saveUserInfo(currentAccount.getUsername());
					errorBoxA.setText("> Password Chnaged!");

				} else {										

					// Error Messages >	
					if (password.length() == 0) {
						errorBoxA.setText("> No Input!");
					} else {
						errorBoxA.setText("> Invalid Password Format!");
					}
				}
			} else {											// Back Button
				frame.dispose();
				returnToAccountMenu();
			}
		}
	}


	// Government Account Options ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class DisplayTableEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		// Back Button

			frame.dispose();
			returnToAccountMenu();
		}
	}

	private class ShowAnalyticEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {			// Display Button
				GovernmentOfficial gv = (GovernmentOfficial) currentAccount;

				int numCases = -1;
				String city = textBoxes[0].getText().trim();
				String start = textBoxes[1].getText().trim();
				String end = textBoxes[2].getText().trim();

				Calendar startDate = RecordList.buildCalendar(start, "0000");
				Calendar endDate = RecordList.buildCalendar(end, "0000");

				errorBoxA.setText("");
				// Get Analytics
				if (startDate == null && endDate == null) {
					if (city.length() == 0) {
						messageBoxA.setText("0");
						errorBoxA.setText("> No Inputs");

					} else if (start.length() == 0 && end.length() == 0) {
						numCases = gv.analytics(city);
						messageBoxA.setText("C" + String.valueOf(numCases));

					} else {
						messageBoxA.setText("E");
						errorBoxA.setText("> Invalid Date Inputs");

					}
				} else {
					if (startDate != null && endDate != null) {
						if (city.length() == 0) {
							numCases = gv.analytics(startDate, endDate);
							messageBoxA.setText("D" + String.valueOf(numCases));
						
						} else {
							numCases = gv.analytics(city, startDate, endDate);
							messageBoxA.setText("CD" + String.valueOf(numCases));

						}
					} else {
						messageBoxA.setText("E");

						if (startDate == null) {
							errorBoxA.setText("> Missing Start Date Input!");
						} else {
							errorBoxA.setText("> Missing End Date Input!");
						}
					}
				}
			} else if (e.getSource() == buttons[1]) {		// Clear Button
				textBoxes[0].setText("");
				textBoxes[1].setText("");
				textBoxes[2].setText("");

			} else {									// Back Button
				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class CreateTerminateAccountEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {							// Create & Terminate Buttons
				MasterList masters = new MasterList();
				String username = textBoxes[0].getText().trim();
				errorBoxA.setText("");

				System.out.println("pre" + currentAccount.fullName + " " + username);
				GovernmentOfficial gv = (GovernmentOfficial) currentAccount;
				
				// Check Unique Username
				if (username.length() != 0) {
					if (buttons[0].getText().equals("Create Official")) {					// Create Offical Button

						// Create Government Official by Updating
					 	if (gv.createGovernmentOfficial(username)) {

					 		// Messages
					 		if (masters.checkMaster(username)) {
					 			errorBoxA.setText("> Username is now a Government Official!");
					 		} else {
					 			errorBoxA.setText("> Account Created! with Initial Password: password123");
					 		}
						} else {
							errorBoxA.setText("> Username Already has This Role!!");
						}

					} else if (buttons[0].getText().equals("Create Tracer")) {				// Create Tracer Button
						System.out.println("pre2" + currentAccount.fullName + " " + username);
						// Create Contact Tracer by Updating
						if (gv.createContactTracer(username)) {
							System.out.println("pre3" + currentAccount.fullName + " " + username);
							// Messages
							if (masters.checkMaster(username)) {
								errorBoxA.setText("> Username is now a Contact Tracer!");
							} else {
								errorBoxA.setText("> Account Created! with Initial Password: password123");
							}
						} else {

							// Error Messages > Updating Own Gov Acc to Contact Tracer || Updating Tracer Acc to Tracer Acc
							if (username.equals(gv.getUsername())) {
								errorBoxA.setText("> You Cannot Update Your Own Role!");
							} else {
								errorBoxA.setText("> Username Already has This Role!");
							}
						}
					} else {

						// Terminate Account 											// Terminate Account Button
						if (gv.terminateAccount(username)) {
							errorBoxA.setText("> Account Terminated!");
						} else {
							errorBoxA.setText("> You Cannot Terminate Yourself");
						}
					}

					System.out.println("post" + currentAccount.fullName + " " + username);
				} else {
					
					// Error Message
					errorBoxA.setText("> No Input!");
				}
			} else {												// Back Buttons		

				System.out.println(currentAccount.fullName);
				System.out.println("Returning Back");
				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class showContactTracingUpdatesEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {				// Display Button
				String start = textBoxes[0].getText().trim();
				String end = textBoxes[1].getText().trim();
				String state = textBoxes[2].getText().trim();

				Calendar startDate = RecordList.buildCalendar(start, "0000");
				Calendar endDate = RecordList.buildCalendar(end, "0000	");

				if (startDate != null && endDate != null) {
					if (state.length() != 0) {
						switch (state.charAt(0)) {
							case 'P','p','T','t':
								GovernmentOfficial gv = (GovernmentOfficial) currentAccount;

								frame.dispose();
								showContactTracingUpdatesMenu(gv.showContactTracingUpdates(startDate, endDate, state.charAt(0)));
								
								messageBoxA.setText("> Displaying Cases from " + start + " -> " + end);

								break;
							default:
								messageBoxA.setText("> Invaid Status Input!");
						}
					} else {
						messageBoxA.setText("> Missing Status Input!");
					}
				} else {
					// Error Message
					if (start.length() == 0 || end.length() == 0) {
						messageBoxA.setText("> Missing Date Input!");
					} else {
						messageBoxA.setText("> Invalid Date Input!");
					}
				}
			} else if (e.getSource() == buttons[1]) {		// Assign Button
				try {
					int caseNum = Integer.parseInt(textBoxes[4].getText().trim());
					String tracername = textBoxes[3].getText().trim();

					MasterList masters = new MasterList();
					CaseList cases = new CaseList();

					if (0 < caseNum && caseNum <= cases.getNumCases()) {
						if (cases.assignTracer(caseNum , tracername)) {
							messageBoxA.setText("> Tracer: " + tracername + " Assigned to Case No. " + caseNum);
					
						} else {
		
							// Error Messages
							if (masters.checkMaster(tracername)) {
								messageBoxA.setText("> Username is Not a Contact Tracer");
							} else {
								messageBoxA.setText("> Username Does Not Exist!");
							}		
						}
					} else {
						messageBoxA.setText("> Invalid Case No.!");
					}
				} catch (NumberFormatException ex) {
					messageBoxA.setText("> Invalid Case No. Input!");
				}
			} else {									// Back Button
				frame.dispose();
				returnToAccountMenu();
			}
		}
	}


	// Contact Tracer Account Options
	private class TraceCaseEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { 	
			ContactTracer ct = (ContactTracer) currentAccount;

			if (e.getSource() == buttons[0]) {				// Trace Case
				messageBoxA.setText("");
				try {
					int caseNum = Integer.parseInt(textBoxes[0].getText().trim());

					String[][] names = ct.traceSpecificCase(caseNum - 1);

					if (names != null) {
						// Dislay on Console
						for (String[] x: names) {
							System.out.println(x[0] + " " + x[1]);
						}

						messageBoxA.setText("> Found " + names.length + " Possibly Infected");
						printConsoleMessage("Found " + names.length + " Possibly Infected");

						ct.informCitizens(names);
						
					} else {
						messageBoxA.setText("> Traced or Not Assgined");
					}
					

				} catch (NumberFormatException ex) { 
					// Error Messages
					if (textBoxes[0].getText().length() == 0) {
						messageBoxA.setText("> No Input!");	
					} else {
						messageBoxA.setText("> Invalid Input!");	
					}
				} catch (IndexOutOfBoundsException ex) {
					messageBoxA.setText("> Case Num Not Issued!");	
				}

				// Clear Text Field
				textBoxes[0].setText("");
			} else {									// Back Button
				frame.dispose();
				returnToAccountMenu();

			}
		}
	}






	// Others ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	prints a message in the console
	 *  @param message console message
	 */
	private void printConsoleMessage(String message) {
		System.out.println("> " + message);

	}

	/**
	 * 	return to respective account menu
	 *
	 * 	@author Steven Castro
	 */
	private void returnToAccountMenu() {
		System.out.println(currentAccount.fullName);
		if (currentAccount.getRole().equals("customer")) {
			printConsoleMessage("Displaying Customer Menu");
			customerMenu();

		} else if (currentAccount.getRole().equals("official")) {
			printConsoleMessage("Displaying Government Official Menu");
			governmentOfficialMenu();

		} else {
			printConsoleMessage("Displaying Contact Tracer Menu");
			contactTracerMenu(); 
		}
	}
}	