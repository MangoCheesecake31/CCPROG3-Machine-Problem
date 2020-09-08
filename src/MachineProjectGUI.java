import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MachineProjectGUI {
	// Main Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private Account user = new Account(); 

	// Swing Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JFrame frame;
	private JTextField textBoxA, textBoxB, textBoxC, textBoxD, textBoxE, textBoxF, textBoxG, textBoxH;
	private JPasswordField passBoxA;
	private JButton buttonA, buttonB, buttonC, buttonD, buttonE; 
	private String inputUsername, inputPassword, inputRole;
	

	// Constructors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	 
	public MachineProjectGUI() {
		mainMenu();
		
	}


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	Main Menu GUI
	 * 	@author Steven Castro
	 */
	public void mainMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Main Menu", 500, 500);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(500, 500);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("Main Menu", 30);
		titleLabel.setBounds(0, 30, 500, 80);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel();
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel();
		upperColorLabel.setBounds(0, 0, 500, 30);
		lowerColorLabel.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = ComponentFactory.createButton("Register", new MainEvents());
		buttonB = ComponentFactory.createButton("Login", new MainEvents()); 
		buttonC = ComponentFactory.createButton("Exit", new MainEvents()); 
		buttonA.setBounds(0, 320, 500, 50);
		buttonB.setBounds(0, 370, 500, 50);
		buttonC.setBounds(0, 420, 500, 50);

		// Add Components Together
		frame.add(panel);
		panel.add(titleLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(upperColorLabel);
		panel.add(lowerColorLabel);

		// Display Frame
		frame.setVisible(true);
	}

	/**
	 * 	Register Menu GUI
	 * 	@author Steven Castro
	 */
	public void registerMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Register Menu", 500, 500);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(500, 500);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("User Registry", 30);
		JLabel usernameLabel = ComponentFactory.createLabel("Username: ", 14);
		JLabel passwordLabel = ComponentFactory.createLabel("Password: ", 14);
		titleLabel.setBounds(0, 30, 500, 80);
		usernameLabel.setBounds(80, 150, 230, 40);
		passwordLabel.setBounds(80, 230, 230, 40);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel();
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel();
		upperColorLabel.setBounds(0, 0, 500, 30);
		lowerColorLabel.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = ComponentFactory.createButton("Register", new RegisterEvents());
		buttonB = ComponentFactory.createButton("Back", new RegisterEvents());
		buttonA.setBounds(0, 420, 250, 50);
		buttonB.setBounds(250, 420, 250, 50);

		// Text & Password Fields
		textBoxA = ComponentFactory.createTextField(14);
		passBoxA = ComponentFactory.createPassField(14);
		textBoxA.setBounds(80, 180, 330, 40);
		passBoxA.setBounds(80, 260, 330, 40);

		// Add Components
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

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Account Information Form GUI
	 * 	@author Steven Castro
	 */
	public void accountInfoMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Account Information Form", 500, 650);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(500, 650);
		
		// Label
		JLabel titleLabel = ComponentFactory.createTitleLabel("Account Details", 30);
		JLabel fullNameLabel = ComponentFactory.createLabel("   Name ", 24);
		JLabel firstNameLabel = ComponentFactory.createLabel("First Name: ", 16);
		JLabel middleNameLabel = ComponentFactory.createLabel("Middle Name: ", 16);
		JLabel lastNameLabel = ComponentFactory.createLabel("Last Name: ", 16);

		JLabel addressesLabel = ComponentFactory.createLabel("   Addresses ", 24);
		JLabel homeLabel = ComponentFactory.createLabel("Home: ", 16);
		JLabel officeLabel = ComponentFactory.createLabel("Office: ", 16);
		JLabel emailLabel = ComponentFactory.createLabel("Email: ", 16);
		JLabel phoneLabel = ComponentFactory.createLabel("Phone: ", 16);
		
		titleLabel.setBounds(0, 30, 500, 80);
		fullNameLabel.setBounds(0, 120, 500, 60);
		firstNameLabel.setBounds(50, 200, 120, 30);
		middleNameLabel.setBounds(50, 240, 120, 30);
		lastNameLabel.setBounds(50, 280, 120, 30);

		addressesLabel.setBounds(0, 320, 500, 60);
		homeLabel.setBounds(50, 400, 120, 30);
		officeLabel.setBounds(50, 440, 120, 30);
		emailLabel.setBounds(50, 480, 120, 30);
		phoneLabel.setBounds(50, 520, 120, 30);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel(); 
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel(); 
		upperColorLabel.setBounds(0, 0, 500, 30);
		lowerColorLabel.setBounds(0, 620, 500, 30);

		// Text Field Settings
		textBoxB = ComponentFactory.createTextField(14);
		textBoxC = ComponentFactory.createTextField(14);
		textBoxD = ComponentFactory.createTextField(14);
		textBoxE = ComponentFactory.createTextField(14);
		textBoxF = ComponentFactory.createTextField(14);
		textBoxG = ComponentFactory.createTextField(14);
		textBoxH = ComponentFactory.createTextField(14);
		textBoxB.setBounds(200, 200, 270, 30);
		textBoxC.setBounds(200, 240, 270, 30);
		textBoxD.setBounds(200, 280, 270, 30);
		textBoxE.setBounds(200, 400, 270, 30);
		textBoxF.setBounds(200, 440, 270, 30);
		textBoxG.setBounds(200, 480, 270, 30);
		textBoxH.setBounds(200, 520, 270, 30);

		// Button Settings
		buttonA = ComponentFactory.createButton("Register", new AccountInfoEvents());
		buttonB = ComponentFactory.createButton("Cancel", new AccountInfoEvents());
		buttonA.setBounds(0, 570, 250, 50);
		buttonB.setBounds(250, 570, 250, 50);
		
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

		// Display Frame
		frame.setVisible(true);	
	}

	/**
	 * 	Login Menu GUI
	 * 	@author Steven Castro
	 */
	private void loginMenu() {
		// Frame Settings
		frame = ComponentFactory.createFrame("Login Menu", 500, 500);

		// Panel Settings
		JPanel panel = ComponentFactory.createPanel(500, 500);

		// Label Settings
		JLabel titleLabel = ComponentFactory.createTitleLabel("User Login", 30);
		JLabel usernameLabel = ComponentFactory.createLabel("Username: ", 14);
		JLabel passwordLabel = ComponentFactory.createLabel("Password: ", 14);
		titleLabel.setBounds(0, 30, 500, 80);
		usernameLabel.setBounds(80, 150, 230, 40);
		passwordLabel.setBounds(80, 230, 230, 40);

		JLabel upperColorLabel = ComponentFactory.createColoredBlockLabel();
		JLabel lowerColorLabel = ComponentFactory.createColoredBlockLabel();
		upperColorLabel.setBounds(0, 0, 500, 30);
		lowerColorLabel.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = ComponentFactory.createButton("Login", new LoginEvents());
		buttonB = ComponentFactory.createButton("Back", new LoginEvents());
		buttonA.setBounds(0, 420, 250, 50);
		buttonB.setBounds(250, 420, 250, 50);

		// Text & Password Fields
		textBoxA = ComponentFactory.createTextField(14);
		passBoxA = ComponentFactory.createPassField(14);
		textBoxA.setBounds(80, 180, 330, 40);
		passBoxA.setBounds(80, 260, 330, 40);

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

		// Display Frame
		frame.setVisible(true);	
	}

	// Event Handling	// Inner Classess	// ActionListener Classes 	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private class MainEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {				// Register Button
				printConsoleMessage("Register Button Pressed");
				printConsoleMessage("Heading to Register GUI");

				frame.dispose();						
				inputRole = "customer";
				registerMenu();							// Call & Proceed to Register GUI

			} else if (e.getSource() == buttonB) {		// Login Button
				printConsoleMessage("Login Button Pressed");
				printConsoleMessage("Heading to Login GUI");

				frame.dispose();
				loginMenu();							// Call & Proceed to Login GUI

			} else {									// Exit Button
				printConsoleMessage("Exit Button Pressed");
				printConsoleMessage("Program Terminated");

				frame.dispose();
				System.exit(0);							// Terminate Program

			}
		}
	}

	private class RegisterEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == buttonA) {				// Register Button (Confirm Username & Password Validity)
				printConsoleMessage("Register Button Pressed");

				MasterList masters = new MasterList();

				// Get Text Field Inputs
				inputUsername = textBoxA.getText();
				inputPassword = String.valueOf(passBoxA.getPassword());

				// Check Unique Username
				if (!(masters.checkMaster(inputUsername)) && inputUsername.length() > 0) {

					// Check Valid Password
					if (user.validPassword(inputPassword)) {
						printConsoleMessage("Registering User > " + inputUsername + " : " + inputPassword);
						printConsoleMessage("Heading to Account Info Forms GUI");

						frame.dispose();
						accountInfoMenu();

					} else {
						// Error Messages
						if (inputPassword.length() == 0) {
							printConsoleMessage("Error > No Password Input");
						} else {
							printConsoleMessage("Error > Invalid Password Format");
						}
					}

				} else {
					// Error Messages
					if (inputUsername.length() == 0) {  
						printConsoleMessage("Error > No Username Input");
					} else {
					 	printConsoleMessage("Error > Username Input is Taken");
					}
				}

				// Clear Text Fields
				textBoxA.setText("");
				passBoxA.setText("");

			} else {									// Cancel Button
				printConsoleMessage("Cancel Button Pressed");
				printConsoleMessage("Heading Back to Main Menu GUI");
				
				frame.dispose();
				mainMenu();								// Call & Proceed back to Main Menu GUI

			}
		}
	}

	private class AccountInfoEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int i = 1;
			String[] userInputs = new String[7];
			
			if (e.getSource() == buttonA) {			// Register Button
				printConsoleMessage("Register Button Pressed (Forms)");

				// Get Form's Inputs
				userInputs[0] = textBoxB.getText();	// First Name
				userInputs[1] = textBoxC.getText();	// Middle Name
				userInputs[2] = textBoxD.getText();	// Last name
				userInputs[3] = textBoxE.getText();	// Home Address
				userInputs[4] = textBoxF.getText();	// Office Address
				userInputs[5] = textBoxG.getText();	// Phone Address
				userInputs[6] = textBoxH.getText();	// Email Addresse
				
				// Check for Missing Inputs
				for (String x: userInputs) {
					i *= x.length();
				}

				// Check if there are Missing Inputs 	
				if (i != 0) {
					// Create User Variables
					Name fullName = new Name(userInputs[0], userInputs[1], userInputs[2]);
					Address addresses = new Address(userInputs[3], userInputs[4], userInputs[5], userInputs[6]);

					// Register User
					if (user.register(inputRole, inputUsername, inputPassword, fullName, addresses)) {
						printConsoleMessage("Registry Success");
						printConsoleMessage("Heading back to Main Menu GUI");

						frame.dispose();
						clearInputVariables();
						mainMenu();

					} else {
						printConsoleMessage("Registry Failed");

					}
				} else {
					printConsoleMessage("Error > Incomplete Form Inputs");

				}
			} else {								// Cancel Button
				System.out.println("Cancel Button Pressed");
				printConsoleMessage("Heading back to Main Menu GUI");

				frame.dispose();
				clearInputVariables();
				mainMenu();
			}
		}
	}

	private class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {						// Login Button	
				if (user.logIn(textBoxA.getText(), String.valueOf(passBoxA.getPassword()))) {
					printConsoleMessage("Login Button Pressed");
					printConsoleMessage("Loading User Information");

					user.loadUserInfo(textBoxA.getText());

					printConsoleMessage("Fullname: " + user.fullName);
					printConsoleMessage("Role: " + user.getRole());
					printConsoleMessage("Online: " + user.getOnline());
					
				} else {
					printConsoleMessage("Error > Invalid Username or Password");

				}

				// Clear Text Fields
				textBoxA.setText("");
				passBoxA.setText("");

			} else {											// Back Button	
				printConsoleMessage("Back Button Pressed");
				printConsoleMessage("Heading back to Main Menu GUI");

				frame.dispose();
				mainMenu();
			}
		}
	}



	// Others ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * 	clear the place holder attributes of this object
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