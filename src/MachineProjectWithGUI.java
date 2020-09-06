import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MachineProjectWithGUI {
	// Main Attributes
	private static boolean isOnline = false;
	private static Account user = new Account(); 

	// GUI Attrtibutes
	private static JFrame frame;
	private static JTextField usernameTextBox, textBoxB, textBoxC, textBoxD, textBoxE, textBoxF, textBoxG, textBoxH;
	private static JPasswordField passwordTextBox;
	private static JButton buttonA, buttonB, buttonC, buttonD, buttonE; 
	private static String inputUsername, inputPassword, inputRole;

	private static final String DARKGREY = "#181915";
	private static final String LIGHTGREY = "#282923";
	private static final String ORANGE = "#FF9800";
	 
	public static void main(String[] args) {
		mainMenu();

	}

	//
	//	Main Menu
	//
	public static void mainMenu() {
		// Frame Settings
		frameSettings("Main Menu", 500, 500);

		// Panel Settings
		JPanel panel = createPanel(500, 500);

		// Label Settings
		JLabel title = createTitleLabel("Main Menu", LIGHTGREY, 30);
		title.setBounds(0, 30, 500, 80);

		JLabel upperBlock = createColoredBlockLabel(ORANGE);
		JLabel lowerBlock = createColoredBlockLabel(ORANGE);
		upperBlock.setBounds(0, 0, 500, 30);
		lowerBlock.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = createButton("Register", new MainEvents()); 
		buttonB = createButton("Login", new MainEvents()); 
		buttonC = createButton("Exit", new MainEvents()); 
		buttonA.setBounds(0, 320, 500, 50);
		buttonB.setBounds(0, 370, 500, 50);
		buttonC.setBounds(0, 420, 500, 50);

		// Add Components Together
		frame.add(panel);
		panel.add(title);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(upperBlock);
		panel.add(lowerBlock);

		// Display Frame
		frame.setVisible(true);
	}

	// Register Menu
	public static void registerMenu() {
		// Frame Settings
		frameSettings("Register Menu", 500, 500);

		// Panel Settings
		JPanel panel = createPanel(500, 500);

		// Label Settings
		JLabel title = createTitleLabel("User Registry", LIGHTGREY, 30);
		JLabel usernameLabel = createLabel("Username: ", DARKGREY, 14);
		JLabel passwordLabel = createLabel("Password: ", DARKGREY, 14);
		title.setBounds(0, 30, 500, 80);
		usernameLabel.setBounds(80, 150, 230, 40);
		passwordLabel.setBounds(80, 230, 230, 40);

		JLabel upperBlock = createColoredBlockLabel(ORANGE);
		JLabel lowerBlock = createColoredBlockLabel(ORANGE);
		upperBlock.setBounds(0, 0, 500, 30);
		lowerBlock.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = createButton("Register", new RegisterEvents());
		buttonB = createButton("Back", new RegisterEvents());
		buttonA.setBounds(0, 420, 250, 50);
		buttonB.setBounds(250, 420, 250, 50);

		// Text & Password Fields
		usernameTextBox = createTextField(14);
		passwordTextBox = createPassField(14);
		usernameTextBox.setBounds(80, 180, 330, 40);
		passwordTextBox.setBounds(80, 260, 330, 40);

		// Add Components
		frame.add(panel);
		panel.add(title);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(usernameTextBox);
		panel.add(passwordTextBox);

		// Display Frame
		frame.setVisible(true);	
	}

	//
	//	Account Information Fill Up Menu
	//
	public static void accountInfoMenu() {
		// Frame Settings
		frameSettings("Account Information Form", 500, 650);

		// Panel Settings
		JPanel panel = createPanel(500, 650);
		
		// Label
		JLabel title = createTitleLabel("Account Details", LIGHTGREY, 30);
		JLabel fullName = createLabel("   Name ", LIGHTGREY, 24);
		JLabel firstName = createLabel("First Name: ", DARKGREY, 16);
		JLabel middleName = createLabel("Middle Name: ", DARKGREY, 16);
		JLabel lastName = createLabel("Last Name: ", DARKGREY, 16);

		JLabel addresses = createLabel("   Addresses ", LIGHTGREY, 24);
		JLabel home = createLabel("Home: ", DARKGREY, 16);
		JLabel office = createLabel("Office: ", DARKGREY, 16);
		JLabel email = createLabel("Email: ", DARKGREY, 16);
		JLabel phone = createLabel("Phone: ", DARKGREY, 16);
		
		title.setBounds(0, 30, 500, 80);
		fullName.setBounds(0, 120, 500, 60);
		firstName.setBounds(50, 200, 120, 30);
		middleName.setBounds(50, 240, 120, 30);
		lastName.setBounds(50, 280, 120, 30);

		addresses.setBounds(0, 320, 500, 60);
		home.setBounds(50, 400, 120, 30);
		office.setBounds(50, 440, 120, 30);
		email.setBounds(50, 480, 120, 30);
		phone.setBounds(50, 520, 120, 30);

		JLabel upperBlock = createColoredBlockLabel(ORANGE); 
		JLabel lowerBlock = createColoredBlockLabel(ORANGE); 
		upperBlock.setBounds(0, 0, 500, 30);
		lowerBlock.setBounds(0, 620, 500, 30);

		// Text Field Settings
		textBoxB = createTextField(14);
		textBoxC = createTextField(14);
		textBoxD = createTextField(14);
		textBoxE = createTextField(14);
		textBoxF = createTextField(14);
		textBoxG = createTextField(14);
		textBoxH = createTextField(14);
		textBoxB.setBounds(200, 200, 270, 30);
		textBoxC.setBounds(200, 240, 270, 30);
		textBoxD.setBounds(200, 280, 270, 30);
		textBoxE.setBounds(200, 400, 270, 30);
		textBoxF.setBounds(200, 440, 270, 30);
		textBoxG.setBounds(200, 480, 270, 30);
		textBoxH.setBounds(200, 520, 270, 30);

		// Button Settings
		buttonA = createButton("Register", new AccountInfoEvents());
		buttonB = createButton("Cancel", new AccountInfoEvents());
		buttonA.setBounds(0, 570, 250, 50);
		buttonB.setBounds(250, 570, 250, 50);
		
		// Add Componenets
		frame.add(panel);
		panel.add(title);
		panel.add(fullName);
		panel.add(firstName);
		panel.add(middleName);
		panel.add(lastName);
		panel.add(addresses);
		panel.add(home);
		panel.add(office);
		panel.add(email);
		panel.add(phone);
		panel.add(upperBlock);
		panel.add(lowerBlock);
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

	//
	//	Login Menu
	//	
	private static void loginMenu() {
		// Frame Settings
		frameSettings("Login Menu", 500, 500);

		// Panel Settings
		JPanel panel = createPanel(500, 500);

		// Label Settings
		JLabel title = createTitleLabel("User Login", LIGHTGREY, 30);
		JLabel usernameLabel = createLabel("Username: ", DARKGREY, 14);
		JLabel passwordLabel = createLabel("Password: ", DARKGREY, 14);
		title.setBounds(0, 30, 500, 80);
		usernameLabel.setBounds(80, 150, 230, 40);
		passwordLabel.setBounds(80, 230, 230, 40);

		JLabel upperBlock = createColoredBlockLabel(ORANGE);
		JLabel lowerBlock = createColoredBlockLabel(ORANGE);
		upperBlock.setBounds(0, 0, 500, 30);
		lowerBlock.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = createButton("Login", new LoginEvents());
		buttonB = createButton("Back", new LoginEvents());
		buttonA.setBounds(0, 420, 250, 50);
		buttonB.setBounds(250, 420, 250, 50);

		// Text & Password Fields
		usernameTextBox = createTextField(14);
		passwordTextBox = createPassField(14);
		usernameTextBox.setBounds(80, 180, 330, 40);
		passwordTextBox.setBounds(80, 260, 330, 40);

		// Add Components Together
		frame.add(panel);
		panel.add(title);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(upperBlock);
		panel.add(lowerBlock);
		panel.add(usernameTextBox);
		panel.add(passwordTextBox);

		// Display Frame
		frame.setVisible(true);	
	}


	// Event Handling / Flow Control ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private static class MainEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {
				// Register Button
				System.out.println(("-> Registry UI"));

				frame.dispose();
				// Register a Customer Account
				inputRole = "customer";
				registerMenu();

			} else if (e.getSource() == buttonB) {
				// Login Button
				System.out.println(("-> Login UI"));
				frame.dispose();
				loginMenu();

			} else {	
				// Console Messages
				System.out.println("Console Message: Program Terminated");

				// Exit Button
				frame.dispose();
				System.exit(0);

			}
		}
	}

	private static class RegisterEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {				
				MasterList masters = new MasterList();

				// Get Inputs
				inputUsername = usernameTextBox.getText();
				inputPassword = String.valueOf(passwordTextBox.getPassword());

				// Check Unique Username
				if (!(masters.checkMaster(inputUsername)) && inputUsername.length() > 0) {

					// Check Valid Password
					if (user.validPassword(inputPassword)) {
						System.out.println("Console Message: Registering: user: " + inputUsername + " pass: " + inputPassword);

						frame.dispose();
						accountInfoMenu();

					} else {
						System.out.println("Console Message: Error: Invalid Password Format");

					}

				} else {
					if(inputUsername.length() == 0) {
						System.out.println("Console Message: Error: There is no Username Input");

					} else {
						System.out.println("Console Message: Error: Username is Not Unique");

					}
				}

				// Clear Text Fields
				usernameTextBox.setText("");
				passwordTextBox.setText("");

			} else {
				// Console Messages
				System.out.println("-> Main UI (Back)");	
				
				// Back Button
				frame.dispose();
				mainMenu();

			}
		}
	}

	private static class AccountInfoEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = 1;
			String[] userInputs = new String[7];

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
			
			if (e.getSource() == buttonA) {		
				// Register Button	
				
				// Check if there are Missing Inputs 	
				if (i != 0) {
					Name fullName = new Name(userInputs[0], userInputs[1], userInputs[2]);
					Address addresses = new Address(userInputs[3], userInputs[4], userInputs[5], userInputs[6]);

					if (user.register(inputRole, inputUsername, inputPassword, fullName, addresses)) {
						System.out.println("Console Message: Registry Success");
						
						frame.dispose();
						clearInputVariables();
						mainMenu();

					} else {
						System.out.println("Console Message: Registry Failure");

					}
				} else {
					System.out.println("Console Message: Missing Inputs");

				}

			} else {
				// Cancel Button
				System.out.println("Console Message: Registry Canceled");

				frame.dispose();
				clearInputVariables();
				mainMenu();
			}
		}
	}

	private static class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {				
				if (user.logIn(usernameTextBox.getText(), String.valueOf(passwordTextBox.getPassword()))) {
					// Load User Information From File
					user.loadUserInfo(usernameTextBox.getText());

					System.out.println("Console Message: Login Success: Info Loaded");
					System.out.println("Console Message: Fullname: " + user.fullName);
					System.out.println("Console Message: Role: " + user.getRole());
					System.out.println("Console Message: Online: " + user.getOnline());
					
				} else {
					System.out.println("Console Message: Login Failed: Invalid Username or Password");

				}
				// Clear Text Fields
				usernameTextBox.setText("");
				passwordTextBox.setText("");

			} else {
				// Console Messages
				System.out.println("-> Main UI (Back)");	
				
				// Back Button
				frame.dispose();
				mainMenu();

			}
		}
	}

	private static void clearInputVariables() {
		inputUsername = null;
		inputPassword = null;
		inputRole = null;
	}








	// Formatting Functions for Common Format of Swing Components ::::::::::::::::::::::::::::::::::::::::
	/*
		Function for Quick Creation of JFrame Object wtih Common Settings
	 */
	private static void frameSettings(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width + 10, height + 40);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	/*
		Function for Quick Creation of JPanel Object wtih Common Settings
	 */
	private static JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setSize(width, height);
		panel.setLayout(null);

		panel.setBackground(Color.decode(DARKGREY));
		panel.setOpaque(true);

		return panel;
	}

	/*
		Function for Quick Creation of JLabel Object wtih Common Settings
	 */
	private static JLabel createTitleLabel(String title, String color, int fontsize) {
		JLabel label = new JLabel(title, SwingConstants.CENTER);
		
		label.setFont(new Font("Robotico", Font.BOLD, fontsize));
		label.setBackground(Color.decode(color));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);

		return label;
	}

	private static JLabel createLabel(String title, String color, int fontsize) {
		JLabel label = new JLabel(title);
		
		label.setFont(new Font("Robotico", Font.BOLD, fontsize));
		label.setBackground(Color.decode(color));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);

		return label;
	}

	private static JLabel createColoredBlockLabel(String color) {
		JLabel label = new JLabel();

		label.setBackground(Color.decode(color));
		label.setOpaque(true);

		return label;
	}

	/*
		Function for Quick Creation of JButton Object wtih Common Settings
	 */
	private static JButton createButton(String title, ActionListener event) {
		JButton button = new JButton(title);
		button.addActionListener(event);

		button.setFont(new Font("Robotico", Font.PLAIN, 16));
		button.setBackground(Color.decode(LIGHTGREY));
		button.setForeground(Color.WHITE);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setOpaque(true);

		return button;
	}

	/*
		Function for Quick Creation of JTextField Object wtih Common Settings
	 */
	private static JTextField createTextField(int fontsize) {
		JTextField textfield = new JTextField();

		textfield.setFont(new Font("Robotico", Font.PLAIN, fontsize));
		textfield.setBackground(Color.decode(LIGHTGREY));
		textfield.setForeground(Color.WHITE);
		textfield.setOpaque(true);
		textfield.setBorder(BorderFactory.createEtchedBorder());

		return textfield;
	}

	/*
		Function for Quick Creation of JPassword Object wtih Common Settings
	 */
	private static JPasswordField createPassField(int fontsize) {
		JPasswordField passfield = new JPasswordField();

		passfield.setFont(new Font("Robotico", Font.PLAIN, fontsize));
		passfield.setBackground(Color.decode(LIGHTGREY));
		passfield.setForeground(Color.WHITE);
		passfield.setOpaque(true);
		passfield.setBorder(BorderFactory.createEtchedBorder());

		return passfield;
	}

	
}