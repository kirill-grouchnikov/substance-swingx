package test;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.FileSystemModel;
import org.jdesktop.swingx.treetable.TreeTableModel;

public class TreeTablePanel extends JPanel {
	public TreeTablePanel() {
		this.setLayout(new BorderLayout());

		TreeTableModel treeTableModel = new FileSystemModel();
		JXTreeTable treeTable = new JXTreeTable(treeTableModel);
		treeTable.setColumnControlVisible(true);
		JScrollPane scrollpane = new JScrollPane(treeTable);

		this.add(scrollpane, BorderLayout.CENTER);
	}

}
