import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponentFactory {
	/*
		This class is dedicated for creating Swing components with common settings for 
		the implementation of the CCPROG3 Machine Probject GUI.

	 */
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// Component Color's Hexcodes (Color Settings)
	private static final String FRAMECOLOR = "#181915";	// DARK GREY	// Color of Frame
	private static final String COMPOCOLOR = "#282923";	// LIGHT GREY	// Color of Components
	private static final String BLOCKCOLOR = "#FF9800";	// ORANGE		// Color of Decorative Blocks


	// Methods ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**
	 * returns a JFrame object with settings based from the given parameters
	 * @author Steven Castro
	 * @param title  title of the JFrame container
	 * @param width  width of the JFrame container
	 * @param height height of the JFrame container
	 * @return 		 JFrame
	 */
	public static JFrame createFrame(String title, int width, int height) {
		JFrame frame = new JFrame(title);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width + 10, height + 40);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		return frame;
	}

	/**
	 *  returns a JPanel object with settings based from the given parameters
	 * @param  width  width of the JPanel component
	 * @param  height height of the JPanel component
	 * @return        JPanel
	 */
	public static JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setSize(width, height);
		panel.setLayout(null);

		panel.setBackground(Color.decode(FRAMECOLOR));
		panel.setOpaque(true);

		return panel;
	}

	/**
	 * returns a JLabel object with settings based from the given parameters, 
	 * in addition the text in this JLabel object is centered 
	 * @author Steven Castro
	 * @param  title    title of the JLabel component
	 * @param  fontsize font size of the JLabel component
	 * @return          JLabel
	 */
	public static JLabel createTitleLabel(String title, int fontsize) {
		JLabel label = new JLabel(title, SwingConstants.CENTER);
		
		label.setFont(new Font("Robotico", Font.BOLD, fontsize));
		label.setBackground(Color.decode(COMPOCOLOR));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);

		return label;
	}

	/**
	 * returns a JLabel object with settings based from the given parameters
	 * @author Steven Castro
	 * @param  title    title of the JLabel component
	 * @param  fontsize font size of the JLabel component
	 * @return          JLabel
	 */
	public static JLabel createLabel(String title, int fontsize) {
		JLabel label = new JLabel(title);
		
		label.setFont(new Font("Robotico", Font.BOLD, fontsize));
		label.setBackground(Color.decode(FRAMECOLOR));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);

		return label;
	}

	/**
	 * returns a JLabel object with settings based from the given parameters
	 * @author Steven Castro
	 * @return       JLabel
	 */
	public static JLabel createColoredBlockLabel() {
		JLabel label = new JLabel();

		label.setBackground(Color.decode(BLOCKCOLOR));
		label.setOpaque(true);

		return label;
	}

	/**
	 * returns a JButton object with settings based from the given parameters
	 * @author Steven Castro
	 * @param  title title or text of the JButton component
	 * @param  event ActionListener object to be called when the button is pressed
	 * @return       JButton
	 */
	public static JButton createButton(String title, ActionListener event) {
		JButton button = new JButton(title);
		button.addActionListener(event);

		button.setFont(new Font("Robotico", Font.PLAIN, 16));
		button.setBackground(Color.decode(COMPOCOLOR));
		button.setForeground(Color.WHITE);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setOpaque(true);

		return button;
	}

	/**
	 * returns a JTextField object with settings based from the given parameters
	 * @author Steven Castro
	 * @param  fontsize font size of the JTextField component
	 * @return          JTextField
	 */
	public static JTextField createTextField(int fontsize) {
		JTextField textfield = new JTextField();

		textfield.setFont(new Font("Robotico", Font.PLAIN, fontsize));
		textfield.setBackground(Color.decode(COMPOCOLOR));
		textfield.setForeground(Color.WHITE);
		textfield.setOpaque(true);
		textfield.setBorder(BorderFactory.createEtchedBorder());

		return textfield;
	}

	/**
	 * returns a JPasswordField object with settings based from the given parameters
	 * @author Steven Castro
	 * @param  fontsize font size of the JPasswordField component
	 * @return          JPasswordField
	 */
	public static JPasswordField createPassField(int fontsize) {
		JPasswordField passfield = new JPasswordField();

		passfield.setFont(new Font("Robotico", Font.PLAIN, fontsize));
		passfield.setBackground(Color.decode(COMPOCOLOR));
		passfield.setForeground(Color.WHITE);
		passfield.setOpaque(true);
		passfield.setBorder(BorderFactory.createEtchedBorder());

		return passfield;
	}
}