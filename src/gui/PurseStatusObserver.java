package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

/**
 * This class is an observer that provides view for showing status of the
 * purse. The status are EMPTY, FULL, and numbers of items in the purse. 
 * @author Vittunyuta Maeprasart
 *
 */
public class PurseStatusObserver extends JFrame implements Observer {
	/* text of the status */
	private JLabel label;
	/* bar of the status */
	private JProgressBar progressBar;

	/**
	 * Initialize view of status of the purse
	 */
	public PurseStatusObserver() {
		this.setTitle("Purse Status");

	}

	/**
	 * create the components
	 */
	private void initComponents() {
		label = new JLabel("EMPTY",SwingConstants.CENTER);
		label.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		progressBar = new JProgressBar();
		progressBar.setMaximum(100);
		this.setLayout(new GridLayout(2, 1));
		this.add(label);
		this.add(progressBar);
		this.pack();
	}

	/**
	 * run the view
	 */
	public void run() {
		initComponents();
		setVisible(true);

	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			int count = purse.count();
			if( count == 0)
				label.setText("EMPTY");
			if (count == purse.getCapacity())
				label.setText("FULL");
			else
				label.setText(count + " ITEMS");
			
			progressBar.setValue(count*progressBar.getMaximum()/purse.getCapacity());
			this.pack();
		}
	}

}
