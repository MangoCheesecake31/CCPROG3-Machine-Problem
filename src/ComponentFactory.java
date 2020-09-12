import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


public class ComponentFactory {
	/*
		This class is dedicated for creating Swing components with common settings for 
		the implementation of the CCPROG3 Machine Probject GUI.

	 */
	// Attributes ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// Component Color's Hexcodes (Color Settings)
	private static final String FRAMECOLOR = "#24292E";	// DARK GREY	// Color of Frame
	private static final String COMPOCOLOR = "#2F363D";	// LIGHT GREY	// Color of Components
	private static final String BLOCKCOLOR = "#0066FF";	// BLUE			// Color of Decorative Blocks
	//private static final String BLOCKCOLOR = "#0066FF";	// BLUE			// Color of Decorative Blocks
	


	private static final String FONTSTYLE = "Robotico";	// FONT
	
	// Old Color Settings
	// private static final String FRAMECOLOR = "#181915";	// DARK GREY	
	// private static final String COMPOCOLOR = "#282923";	// LIGHT GREY	
	// private static final String BLOCKCOLOR = "#FF9800";	// ORANGE	
	
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
		
		label.setFont(new Font(FONTSTYLE, Font.BOLD, fontsize));
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
		
		label.setFont(new Font(FONTSTYLE, Font.BOLD, fontsize));
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

		button.setFont(new Font(FONTSTYLE, Font.PLAIN, 16));
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

		textfield.setFont(new Font(FONTSTYLE, Font.PLAIN, fontsize));
		textfield.setBackground(Color.decode(COMPOCOLOR));
		textfield.setForeground(Color.WHITE);
		textfield.setOpaque(true);
		textfield.setBorder(BorderFactory.createLoweredBevelBorder());

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

		passfield.setFont(new Font(FONTSTYLE, Font.PLAIN, fontsize));
		passfield.setBackground(Color.decode(COMPOCOLOR));
		passfield.setForeground(Color.WHITE);
		passfield.setOpaque(true);
		passfield.setBorder(BorderFactory.createLoweredBevelBorder());

		return passfield;
	}

	/**
	 * returns a JLabel object with an icon based on given parameters
	 * @param  width    width of the Image
	 * @param  height   height of the Image
	 * @param  filename file path to the Image file
	 * @return          JLabel
	 */
	public static JLabel createIconLabel(int width, int height, String filename) {
		ImageIcon icon = new ImageIcon(filename);

		Image image = icon.getImage();
		Image modifiedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedImage);

		JLabel label = new JLabel(icon);

		return label;
	}

	/**
	 * 	returns a JScrollPane object with a JTable with settings based from given parameters
	 *
	 * 	@author Steven Castro
	 * 	@param 	data 	2D array of data
	 * 	@param 	col 	array of strings for column head
	 */
	public static JScrollPane createJTableScrollPane(Object[][] data, String[] col) {
		TableModel model = new DefaultTableModel(data, col) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(400, 40));
		table.setFillsViewportHeight(true);

		// Header Style
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.decode(BLOCKCOLOR)); 
		head.setForeground(Color.WHITE);
		head.setFont(new Font(FONTSTYLE, Font.BOLD, 24)); 
		head.setReorderingAllowed(false);
		head.setBorder(BorderFactory.createLineBorder(Color.decode(BLOCKCOLOR), 4, false));

		// Body Style
		table.setGridColor(Color.decode(COMPOCOLOR));
		table.setBackground(Color.decode(FRAMECOLOR)); 
		table.setForeground(Color.WHITE);
		table.setFont(new Font(FONTSTYLE, Font.BOLD, 16));
		//table.setBorder(BorderFactory.createLineBorder(Color.decode(FRAMECOLOR), 8, false));
		
		table.setRowHeight(40);

		JScrollPane pane = new JScrollPane(table);
		pane.setBackground(Color.decode(BLOCKCOLOR));
		pane.setBorder(BorderFactory.createLineBorder(Color.decode(COMPOCOLOR), 8, false));

		return pane;
	}
	
}
//	ImageIcon icon = new ImageIcon(filename);
//	JLabel label = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
//	return label;	