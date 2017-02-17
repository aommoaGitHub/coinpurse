package coinpurse;

/**
 * Valuable interface for getting value and currency
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public interface Valuable {
	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue();

	/**
	 * Get the menetory currency of this object, in its own value.
	 * 
	 * @return the currency of this object
	 */
	public String getCurrency();
}
