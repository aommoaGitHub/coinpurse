package coinpurse;

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
		return theMoneyFactory;
	}

	/**
	 * Creating money method of input value(double type) of subclass's currency
	 * @param value of created money
	 * @return valuable object is created
	 * @throws IllegalAccessException if value of selected country factory is invalid.
	 */
	protected abstract Valuable createMoney(double value) throws IllegalAccessException;

	/**
	 * Creating money method of input value(String type) of subclass's currency.<br>
	 * Because input value is String, so in this method call createMoney method with double parameter.
	 * @param value of created money
	 * @return valuable object is created
	 * @throws IllegalAccessException if value of selected country factory is invalid.
	 */
	protected Valuable createMoney(String value) throws IllegalAccessException {
		double valueDouble = Double.parseDouble(value);
		return createMoney(valueDouble);
	}

	/**
	 * Selecting country factory by reading in purse.properties. 
	 */
	protected static void setMoneyFactory(MoneyFactory moneyfactory) {
		theMoneyFactory = moneyfactory;
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
	
	/**
	 * get currency of the money
	 * @return currency of the money
	 */
	public abstract String getDEFAULT_CURRENCY() ;
}
