package gui;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import coinpurse.*;

public class PurseTransactionsTable extends AbstractTableModel implements Observer {
	private JFrame frame;
	private JTable table;
	private TableModel model;
	private Purse purse;
	private List<String[]> rows;
	private String[] headerRow = new String[3];
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date date;

	public PurseTransactionsTable(Purse purse) {
		this.purse = purse;
		rows = new ArrayList<>(); 
		frame = new JFrame("Purse Transactions");
	}

	private void initComponents() {
		model = new PurseTransactionsTable(purse);
		
		headerRow[0] = "Date/Time";
		headerRow[1] = "Description";
		headerRow[2] = "Balance";
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setHeaderValue("Date/Time");
		table.getColumnModel().getColumn(1).setHeaderValue("Description");
		table.getColumnModel().getColumn(2).setHeaderValue("Balance");
		table.getTableHeader().repaint();
		
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setMinimumSize(new Dimension(80, 30));
		
		frame.add(pane);
		frame.pack();
	}
	
	public void run() {
		initComponents();
		frame.setVisible(true);
	}
	
	@Override
	public String getColumnName(int column) {
		return headerRow[column];
	}
	
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rows.get(rowIndex)[columnIndex];
	}

	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			String[] columns = new String[3];
			date = new Date();
			columns[0] = dateFormat.format(date);
			columns[1] = (String) info;
			columns[2] = purse.getBalance() + "";
			rows.add(columns);
			
			fireTableRowsInserted(rows.size()-1, rows.size()-1);
			table.setModel(this);
		}
	}

}
