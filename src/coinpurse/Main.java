package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Vittunyuta Maeprasart
 */
public class Main{
	private static int CAPACITY = 10;
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
		}
    	
        // 1. create a Purse
    	Purse purse = new Purse(CAPACITY);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
    	ui.run();

 
    }
}
