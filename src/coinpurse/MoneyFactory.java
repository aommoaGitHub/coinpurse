package coinpurse;

import java.util.ResourceBundle;
/**
 * Main factory choose which country factory to create money.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory theMoneyFactory;

	/**
	 * Getting an instance of MoneyFactory.
	 * 
	 * @return an object of subclass (Thai or Malay)
	 */
	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return theMoneyFactory;
	}

	/**
	 * Creating money method of input value(double type) of subclass's currency
	 * @param value of created money
	 * @return valuable object is created
	 * @throws IllegalAccessException if value is invalid of selected country factory.
	 */
	protected abstract Valuable createMoney(double value) throws IllegalAccessException;

	/**
	 * Creating money method of input value(String type) of subclass's currency.<br>
	 * Because input value is String, so in this method call createMoney method with double parameter.
	 * @param value of created money
	 * @return valuable object is created
	 * @throws IllegalAccessException if value is invalid of selected country factory.
	 */
	protected Valuable createMoney(String value) throws IllegalAccessException {
		double valueDouble = Double.parseDouble(value);
		return createMoney(valueDouble);
	}

	/**
	 * Selecting country factory by reading in purse.properties. 
	 */
	protected static void setMoneyFactory() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
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
	}

	/**
	 * Checking input value is valid or not.
	 * @param value is input value
	 * @param validValues is array of value that valid in each country.
	 * @return true if input is valid, otherwise return false. 
	 */
	public boolean isValid(double value, double[] validValues) {
		for(double inside: validValues){
			if(value == inside)
				return true;
		}
		return false;
	}
}
