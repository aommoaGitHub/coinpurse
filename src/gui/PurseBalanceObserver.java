package gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

/**
 * This class is an observer that provides view of showing the balance of the purse.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer {
	private JLabel label;
	
	/**
	 * Initialize view of balance of the purse
	 */
	public PurseBalanceObserver() {
		this.setTitle("Purse Balance");
	}
	
	/**
	 * create the components
	 */
	private void initComponents() {
		label = new JLabel("      0 Baht      ");
		label.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label);
		this.pack();

	}
	
	/**
	 * run the view
	 */
	public void run(){
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
			label.setText("   "+purse.getBalance() + " Baht   \n");
			this.pack();
		}
		
	}

}
