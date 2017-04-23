package gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

public class PurseBalanceObserver extends JFrame implements Observer {
	private JLabel label;
	
	public PurseBalanceObserver() {
		this.setTitle("Purse Balance");
	}
	
	private void initComponents() {
		label = new JLabel("      0 Baht      ");
		label.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label);
		this.pack();

	}
	
	public void run(){
		initComponents();
		setVisible(true);
		
	}
	
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			label.setText("   "+purse.getBalance() + " Baht   \n");
			this.pack();
		}
		
	}

}
