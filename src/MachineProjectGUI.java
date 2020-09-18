import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;
import java.util.Calendar;

public class MachineProjectGUI {
	// Main Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private Account currentAccount = new Account(); 

	// Swing Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JFrame frame;
	private JTextField textBoxA, textBoxB, textBoxC, textBoxD, textBoxE, textBoxF, textBoxG, textBoxH;
	private JPasswordField passBoxA, passBoxB;
	private JButton buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL; 
	private JLabel errorBoxA, messageBoxA;


	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	 
	public MachineProjectGUI() {
		// Start Program
		//traceSpecificCaseMenu();
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
		buttonA = ComponentFactory.createButton("Login", new LoginEvents());
		buttonB = ComponentFactory.createButton("Create An Account?", new LoginEvents());
		buttonA.setBounds(65, 304, 390, 48);
		buttonB.setBounds(65, 368, 390, 48);

		// Text & Password Fields
		textBoxA = ComponentFactory.createTextField(16);
		passBoxA = ComponentFactory.createPassField(16);
		textBoxA.setBounds(64, 160, 280, 40);
		passBoxA.setBounds(64, 232, 280, 40);

		// Add Components Together
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxA);
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
	 * 	@param 	accountType	desired Account Type to be registered (customer, official, tracer)
	 */
	public void registerMenu(String accountType) {
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
		buttonA = ComponentFactory.createButton("Next", new RegisterEvents(accountType));
		buttonB = ComponentFactory.createButton("Cancel", new RegisterEvents(accountType));
		buttonA.setBounds(65, 376, 179, 48);
		buttonB.setBounds(260, 376, 179, 48);

		// Text & Password Fields
		textBoxA = ComponentFactory.createTextField(16);
		passBoxA = ComponentFactory.createPassField(16);
		passBoxB = ComponentFactory.createPassField(16);
		textBoxA.setBounds(64, 160, 280, 40);
		passBoxA.setBounds(64, 232, 280, 40);
		passBoxB.setBounds(64, 304, 280, 40);

		// Add Components Together
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(confirmLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);
		panel.add(textBoxA);
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
	 * 	@param 	role 		desired Account type to be registered
	 * 	@param 	username 	desired unique username to be registered
	 * 	@param 	password 	desired valid password to be registered
	 */
	public void accountFormMenu(String role, String username, String password) {
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
		textBoxB = ComponentFactory.createTextField(14);
		textBoxC = ComponentFactory.createTextField(14);
		textBoxD = ComponentFactory.createTextField(14);
		textBoxE = ComponentFactory.createTextField(14);
		textBoxF = ComponentFactory.createTextField(14);
		textBoxG = ComponentFactory.createTextField(14);
		textBoxH = ComponentFactory.createTextField(14);
		textBoxB.setBounds(32, 216, 200, 40);
		textBoxC.setBounds(32, 288, 200, 40);
		textBoxD.setBounds(32, 360, 200, 40);
		textBoxE.setBounds(296, 216, 300, 40);
		textBoxF.setBounds(296, 288, 300, 40);
		textBoxG.setBounds(296, 360, 250, 40);
		textBoxH.setBounds(296, 432, 150, 40); 

		// Button Settings
		buttonA = ComponentFactory.createButton("Confirm Register", new AccountFormEvents(role, username, password));
		buttonB = ComponentFactory.createButton("Cancel Registry", new AccountFormEvents(role, username, password));
		buttonA.setBounds(80, 496, 504, 48);
		buttonB.setBounds(80, 560, 504, 48);
		
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
		panel.add(textBoxB);
		panel.add(textBoxC);
		panel.add(textBoxD);
		panel.add(textBoxE);
		panel.add(textBoxF);
		panel.add(textBoxG);
		panel.add(textBoxH);
		panel.add(buttonA);
		panel.add(buttonB);
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

		buttonA = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttonB = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttonC = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttonD = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttonE = ComponentFactory.createButton("Log Out", new CitizenEvents());
		buttonA.setBounds(65, 144, 390, 48);
		buttonB.setBounds(65, 216, 390, 48);
		buttonC.setBounds(65, 288, 390, 48);
		buttonD.setBounds(65, 360, 390, 48);
		buttonE.setBounds(65, 432, 390, 48);

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
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(buttonD);
		panel.add(buttonE);

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
		buttonA = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttonB = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttonC = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttonD = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttonF = ComponentFactory.createButton("Show Account Listings", new GovernmentOfficialEvents());
		buttonE = ComponentFactory.createButton("Log Out", new CitizenEvents());

		// Government Offical Methods
		buttonG = ComponentFactory.createButton("Show Unassigned Cases", new GovernmentOfficialEvents());
		buttonH = ComponentFactory.createButton("Show Contact Tracing Updates", new GovernmentOfficialEvents());
		buttonI = ComponentFactory.createButton("Show Analytics", new GovernmentOfficialEvents());
		buttonJ = ComponentFactory.createButton("Create Government Official Account", new GovernmentOfficialEvents());
		buttonK = ComponentFactory.createButton("Create Contact Tracer Account", new GovernmentOfficialEvents());
		buttonL = ComponentFactory.createButton("Terminate Account", new GovernmentOfficialEvents());

		// Left
		buttonA.setBounds(65, 144, 390, 48);	// Check In
		buttonB.setBounds(65, 216, 390, 48);	// Report Case
		buttonC.setBounds(65, 288, 390, 48);	// Change Profile
		buttonD.setBounds(65, 360, 390, 48);	// Change Password
		buttonF.setBounds(65, 432, 390, 48);	// Account List
		buttonE.setBounds(65, 504, 390, 48);	// Log Out

		// Right
		buttonG.setBounds(585, 144, 390, 48);	// Show Unassigned Cases
		buttonH.setBounds(585, 216, 390, 48);	// Show Contact Tracing Updates
		buttonI.setBounds(585, 288, 390, 48);	// Show Analytics
		buttonJ.setBounds(585, 360, 390, 48);	// Create Government Official
		buttonK.setBounds(585, 432, 390, 48);	// Create Contact Tracer
		buttonL.setBounds(585, 504, 390, 48);	// Terminate Account

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

		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(buttonD);
		panel.add(buttonE);
		panel.add(buttonF);
		panel.add(buttonG);
		panel.add(buttonH);
		panel.add(buttonI);
		panel.add(buttonJ);
		panel.add(buttonK);
		panel.add(buttonL);

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

		buttonA = ComponentFactory.createButton("Check In", new CitizenEvents());
		buttonB = ComponentFactory.createButton("Report Positive Case", new CitizenEvents());
		buttonC = ComponentFactory.createButton("Change Profile Information", new CitizenEvents());
		buttonD = ComponentFactory.createButton("Change Password", new CitizenEvents());
		buttonE = ComponentFactory.createButton("Log Out", new CitizenEvents());

		buttonF = ComponentFactory.createButton("Show Assigned Cases", new ContactTracerEvents());
		buttonG = ComponentFactory.createButton("Trace Specific Case", new ContactTracerEvents());
		buttonA.setBounds(65, 144, 390, 48);
		buttonB.setBounds(65, 216, 390, 48);
		buttonC.setBounds(65, 288, 390, 48);
		buttonD.setBounds(65, 360, 390, 48);
		buttonF.setBounds(65, 432, 390, 48);
		buttonG.setBounds(65, 504, 390, 48);
		buttonE.setBounds(65, 576, 390, 48);

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
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(buttonD);
		panel.add(buttonE);
		panel.add(buttonF);
		panel.add(buttonG);

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
		frame = ComponentFactory.createFrame("Checking In", 520, 280);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(520, 280);

		// Label Settings
		// Labels
		JLabel titleLabel = ComponentFactory.createTitleLabel("Checking In", 32);
		JLabel codeLabel = ComponentFactory.createLabel("Establishment Code", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Text Fields
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 200, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Check In", new CheckInEvents());
		buttonB = ComponentFactory.createButton("Cancel", new CheckInEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);

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
		JLabel codeLabel = ComponentFactory.createLabel("Confirm?", 16);
		titleLabel.setBounds(0, 32, 520, 80);
		codeLabel.setBounds(64, 144, 200, 32);

		// Colored Blocks
		JLabel upperBlock = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 264, 520, 16);

		// Button Settings
		buttonA = ComponentFactory.createButton("Report", new ReportCaseEvents());
		buttonB = ComponentFactory.createButton("Cancel", new ReportCaseEvents());
		buttonA.setBounds(65, 144, 390, 48);
		buttonB.setBounds(65, 208, 390, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);

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
		textBoxB = ComponentFactory.createTextField(14);
		textBoxC = ComponentFactory.createTextField(14);
		textBoxD = ComponentFactory.createTextField(14);
		textBoxE = ComponentFactory.createTextField(14);
		textBoxF = ComponentFactory.createTextField(14);
		textBoxG = ComponentFactory.createTextField(14);
		textBoxH = ComponentFactory.createTextField(14);
		textBoxB.setBounds(32, 216, 200, 40);
		textBoxC.setBounds(32, 288, 200, 40);
		textBoxD.setBounds(32, 360, 200, 40);
		textBoxE.setBounds(296, 216, 300, 40);
		textBoxF.setBounds(296, 288, 300, 40);
		textBoxG.setBounds(296, 360, 250, 40);
		textBoxH.setBounds(296, 432, 150, 40); 

		// Button Settings
		buttonA = ComponentFactory.createButton("Save Changes", new ChangeProfileEvents());
		buttonB = ComponentFactory.createButton("Cancel", new ChangeProfileEvents());
		buttonA.setBounds(80, 496, 504, 48);
		buttonB.setBounds(80, 560, 504, 48);
		
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
		panel.add(textBoxB);
		panel.add(textBoxC);
		panel.add(textBoxD);
		panel.add(textBoxE);
		panel.add(textBoxF);
		panel.add(textBoxG);
		panel.add(textBoxH);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(errorBoxA);
		panel.add(confirmIconLabel);
		panel.add(cancelIconLabel);

		// Set Texts
		// Full Name
		textBoxB.setText(currentAccount.fullName.getFirstName());
		textBoxC.setText(currentAccount.fullName.getMiddleName());
		textBoxD.setText(currentAccount.fullName.getLastName());
		// Addresses
		textBoxE.setText(currentAccount.addresses.getHomeAddress());
		textBoxF.setText(currentAccount.addresses.getOfficeAddress());
		textBoxG.setText(currentAccount.addresses.getEmailAddress());
		textBoxH.setText(currentAccount.addresses.getPhoneNumber());

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
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 200, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Change Password", new ChangePasswordEvents());
		buttonB = ComponentFactory.createButton("Back", new ChangePasswordEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);
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
		buttonA = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttonA.setBounds(65, 424, 390, 48);

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
		panel.add(buttonA);
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
		buttonA = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttonA.setBounds(65, 424, 585, 48);

		// Table Settings
		String[] col = {"Case No.", "Username", "Date", "Tracer", "Status"};
	
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 716, 248);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
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
		buttonA = ComponentFactory.createButton("Display", new showContactTracingUpdatesEvents());
		buttonB = ComponentFactory.createButton("Assign", new showContactTracingUpdatesEvents());
		buttonC = ComponentFactory.createButton("Back", new showContactTracingUpdatesEvents());
		buttonA.setBounds(780, 384, 196, 48);
		buttonB.setBounds(780, 568, 196, 48);
		buttonC.setBounds(552, 568, 196, 48);
		

		// Text Fields
		textBoxA = ComponentFactory.createTextField(16);	
		textBoxB = ComponentFactory.createTextField(16);
		textBoxC = ComponentFactory.createTextField(16);	
		textBoxD = ComponentFactory.createTextField(16);	
		textBoxE = ComponentFactory.createTextField(16);	
		textBoxA.setBounds(780, 176, 196, 40);
		textBoxB.setBounds(780, 248, 196, 40);
		textBoxC.setBounds(780, 320, 196, 40);
		textBoxD.setBounds(780, 504, 116, 40);	
		textBoxE.setBounds(912, 504, 64, 40);

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
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(textBoxA);
		panel.add(textBoxB);
		panel.add(textBoxC);
		panel.add(textBoxD);
		panel.add(textBoxE);
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
		buttonA = ComponentFactory.createButton("Display", new ShowAnalyticEvents());
		buttonB = ComponentFactory.createButton("Clear", new ShowAnalyticEvents());
		buttonC = ComponentFactory.createButton("Back", new ShowAnalyticEvents());
		buttonA.setBounds(260, 360, 200, 48);
		buttonB.setBounds(32, 424, 200, 48);
		buttonC.setBounds(260, 424, 200, 48);

		// Text Fields
		textBoxA = ComponentFactory.createTextField(16);	
		textBoxB = ComponentFactory.createTextField(16);
		textBoxC = ComponentFactory.createTextField(16);
		textBoxA.setBounds(32, 176, 200, 40);
		textBoxB.setBounds(32, 248, 120, 40);
		textBoxC.setBounds(32, 320, 120, 40);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);

