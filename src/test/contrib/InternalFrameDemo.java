package test.contrib;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import org.jdesktop.swingx.JXPanel;

/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class InternalFrameDemo extends JFrame implements ActionListener {
	JDesktopPane desktop;
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public InternalFrameDemo() {
		super("InternalFrameDemo");

		// Make the big window be indented 50 pixels from each edge
		// of the screen.
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		// Set up the GUI.
		desktop = new JDesktopPane(); // a specialized layered pane
		createFrame(); // create first "window"
		createFrame(); // create second "window"
		createImageFrame();
		this.add(desktop);
		setJMenuBar(createMenuBar());
	}

	protected void createImageFrame() {
		JInternalFrame ix = new JInternalFrame("ImageDocument", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		ix.setSize(500, 500);
		URL iUrl = InternalFrameDemo.class.getClassLoader().getResource(
				"test/org.pushingpixels.substance.internal.contrib/image.jpg");
		ImageIcon icon = new ImageIcon(iUrl);
		ix.setLayout(new BorderLayout());
		ix.add(new JLabel(icon));
		ix.setVisible(true);
		desktop.add(ix);
	}

	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// Set up the lone menu.
		JMenu menu = new JMenu("Document");
		menu.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menu);

		// Set up the first menu item.
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("new");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Set up the second menu item.
		menuItem = new JMenuItem("Quit");
		menuItem.setMnemonic(KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	// React to menu selections.
	public void actionPerformed(ActionEvent e) {
		if ("new".equals(e.getActionCommand())) { // new
			createFrame();
		} else { // quit
			quit();
		}
	}

	// Create a new internal frame.
	protected void createFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		frame.setVisible(true); // necessary as of 1.3
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}

	// Quit the application.
	protected void quit() {
		System.exit(0);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		// JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager
					.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
			// Create and set up the window.
			InternalFrameDemo frame = new InternalFrameDemo();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Display the window.
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public class MyInternalFrame extends JInternalFrame {

		public MyInternalFrame() {
			super("Document #" + (++openFrameCount), true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable

			// ...Create the GUI and put it in the window...

			// ...Then set the window size or call pack...
			setSize(500, 500);

			// Set the window's location.
			setLocation(xOffset * openFrameCount, yOffset * openFrameCount);

			// Add a panel
			JXPanel panel = new JXPanel();
			//panel.setOpaque(false);
			panel.setAlpha(0.5f);
			this.add(panel);
			String[] columnNames = { "First Name", "Last Name", "Sport",
					"# of Years", "Vegetarian" };

			Object[][] data = {
					{ "Mary", "Campione", "Snowboarding", new Integer(5),
							new Boolean(false) },
					{ "Alison", "Huml", "Rowing", new Integer(3),
							new Boolean(true) },
					{ "Kathy", "Walrath", "Knitting", new Integer(2),
							new Boolean(false) },
					{ "Sharon", "Zakhour", "Speed reading", new Integer(20),
							new Boolean(true) },
					{ "Philip", "Milne", "Pool", new Integer(10),
							new Boolean(false) } };

			panel.add(new JTable(data, columnNames));
			// A simple tree
			panel.add(new JTree());

//			// A simple tree non opaque
//			JTree tree = new JTree();
//			tree.setOpaque(false);
//			panel.add(tree);
//
//			// A table in a pane opaque
//			JPanel panel3 = new JPanel();
//			panel3.add(new JTable(data, columnNames));
//			panel3.setPreferredSize(new Dimension(150, 150));
//			panel.add(panel3);
//
//			// A table in a scroll pane non opaque
//			JScrollPane treeScroll = new JScrollPane(new JTable(data,
//					columnNames));
//			treeScroll.setPreferredSize(new Dimension(150, 150));
//			treeScroll.setOpaque(false);
//			treeScroll.setAutoscrolls(true);
//			panel.add(treeScroll);
//
//			// A table in a scroll pane opaque
//			JScrollPane treeScroll5 = new JScrollPane(new JTable(data,
//					columnNames));
//			treeScroll5.setPreferredSize(new Dimension(150, 150));
//			treeScroll5.setAutoscrolls(true);
//			panel.add(treeScroll5);
//
//			// A tree in a scrollpane non opaque
//			JScrollPane treeScroll2 = new JScrollPane(new JTree());
//			treeScroll2.setPreferredSize(new Dimension(150, 150));
//			treeScroll2.setOpaque(false);
//			treeScroll2.setAutoscrolls(true);
//			panel.add(treeScroll2);
//
//			// A tree in a scrollpane opaque
//			JScrollPane treeScroll4 = new JScrollPane(new JTree());
//			treeScroll4.setPreferredSize(new Dimension(150, 150));
//			treeScroll4.setAutoscrolls(true);
//			panel.add(treeScroll4);
//
//			// A icon in a scroll pane
//			JPanel panel2 = new JPanel();
//			panel2.setOpaque(false);
//			URL iUrl = InternalFrameDemo.class.getClassLoader().getResource(
//					"test/org.pushingpixels.substance.internal.contrib/image2.jpg");
//			JLabel label = new JLabel(new ImageIcon(iUrl));
//			label.setOpaque(false);
//			panel2.add(label);
//			JScrollPane treeScroll3 = new JScrollPane(panel2);
//			treeScroll3.setOpaque(false);
//			treeScroll3.setPreferredSize(new Dimension(150, 150));
//			treeScroll3.setAutoscrolls(true);
//			panel.add(treeScroll3);

		}
	}
}