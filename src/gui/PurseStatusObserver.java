package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

public class PurseStatusObserver extends JFrame implements Observer {
	private JLabel label;
	private JProgressBar progressBar;

	public PurseStatusObserver() {
		this.setTitle("Purse Status");

	}

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

	public void run() {
		initComponents();
		setVisible(true);

	}

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
