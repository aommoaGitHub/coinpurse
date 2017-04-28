package coinpurse;

import java.util.ResourceBundle;

import gui.PurseBalanceObserver;
import gui.PurseListModel;
import gui.PurseStatusObserver;
import gui.PurseTransactionsTable;
import strategy.GreedyWithdraw;
import strategy.RecursiveWithdraw;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Vittunyuta Maeprasart
 */
public class Main{
	private static int CAPACITY = 10;
	private static String currency;
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory theMoneyFactory = null;
		if (factoryclass == null) {
			factoryclass = "coinpurse.ThaiMoneyFactory";
		}
		try {
			theMoneyFactory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());

		}
		if (theMoneyFactory == null)
			System.exit(1);
		else {
			MoneyFactory.setMoneyFactory(theMoneyFactory);
			currency = theMoneyFactory.getDEFAULT_CURRENCY();
		}
		
    // 1. create a Purse
    	Purse purse = new Purse(CAPACITY,currency);
//    	purse.setWithdrawStrategy(new GreedyWithdraw());
    	purse.setWithdrawStrategy(new RecursiveWithdraw());
    // 2. add observers
    	PurseBalanceObserver balanceObserver = new PurseBalanceObserver();
    	purse.addObserver(balanceObserver);
    	PurseStatusObserver statusObserver = new PurseStatusObserver();
    	purse.addObserver(statusObserver);
    	PurseListModel purseListModel = new PurseListModel(purse);
    	purse.addObserver(purseListModel);
    	PurseTransactionsTable purseTransactionsTable = new PurseTransactionsTable(purse);
    	purse.addObserver(purseTransactionsTable);
    // 3. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
    // 4. run the ConsoleDialog
    	purseTransactionsTable.run();
    	purseListModel.run();
    	statusObserver.run();
    	balanceObserver.run();
    	ui.run();

 
    }
}
