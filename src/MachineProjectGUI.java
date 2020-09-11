import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MachineProjectGUI {
	// Main Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private Account currentUser = new Account(); 

	// Swing Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JFrame frame;
	private JTextField textBoxA, textBoxB, textBoxC, textBoxD, textBoxE, textBoxF, textBoxG, textBoxH;
	private JPasswordField passBoxA, passBoxB;
	private JButton buttonA, buttonB, buttonC, buttonD, buttonE; 
	private JLabel errorBoxA, messageBoxA;

	// Variables
	private String inputUsername, inputPassword, inputRole;
	

	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	 
	public MachineProjectGUI() {
		loginMenu();
		// checkInMenu();
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	/**
	 * 	Login Menu GUI
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
		buttonA = ComponentFactory.createButton("Next", new RegisterEvents());
		buttonB = ComponentFactory.createButton("Cancel", new RegisterEvents());
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
	 * 	@author Steven Castro
	 */
	public void accountFormMenu() {
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
		buttonA = ComponentFactory.createButton("Confirm Register", new AccountFormEvents());
		buttonB = ComponentFactory.createButton("Cancel Registry", new AccountFormEvents());
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
		messageBoxA = ComponentFactory.createLabel("> Welcome! " + currentUser.fullName, 14);
		messageBoxA.setBounds(65, 112, 390, 32);

		//Icons
		JLabel checkInIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/arrow-up.png");
		JLabel reportCaseIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/alert-triangle.png");
		JLabel changeProfileIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/edit.png");
		JLabel logOutIconLabel = ComponentFactory.createIconLabel(40, 40, "./Icons/log-out.png");
		checkInIconLabel.setBounds(21, 144, 40, 40);
		reportCaseIconLabel.setBounds(21, 216, 40, 40);
		changeProfileIconLabel.setBounds(21, 288, 40, 40);
		logOutIconLabel.setBounds(21, 360, 40, 40);

		// Colored Blocks
		JLabel upperBlock  = ComponentFactory.createColoredBlockLabel();
		JLabel lowerBlock  = ComponentFactory.createColoredBlockLabel();
		upperBlock.setBounds(0, 0, 520, 32);
		lowerBlock.setBounds(0, 504, 520, 16);

		buttonA = ComponentFactory.createButton("Check In", new CustomerEvents());
		buttonB = ComponentFactory.createButton("Report Positive Case", new CustomerEvents());
		buttonC = ComponentFactory.createButton("Change Profile Information", new CustomerEvents());
		buttonD = ComponentFactory.createButton("Log Out", new CustomerEvents());
		buttonA.setBounds(65, 144, 390, 48);
		buttonB.setBounds(65, 216, 390, 48);
		buttonC.setBounds(65, 288, 390, 48);
		buttonD.setBounds(65, 360, 390, 48);

		// Add Compoenents	
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(messageBoxA);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(checkInIconLabel);
		panel.add(reportCaseIconLabel);
		panel.add(changeProfileIconLabel);
		panel.add(logOutIconLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(buttonD);

		// Display
		frame.setVisible(true); 
	}

	/**
	 * 	Check In Menu GUI
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
	 */
	private void reportCaseMenu() {

	}
	
	/**
	 * 	Change Profile Menu GUI
	 * 	@author Steven Castro
	 */
	private void changeProfileMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Change currentUser Profile Information", 616, 640);

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
		textBoxB.setText(currentUser.fullName.getFirstName());
		textBoxC.setText(currentUser.fullName.getMiddleName());
		textBoxD.setText(currentUser.fullName.getLastName());
		// Addresses
		textBoxE.setText(currentUser.addresses.getHomeAddress());
		textBoxF.setText(currentUser.addresses.getOfficeAddress());
		textBoxG.setText(currentUser.addresses.getEmailAddress());
		textBoxH.setText(currentUser.addresses.getPhoneNumber());

		// Display Frame
		frame.setVisible(true);	

	}




	// Event Handling	// Inner Classess	// ActionListener Classes 	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {						// Login Button	

				MasterList masters = new MasterList();

				// Get currentUser Text Field Inputs
				inputUsername = textBoxA.getText().trim();
				inputPassword = String.valueOf((passBoxA.getPassword())).trim();

				if (masters.checkMaster(inputUsername)) {
					if (currentUser.logIn(textBoxA.getText(), String.valueOf(passBoxA.getPassword()))) {
						printConsoleMessage("Loading User Information");

						currentUser.loadUserInfo(textBoxA.getText());

						printConsoleMessage("Fullname: " + currentUser.fullName);
						printConsoleMessage("Role: " + currentUser.getRole());
						printConsoleMessage("Online: " + currentUser.getOnline());

						frame.dispose();

						// Proceed to Role Specific Menus
						if (currentUser.getRole().equals("customer")) {									// Go To Customer Menu
							printConsoleMessage("Heading back to Customer Menu GUI");

							Citizen temp = new Citizen();
							temp.copyAccountInfo(currentUser);
							currentUser = temp;

							customerMenu();

						} else if (currentUser.getRole().equals("official")) {								// Go To Government Official Menu			
							printConsoleMessage("Heading back to Government Official Menu GUI");

						} else {
							printConsoleMessage("Heading back to Contact Tracer Menu GUI");			// Go To Contact Tracer Menu

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
				printConsoleMessage("Heading back to Register Menu GUI");

				frame.dispose();
				inputRole = "customer";
				registerMenu();
			}
		}
	}

	private class RegisterEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == buttonA) {				// Next Button (Confirm Username & Password Validity)

				MasterList masters = new MasterList();

				// Get currentUser Text Field Inputs
				inputUsername = textBoxA.getText().trim();
				inputPassword = String.valueOf(passBoxA.getPassword()).trim();
				String confirmPassword = String.valueOf(passBoxB.getPassword()).trim();

				// Check for currentUser Input & Validity (Unique Username)
				if (!(masters.checkMaster(inputUsername) || inputUsername.isEmpty())) {
					// Check Valid Password
					if (currentUser.validPassword(inputPassword) && !(inputPassword.isEmpty())) {
						// Check Confirmation of Password
						if (inputPassword.equals(confirmPassword)) {
							printConsoleMessage("Registering currentUser > " + inputUsername + " : " + inputPassword);
							printConsoleMessage("Heading to Account Info Forms GUI");

							frame.dispose();
							accountFormMenu();

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
				printConsoleMessage("Heading Back to Login Menu GUI");
				
				clearInputVariables();
				frame.dispose();
				loginMenu();							// Call & Proceed back to Login Menu GUI
			}
		}
	}

	private class AccountFormEvents implements ActionListener {
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
					// Create currentUser Account Variables
					Name fullName = new Name(userInputs[0], userInputs[1], userInputs[2]);
					Address addresses = new Address(userInputs[3], userInputs[4], userInputs[6], userInputs[5]);

					// Register currentUser
					if (currentUser.register(inputRole, inputUsername, inputPassword, fullName, addresses)) {
						printConsoleMessage("Registry Success");
						printConsoleMessage("Heading back to Main Menu GUI");

						frame.dispose();
						clearInputVariables();
						loginMenu();

					} else {
						printConsoleMessage("Registry Failed");

					}
				} else {
					errorBoxA.setText("> Missing Inputs");
					printConsoleMessage("Error > Incomplete Form Inputs");

				}
			} else {								// Cancel Button
				printConsoleMessage("Heading back to Login Menu GUI");

				frame.dispose();
				clearInputVariables();
				loginMenu();
			}
		}
	}

	private class CustomerEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {			// Check In Button		
				printConsoleMessage("> Heading to Check In Menu GUI");
				
				frame.dispose();
				checkInMenu();
			} else if (e.getSource() == buttonB) {	// Report Positive Button
				


			} else if (e.getSource() == buttonC) {	// Change Profile Information Button
				printConsoleMessage("> Heading to Change Profile Menu GUI");
				
				frame.dispose();
				changeProfileMenu();
			} else {								// Log Out Button
				printConsoleMessage("Heading back to Login Menu GUI");

				currentUser.logOut();
				frame.dispose();
				loginMenu();
			}
		}
	}

	// Citizen Methods ::::::::::::::::::::::::::::::::::::::::::::::::::
	private class CheckInEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {			// Check In Button
				String code = textBoxA.getText().trim();
				printConsoleMessage("Checking In > " + code);

				// RecordList records = new RecordList();					//	TODO USE THE CITIZEN METHOD INSTEAD
				// 														//
				// records.addRecordEntry(currentUser.getUsername(), code);
				//currentUser.checkIn(code);	// Doest Work

				printConsoleMessage("Heading back to Customer Menu GUI");
				frame.dispose();
				customerMenu();

			} else {								// Cancel Button
				printConsoleMessage("Checking In Cancelled");

				printConsoleMessage("Heading back to Customer Menu GUI");
				frame.dispose();
				customerMenu();
			}
		}
	}

	private class ReportCaseEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {			// Report Case Button
				
				// RecordList records = new RecordList();					//	TODO USE THE CITIZEN METHOD INSTEAD
				// 														//
				// records.addRecordEntry(currentUser.getUsername(), code);
				//currentUser.checkIn(code);	// Doest Work

			} else {								// Cancel Button
				printConsoleMessage("Checking In Cancelled");

				printConsoleMessage("Heading back to Customer Menu GUI");
				frame.dispose();
				customerMenu();
			}
		}
	}

	private class ChangeProfileEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {			// Save Changes Button
				// TODO Check currentUser inptus
				
				printConsoleMessage("Saving New Profile Changes");

				// Set Changes
				currentUser.fullName = new Name(textBoxB.getText(), textBoxC.getText(), textBoxD.getText());
				currentUser.addresses.setHomeAddress(textBoxE.getText()); 
				currentUser.addresses.setOfficeAddress(textBoxF.getText()); 
				currentUser.addresses.setEmailAddress(textBoxG.getText()); 
				currentUser.addresses.setPhoneNumber(textBoxH.getText()); 
				
				// Save
				currentUser.saveUserInfo(currentUser.getUsername());

				printConsoleMessage("Heading back to Customer Menu GUI");

				frame.dispose();
				customerMenu();
			} else {								// Cancel Button
				printConsoleMessage("Changing Profile Information Cancelled");

				printConsoleMessage("Heading back to Customer Menu GUI");
				frame.dispose();
				customerMenu();
			} 
		}
	}


	



	// Others ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	clear the place holder variables/attributes of this object
	 */
	private void clearInputVariables() {
		inputUsername = null;
		inputPassword = null;
		inputRole = null;
	}

	/**
	 * 	prints a message in the console
	 *  @param message error message
	 */
	private void printConsoleMessage(String message) {
		System.out.println("> " + message);

	}
}