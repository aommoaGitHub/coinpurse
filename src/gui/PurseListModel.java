package gui;

import java.util.*;

import javax.swing.*;

import coinpurse.*;

/**
 * This class is an observer that provides a ListModel interface for showing the contents of the
 * purse. 
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class PurseListModel extends AbstractListModel<Valuable> implements Observer {
	private Purse purse;
	private int size;
	private List<Valuable> moneyList;
	private ListModel<Valuable> listModel;
	private JList<Valuable> listview;
	private JFrame frame;

	/**
	 * Initialize view the contents of the purse.
	 * @param purse of Purse class
	 */
	public PurseListModel(Purse purse) {
		this.purse = purse;
		this.size = 0;
		this.moneyList = purse.immutableList();
		frame = new JFrame("Purse Contents");
	}

	/**
	 * create the components
	 */
	private void initComponents() {
		this.listModel = new PurseListModel(purse);
		this.listview = new JList<>(listModel);
		JScrollPane pane = new JScrollPane(listview);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		frame.add(pane);
		frame.pack();
	}

	/**
	 * run the view
	 */
	public void run() {
		initComponents();
		frame.setVisible(true);

	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return purse.count();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Valuable getElementAt(int index) {
		return moneyList.get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			size = getSize();
			fireContentsChanged(this, 0, size - 1);
			
			Valuable[] valArray = moneyList.toArray(new Valuable[0]);
			listview.setListData(valArray);
			
//			listview.setModel(this);
		}
	}

}
