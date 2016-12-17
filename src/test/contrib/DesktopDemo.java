package test.contrib;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXPanel;

/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class DesktopDemo extends JFrame {
	public DesktopDemo() {
		super("InternalFrameDemo");

		this.setSize(500, 300);
		this.setLocationRelativeTo(null);

		JDesktopPane jdp = new JDesktopPane();
		this.add(jdp);

		JInternalFrame jif = new JInternalFrame();
		jif.setBounds(20, 20, 400, 200);
		jif.setVisible(true);
		jdp.add(jif);

		JXPanel panel = new JXPanel();
		panel.setAlpha(0.5f);
		jif.setLayout(new BorderLayout());
		jif.add(panel, BorderLayout.CENTER);

		panel.setLayout(new GridLayout(1, 2));
		String[] columnNames = { "First Name", "Last Name" };

		Object[][] data = { { "Mary", "Campione" }, { "Alison", "Huml" },
				{ "Kathy", "Walrath" } };

		JTable table = new JTable(data, columnNames);
		// table.setBackground(new Color(255, 200, 200));
//		table.setDefaultRenderer(Object.class, new TableCellRenderer() {
//			JLabel label = new JLabel();
////			{
////				@Override
////				public boolean isOpaque() {
////					return true;
////				}
////			};
//
//			public Component getTableCellRendererComponent(JTable table,
//					Object value, boolean isSelected, boolean hasFocus,
//					int row, int column) {
//				label.setText(value.toString());
//				if (isSelected) {
//					label.setBackground(new Color(200, 200, 255));
//				} else {
//					if ((row + column) % 2 == 0)
//						label.setBackground(new Color(255, 200, 200));
//					else
//						label.setBackground(new Color(200, 255, 200));
//				}
//				label.setForeground(Color.black);
//				return label;
//			}
//		});
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
			DesktopDemo frame = new DesktopDemo();
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