		panel.add(cityLabel);
		panel.add(startDateLabel);
		panel.add(endDateLabel);
		panel.add(textBoxA);
		panel.add(textBoxB);
		panel.add(textBoxC);
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
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 200, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Create Official", new CreateTerminateAccountEvents());
		buttonB = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);
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
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 200, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Create Tracer", new CreateTerminateAccountEvents());
		buttonB = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);
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
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 200, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Terminate", new CreateTerminateAccountEvents());
		buttonB = ComponentFactory.createButton("Back", new CreateTerminateAccountEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);
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
		buttonA = ComponentFactory.createButton("Back", new DisplayTableEvents());
		buttonA.setBounds(65, 424, 390, 48);

		// Table Settings
		String[] col = {"Case No.", "Date", "Status"};
	
		JScrollPane table = ComponentFactory.createJTableScrollPane(data, col);
		table.setBounds(32, 144, 456, 248);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
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
		textBoxA = ComponentFactory.createTextField(16);
		textBoxA.setBounds(64, 176, 100, 40);

		// Message 
		messageBoxA = ComponentFactory.createLabel(" ", 14);
		messageBoxA.setBounds(16, 216, 240, 40);

		// Button Settings
		buttonA = ComponentFactory.createButton("Trace Case", new TraceCaseEvents());
		buttonB = ComponentFactory.createButton("Back", new TraceCaseEvents());
		buttonA.setBounds(292, 144, 200, 48);
		buttonB.setBounds(292, 208, 200, 48);

		// Add Components
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(codeLabel);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(textBoxA);
		panel.add(messageBoxA);

		// Display
		frame.setVisible(true);
	}

	// Controller	// Event Handling	// Inner Classess	// ActionListener Classes 	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	// Account Methods ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {						// Login Button	

				// Get currentAccount Text Field Inputs
				String inputUsername = textBoxA.getText().trim();
				String inputPassword = String.valueOf((passBoxA.getPassword())).trim();
				MasterList masters = new MasterList();

				// Search Username in Masters.txt
				if (masters.checkMaster(inputUsername)) {
					if (currentAccount.logIn(inputUsername, inputPassword)) {
						printConsoleMessage("Loading User Information");

						currentAccount.loadUserInfo(inputUsername);

						printConsoleMessage("Fullname: " + currentAccount.fullName);
						printConsoleMessage("Role: " + currentAccount.getRole());
						printConsoleMessage("Online: " + currentAccount.getOnline());

						frame.dispose();

						// Proceed to Role Specific Menus
						returnToAccountMenu();

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
				textBoxA.setText("");
				passBoxA.setText("");

			} else {											// Create An Account Button
				printConsoleMessage("Register Menu GUI");

				frame.dispose();
				registerMenu("customer");
			}
		}
	}

	private class RegisterEvents implements ActionListener {
		private String inputRole;

		public RegisterEvents(String role) {
			inputRole = role;
		}

		@Override
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == buttonA) {				// Next Button (Confirm Username & Password Validity)

				MasterList masters = new MasterList();

				// Get currentAccount Text Field Inputs
				String inputUsername = textBoxA.getText().trim();
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
							accountFormMenu(inputRole, inputUsername, inputPassword);

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
		private String inputRole;
		private String inputUsername;
		private String inputPassword;

		public AccountFormEvents(String role, String username, String password) {
			inputRole = role;
			inputUsername = username;
			inputPassword = password;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean missing = false;
			String[] userInputs = new String[7];
			
			if (e.getSource() == buttonA) {			// Register Button

				// Get Form's Inputs
				userInputs[0] = textBoxB.getText().trim();	// First Name
				userInputs[1] = textBoxC.getText().trim();	// Middle Name
				userInputs[2] = textBoxD.getText().trim();	// Last name
				userInputs[3] = textBoxE.getText().trim();	// Home Address
				userInputs[4] = textBoxF.getText().trim();	// Office Address
				userInputs[5] = textBoxG.getText().trim();	// Phone Address
				userInputs[6] = textBoxH.getText().trim();	// Email Addresse
				
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

					// Register currentAccount
					if (currentAccount.register(inputRole, inputUsername, inputPassword, fullName, addresses)) {
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
			if (e.getSource() == buttonA) {						// Check In Button		
				printConsoleMessage("Check In Menu GUI");
				
				frame.dispose();
				checkInMenu();
			} else if (e.getSource() == buttonB) {				// Report Positive Button
				printConsoleMessage("Report Case Menu GUI");

				frame.dispose();
				reportCaseMenu();
			} else if (e.getSource() == buttonC) {				// Change Profile Information Button
				printConsoleMessage("Change Profile Menu GUI");

				frame.dispose();
				changeProfileMenu();
			} else if (e.getSource() == buttonD) {				// Change Password Button
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
			if (e.getSource() == buttonF) {								// Show Account Listings Button
				printConsoleMessage("Show Account Listings Menu GUI");	

				frame.dispose();
				showAccountListMenu();
			} else if (e.getSource() == buttonG) {						// Show Unassigned Cases Button
				printConsoleMessage("Show Unassigned Menu GUI");

				frame.dispose();
				GovernmentOfficial gv = new GovernmentOfficial();
				gv.copyAccountInfo(currentAccount);

				showUnassignedCasesMenu(gv.showUnassignedCases());
			} else if (e.getSource() == buttonH){						// Show Contact Tracing Updates Button
				GovernmentOfficial gv = new GovernmentOfficial();
				gv.copyAccountInfo(currentAccount);

				frame.dispose();

				// Default Duration
				Calendar startDate = RecordList.buildCalendar("01,01,2000", "0000");
				Calendar endDate = Calendar.getInstance();
				showContactTracingUpdatesMenu(gv.showContactTracingUpdates(startDate, endDate, 'P'));
				messageBoxA.setText("> Displaying Cases from " + "01,01,2000" + " -> Today");

			} else if (e.getSource() == buttonI) {						// Show Analytics
				printConsoleMessage("Show Analytics Menu GUI");

				frame.dispose();
				showAnalyticsMenu();
			} else if (e.getSource() == buttonJ) {						// Create Government Official Account
				printConsoleMessage("Create Government Official Menu GUI");

				frame.dispose();
				createOfficialMenu();
			} else if (e.getSource() == buttonK) {						// Create Contact Tracer Account
				printConsoleMessage("Create Contact Tracer Menu GUI");

				frame.dispose();
				createTracerMenu();
			} else {													// Terminate Account
				printConsoleMessage("Terminate Account Menu GUI");

				frame.dispose();
				terminateAccountMenu();
			} 
		}
	}

	private class ContactTracerEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ContactTracer ct = new ContactTracer();
			ct.copyAccountInfo(currentAccount);

			if (e.getSource() == buttonF) {					// Show Unassigned Cases Button
				frame.dispose();
				showAssignedCases(ct.showCases());


			} else {										// Trace Specific Case Button
				frame.dispose();
				traceSpecificCaseMenu();

			}
		}
	}


	// Citizen Account Options ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class CheckInEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {			// Check In Button
				String code = textBoxA.getText().trim();
				printConsoleMessage("Checking In > " + code);

				// Checking In
				Citizen cz = new Citizen();
				cz.copyAccountInfo(currentAccount);
				cz.checkIn(code);

				frame.dispose();
				returnToAccountMenu();
				messageBoxA.setText("> Checked In - " + code);

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
			if (e.getSource() == buttonA) {			// Report Case Button
				
				// Reporting Case
				Citizen cz = new Citizen();
				cz.copyAccountInfo(currentAccount);
				
				frame.dispose();
				returnToAccountMenu();

				if (cz.reportPositive(Calendar.getInstance())) {
					printConsoleMessage("Reported Case");
					messageBoxA.setText("> Case Reported!");

					// Remove Notification
					NotificationList nfl = new NotificationList();
					nfl.deleteNotification(currentAccount.getUsername());
				} else {
					printConsoleMessage("Reporting Case Failed (Already Reported Before)");
					messageBoxA.setText("> You Already Reported a Case!");
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
			if (e.getSource() == buttonA) {			// Save Changes Button
				// TODO Check currentAccount inptus
				
				printConsoleMessage("Saving New Profile Changes");

				// Set Changes
				currentAccount.fullName = new Name(textBoxB.getText(), textBoxC.getText(), textBoxD.getText());
				currentAccount.addresses.setHomeAddress(textBoxE.getText()); 
				currentAccount.addresses.setOfficeAddress(textBoxF.getText()); 
				currentAccount.addresses.setEmailAddress(textBoxG.getText()); 
				currentAccount.addresses.setPhoneNumber(textBoxH.getText()); 
				
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
			if (e.getSource() == buttonA) {						// Change Password Button
				String password = textBoxA.getText().trim();

				if (currentAccount.changePassword(password)) {
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
			if (e.getSource() == buttonA) {			// Display Button
				GovernmentOfficial gv = new GovernmentOfficial();
				gv.copyAccountInfo(currentAccount);

				int numCases = -1;
				String city = textBoxA.getText().trim();
				String start = textBoxB.getText().trim();
				String end = textBoxC.getText().trim();

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
			} else if (e.getSource() == buttonB) {		// Clear Button
				textBoxA.setText("");
				textBoxB.setText("");
				textBoxC.setText("");

			} else {									// Back Button
				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class CreateTerminateAccountEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {							// Create & Terminate Buttons
				MasterList masters = new MasterList();
				String username = textBoxA.getText().trim();
				errorBoxA.setText("");

				GovernmentOfficial gv = new GovernmentOfficial();
				gv.copyAccountInfo(currentAccount);
				
				// Check Unique Username
				if (username.length() != 0) {
					if (buttonA.getText().equals("Create Official")) {					// Create Offical Button

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

					} else if (buttonA.getText().equals("Create Tracer")) {				// Create Tracer Button

						// Create Contact Tracer by Updating
						if (gv.createContactTracer(username)) {

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
				} else {
					
					// Error Message
					errorBoxA.setText("> No Input!");
				}
			} else {												// Back Buttons		

				frame.dispose();
				returnToAccountMenu();
			}
		}
	}

	private class showContactTracingUpdatesEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {				// Display Button
				String start = textBoxA.getText().trim();
				String end = textBoxB.getText().trim();
				String state = textBoxC.getText().trim();

				Calendar startDate = RecordList.buildCalendar(start, "0000");
				Calendar endDate = RecordList.buildCalendar(end, "0000	");

				if (startDate != null && endDate != null) {
					if (state.length() != 0) {
						switch (state.charAt(0)) {
							case 'P','p','T','t':
								GovernmentOfficial gv = new GovernmentOfficial();
								gv.copyAccountInfo(currentAccount);

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
			} else if (e.getSource() == buttonB) {		// Assign Button
				try {
					int caseNum = Integer.parseInt(textBoxE.getText().trim());
					String tracername = textBoxD.getText().trim();

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
			ContactTracer ct = new ContactTracer();
			ct.copyAccountInfo(currentAccount);

			if (e.getSource() == buttonA) {				// Trace Case
				messageBoxA.setText("");
				try {
					int caseNum = Integer.parseInt(textBoxA.getText().trim());

					String[][] names = ct.traceSpecificCase(caseNum - 1);

					if (names != null) {
						// Dislay on Console
						for (String[] x: names) {
							System.out.println(x[0] + " " + x[1]);
						}

						messageBoxA.setText("> Found " + names.length + " Possibly Infected");
						printConsoleMessage("Found " + names.length + " Possibly Infected");


					} else {
						messageBoxA.setText("> Traced or Not Assgined");
					}
					

				} catch (NumberFormatException ex) { 
					// Error Messages
					if (textBoxA.getText().length() == 0) {
						messageBoxA.setText("> No Input!");	
					} else {
						messageBoxA.setText("> Invalid Input!");	
					}
				} catch (IndexOutOfBoundsException ex) {
					messageBoxA.setText("> Case Num Not Issued!");	
				}

				// Clear Text Field
				textBoxA.setText("");
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
		if(currentAccount.getRole().equals("customer")) {
			printConsoleMessage("Customer Menu GUI");
			customerMenu();

		} else if (currentAccount.getRole().equals("official")) {
			printConsoleMessage("Government Official Menu GUI");
			governmentOfficialMenu();

		} else {
			printConsoleMessage("Contact Tracer Menu GUI");
			contactTracerMenu(); 
		}
	}
}