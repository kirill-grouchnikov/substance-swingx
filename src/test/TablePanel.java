/*
 * Copyright 2005-2008 Kirill Grouchnikov, based on work by
 * Sun Microsystems, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.pushingpixels.substance.internal.utils.SubstanceColorUtilities;

import test.check.svg.flags.bg;
import test.check.svg.flags.br;
import test.check.svg.flags.ca;
import test.check.svg.flags.cn;
import test.check.svg.flags.de;
import test.check.svg.flags.dk;
import test.check.svg.flags.fi;
import test.check.svg.flags.fr;
import test.check.svg.flags.gr;
import test.check.svg.flags.hu;
import test.check.svg.flags.il;
import test.check.svg.flags.it;
import test.check.svg.flags.jp;
import test.check.svg.flags.mx;
import test.check.svg.flags.nl;
import test.check.svg.flags.no;

public class TablePanel extends JPanel {
	private JXTable table;

	private Object[][] data;

	private Class[] columns;

	private static class MyColorTableRenderer extends JLabel implements
			TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Color color = (Color) value;
			this.setForeground(color);
			this.setBackground(SubstanceColorUtilities.invertColor(color));
			this.setText("row " + row);
			return this;
		}
	}

	private static class MyFloatTableRenderer extends JLabel implements
			TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			int c = (10 * row) % 255;
			Color color = new Color(c, c, c);
			this.setForeground(new Color(255 - c, 0, 0));
			this.setBackground(color);
			this.setText(value.toString());
			return this;
		}
	}

	public TablePanel() {
		final int rows = 400;
		final int cols = 10;
		this.data = new Object[rows][cols];
		this.columns = new Class[] { String.class, JComboBox.class,
				Boolean.class, Byte.class, Float.class, Double.class,
				String.class, Date.class, ImageIcon.class, Color.class };

		Icon[] icons = new Icon[] { 
				Check.configure(new br(), 21, 16),
				Check.configure(new bg(), 21, 16),
				Check.configure(new ca(), 21, 16),
				Check.configure(new cn(), 21, 16),
				Check.configure(new dk(), 21, 16),
				Check.configure(new fi(), 21, 16),
				Check.configure(new fr(), 21, 16),
				Check.configure(new de(), 21, 16),
				Check.configure(new gr(), 21, 16),
				Check.configure(new hu(), 21, 16),
				Check.configure(new il(), 21, 16),
				Check.configure(new it(), 21, 16),
				Check.configure(new jp(), 21, 16),
				Check.configure(new mx(), 21, 16),
				Check.configure(new nl(), 21, 16),
				Check.configure(new no(), 21, 16)
		};
		for (int i = 0; i < rows; i++) {
			this.data[i][0] = "cell " + i + ":" + 0;
			this.data[i][1] = "predef";
			this.data[i][2] = new Boolean(i % 2 == 0);
			this.data[i][3] = new Byte((byte) i);
			this.data[i][4] = new Float(i);
			this.data[i][5] = new Double(i);
			this.data[i][6] = "cell " + i + ":" + 6;

			Calendar cal = Calendar.getInstance();
			cal.set(2000 + i, 1 + i, 1 + i);
			this.data[i][7] = cal.getTime();

			this.data[i][8] = icons[i % icons.length];

			int comp = i * 20;
			int red = (comp / 3) % 255;
			int green = (comp / 2) % 255;
			int blue = comp % 255;
			this.data[i][9] = new Color(red, green, blue);
		}

		TableModel dataModel = new AbstractTableModel() {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columns[columnIndex];
			}

			public int getColumnCount() {
				return cols;
			}

			public int getRowCount() {
				return rows;
			}

			public Object getValueAt(int row, int col) {
				return data[row][col];
			}

			@Override
			public String getColumnName(int column) {
				return this.getColumnClass(column).getSimpleName();
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return (rowIndex % 2 == 0);
			}

			@Override
			public void setValueAt(Object value, int row, int col) {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
		};
		this.table = new JXTable(dataModel);
		this.table.setDefaultRenderer(Color.class, new MyColorTableRenderer());
		this.table.setDefaultRenderer(Float.class, new MyFloatTableRenderer());
		final JScrollPane tableScrollpane = new JScrollPane(this.table);

		this.table.setColumnControlVisible(true);
		this.table
				.setHighlighters(new ColorHighlighter(HighlightPredicate.EVEN));

		JComboBox combo = new JComboBox(new Object[] { "aa", "bb", "cc" });
		combo.setBorder(null);
		this.table.getColumnModel().getColumn(1).setCellEditor(
				new DefaultCellEditor(combo));

		this.table
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.table.setCellSelectionEnabled(true);
		this.table.setColumnSelectionAllowed(true);
		this.table.setShowGrid(true);
		this.table.setDragEnabled(false);

		this.setLayout(new BorderLayout());
		this.add(tableScrollpane, BorderLayout.CENTER);

	}
}