import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MachineProjectWithGUI {
	// Main Attributes
	private static boolean isOnline = false;
	private static Account user = new Account(); 

	// GUI Attrtibutes
	private static JFrame frame;
	private static JPanel panelA, panelB;
	private static JLabel labelA, labelB, labelC, labelD;
	private static JLabel blockA, blockB, blockC, blockD;
	private static JTextField textBoxA, textBoxB, textBoxC, textBoxD;
	private static JPasswordField passBoxA;
	private static JButton buttonA, buttonB, buttonC, buttonD, buttonE; 

	private static final String colorA = "#181915";
	private static final String colorB = "#282923";
	private static final String colorC = "#FF9800";
	 
	public static void main(String[] args) {
		
		mainMenu();
	}

	//
	//	Main Menu
	//
	public static void mainMenu() {
		// Frame Settings
		frame = new JFrame("Main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(510, 539);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Panel Settings
		panelA = new JPanel();
		panelA.setLayout(null);

		// Label Settings
		//	// Labels
		labelA = new JLabel("Main Menu", SwingConstants.CENTER);
		labelA.setBounds(0, 30, 500, 80);

		//	// Blocks
		blockA = new JLabel();
		blockB = new JLabel();
		blockA.setBounds(0, 0, 500, 30);
		blockB.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = new JButton("Register");
		buttonB = new JButton("Login");
		buttonC = new JButton("Exit");
		buttonA.addActionListener(new MainEvents());
		buttonB.addActionListener(new MainEvents());
		buttonC.addActionListener(new MainEvents());
		buttonA.setBounds(0, 320, 500, 50);
		buttonB.setBounds(0, 370, 500, 50);
		buttonC.setBounds(0, 420, 500, 50);

		// Fonts
		labelA.setFont(new Font("Robotico", Font.BOLD, 30));
		buttonA.setFont(new Font("Robotico", Font.PLAIN, 16));
		buttonB.setFont(new Font("Robotico", Font.PLAIN, 16));
		buttonC.setFont(new Font("Robotico", Font.PLAIN, 16));

		// Colors & Borders
		panelA.setBackground(Color.decode(colorA));
		labelA.setBackground(Color.decode(colorB));
		labelA.setForeground(Color.WHITE);
		blockA.setBackground(Color.decode(colorC));
		blockB.setBackground(Color.decode(colorC));
		buttonA.setBackground(Color.decode(colorB));
		buttonB.setBackground(Color.decode(colorB));
		buttonC.setBackground(Color.decode(colorB));
		buttonA.setForeground(Color.WHITE);
		buttonB.setForeground(Color.WHITE);
		buttonC.setForeground(Color.WHITE);
		buttonA.setBorder(BorderFactory.createEtchedBorder());
		buttonB.setBorder(BorderFactory.createEtchedBorder());
		buttonC.setBorder(BorderFactory.createEtchedBorder());
		panelA.setOpaque(true);
		labelA.setOpaque(true);
		blockA.setOpaque(true);
		blockB.setOpaque(true);
		buttonA.setOpaque(true);
		buttonB.setOpaque(true);
		buttonC.setOpaque(true);

		// Add Components Together
		frame.add(panelA);
		panelA.add(labelA);
		panelA.add(buttonA);
		panelA.add(buttonB);
		panelA.add(buttonC);
		panelA.add(blockA);
		panelA.add(blockB);

		// Display Frame
		frame.setVisible(true);
	}

	//
	//	Login Menu
	//	
	private static void loginMenu() {
		// Frame Settings
		frame = new JFrame("Login Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(510, 539);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Panel Settings
		panelA = new JPanel();
		panelA.setLayout(null);

		// Label Settings
		labelA = new JLabel("User Login", SwingConstants.CENTER);
		labelB = new JLabel("Username:");
		labelC = new JLabel("Password:");
		labelA.setBounds(0, 30, 500, 80);
		labelB.setBounds(80, 150, 230, 40);
		labelC.setBounds(80, 230, 230, 40);

		//	// Blocks
		blockA = new JLabel();
		blockB = new JLabel();
		blockA.setBounds(0, 0, 500, 30);
		blockB.setBounds(0, 470, 500, 30);

		// Button Settings
		buttonA = new JButton("Login");
		buttonB = new JButton("Back");
		buttonA.addActionListener(new LoginEvents());
		buttonB.addActionListener(new LoginEvents());
		buttonA.setBounds(0, 420, 250, 50);
		buttonB.setBounds(250, 420, 250, 50);

		// Text & Password Fields
		textBoxA = new JTextField();
		passBoxA = new JPasswordField();
		textBoxA.setBounds(80, 180, 330, 40);
		passBoxA.setBounds(80, 260, 330, 40);
		
		// Fonts
		labelA.setFont(new Font("Robotico", Font.BOLD, 30));
		labelB.setFont(new Font("Robotico", Font.BOLD, 14));
		labelC.setFont(new Font("Robotico", Font.BOLD, 14));
		textBoxA.setFont(new Font("Robotico", Font.PLAIN, 14));
		passBoxA.setFont(new Font("Robotico", Font.PLAIN, 14));
		buttonA.setFont(new Font("Robotico", Font.PLAIN, 16));
		buttonB.setFont(new Font("Robotico", Font.PLAIN, 16));

		// Colors & Borders
		panelA.setBackground(Color.decode(colorA));
		labelA.setBackground(Color.decode(colorB));
		labelA.setForeground(Color.WHITE);
		labelB.setBackground(Color.decode(colorB));
		labelB.setForeground(Color.WHITE);
		labelC.setBackground(Color.decode(colorB));
		labelC.setForeground(Color.WHITE);
		blockA.setBackground(Color.decode(colorC));
		blockB.setBackground(Color.decode(colorC));
		buttonA.setBackground(Color.decode(colorB));
		buttonB.setBackground(Color.decode(colorB));
		buttonA.setForeground(Color.WHITE);
		buttonB.setForeground(Color.WHITE);
		textBoxA.setBackground(Color.decode(colorB));
		textBoxA.setForeground(Color.WHITE);
		passBoxA.setBackground(Color.decode(colorB));
		passBoxA.setForeground(Color.WHITE);
		buttonA.setBorder(BorderFactory.createEtchedBorder());
		buttonB.setBorder(BorderFactory.createEtchedBorder());
		textBoxA.setBorder(BorderFactory.createEtchedBorder());
		passBoxA.setBorder(BorderFactory.createEtchedBorder());
		panelA.setOpaque(true);
		labelA.setOpaque(true);
		blockA.setOpaque(true);
		blockB.setOpaque(true);
		buttonA.setOpaque(true);
		buttonB.setOpaque(true);
		textBoxA.setOpaque(true);
		passBoxA.setOpaque(true);

		// Add Components Together
		frame.add(panelA);
		panelA.add(labelA);
		panelA.add(labelB);
		panelA.add(labelC);
		panelA.add(buttonA);
		panelA.add(buttonB);
		panelA.add(blockA);
		panelA.add(blockB);
		panelA.add(textBoxA);
		panelA.add(passBoxA);

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

			} else if (e.getSource() == buttonB) {
				// Login Button
				System.out.println(("-> Login UI"));
				frame.dispose();
				loginMenu();

			} else {	
				// Console
				System.out.println("Program Terminated");

				// Exit Button
				frame.dispose();
				System.exit(0);

			}
		}
	}

	private static class LoginEvents implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonA) {				
				if (user.logIn(textBoxA.getText(), String.valueOf(passBoxA.getPassword()))) {
					// Load User Information From File
					user.loadUserInfo(textBoxA.getText());

					// Console
					System.out.println("Login Success: Info Loaded");
					System.out.println("Fullname: " + user.fullName);
					System.out.println("Role: " + user.getRole());
					System.out.println("Online: " + user.getOnline());
					
				} else {
					// Console
					System.out.println("Login Failed: Invalid Username or Password");

				}
				// Clear Text Fields
				textBoxA.setText("");
				passBoxA.setText("");

			} else {
				// Console
				System.out.println("-> Main UI (Back)");	
				
				// Back Button
				frame.dispose();
				mainMenu();

			}
		}
	}
}