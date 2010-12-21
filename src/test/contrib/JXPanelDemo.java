package test.contrib;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import org.jdesktop.swingx.JXPanel;

/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class JXPanelDemo extends JFrame {
	public JXPanelDemo() {
		super("InternalFrameDemo");

		this.setSize(500, 300);
		this.setLocationRelativeTo(null);

		JXPanel panel = new JXPanel();
		
		// panel.setOpaque(false);
		panel.setAlpha(0.5f);
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);

		panel.setLayout(new GridLayout(1, 2));
		String[] columnNames = { "First Name", "Last Name" };

		Object[][] data = { { "Mary", "Campione" }, { "Alison", "Huml" },
				{ "Kathy", "Walrath" } };

		JTable table = new JTable(data, columnNames);
		// table.setBackground(new Color(255, 200, 200));
		panel.add(table);
		// A simple tree
		panel.add(new JTree());
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
			JXPanelDemo frame = new JXPanelDemo();
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
}