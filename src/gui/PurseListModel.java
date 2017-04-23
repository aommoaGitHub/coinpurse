package gui;

import java.util.*;

import javax.swing.*;

import coinpurse.*;

/**
 * This class provides a ListModel interface for querying the content of the
 * purse. It is a kind of adapter.
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

	public PurseListModel(Purse purse) {
		this.purse = purse;
		this.size = 0;
		this.moneyList = purse.immutableList();
		frame = new JFrame("Purse Contents");
	}

	private void initComponents() {
		this.listModel = new PurseListModel(purse);
		this.listview = new JList<>(listModel);
		JScrollPane pane = new JScrollPane(listview);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		frame.add(pane);
		frame.pack();
	}

	public void run() {
		initComponents();
		frame.setVisible(true);

	}

	@Override
	public int getSize() {
		return purse.count();
	}

	@Override
	public Valuable getElementAt(int index) {
		return moneyList.get(index);
	}

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
