package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXStatusBar;
import org.jdesktop.swingx.plaf.basic.BasicStatusBarUI;
import org.pushingpixels.substance.api.ColorSchemeAssociationKind;
import org.pushingpixels.substance.api.ComponentState;
import org.pushingpixels.substance.api.DecorationAreaType;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GeminiSkin;

import test.check.SampleMenuFactory;

public class TestDatePicker extends JFrame {
	public TestDatePicker() {
		super("Date pickers galore");

		this.setLayout(new BorderLayout());

		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(true);
		toolbar.add(new JLabel("In a toolbar"));
		toolbar.add(Box.createHorizontalStrut(8));
		toolbar.add(new JXDatePicker(new Date()));
		this.add(toolbar, BorderLayout.NORTH);

		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.setBorder(new EmptyBorder(0, 4, 0, 4));
		left.add(Box.createVerticalStrut(30));
		left.add(new JLabel("In a sidebar"));
		left.add(new JXDatePicker(new Date()));
		SubstanceLookAndFeel
				.setDecorationType(left, DecorationAreaType.GENERAL);
		this.add(left, BorderLayout.WEST);

		JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));
		center.setBorder(new EmptyBorder(40, 0, 0, 0));
		center.add(new JLabel("General"));
		center.add(new JXDatePicker(new Date()));
		this.add(center, BorderLayout.CENTER);

		JXStatusBar statusBar = new JXStatusBar();
		statusBar.putClientProperty(BasicStatusBarUI.AUTO_ADD_SEPARATOR, false);
		statusBar.add(new JLabel("In a status bar"));
		statusBar.add(Box.createHorizontalStrut(8));
		statusBar.add(new JXDatePicker(new Date()));
		this.add(statusBar, BorderLayout.SOUTH);

		this.setIconImage(SubstanceLogo
				.getLogoImage(SubstanceLookAndFeel.getCurrentSkin(
						this.getRootPane())
						.getColorScheme(DecorationAreaType.PRIMARY_TITLE_PANE,
								ColorSchemeAssociationKind.FILL,
								ComponentState.ENABLED)));
		SubstanceLookAndFeel.registerSkinChangeListener(
				() -> SwingUtilities.invokeLater(() -> setIconImage(SubstanceLogo.getLogoImage(
						SubstanceLookAndFeel.getCurrentSkin(getRootPane()).getColorScheme(
								DecorationAreaType.PRIMARY_TITLE_PANE,
								ColorSchemeAssociationKind.FILL, ComponentState.ENABLED)))));				

		JMenuBar jmb = new JMenuBar();
		jmb.add(SampleMenuFactory.getSkinMenu());
		jmb.add(SampleMenuFactory.getTransformMenu());
		this.setJMenuBar(jmb);

		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				SubstanceLookAndFeel.setSkin(new GeminiSkin());
				new TestDatePicker().setVisible(true);
			}
		});
	}
}
