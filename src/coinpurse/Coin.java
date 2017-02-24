package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Vittunyuta Maeprasart
 */
public class Coin extends AbstractValuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	
	private String printCurrency;
	private double printValue;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of this coin
	 */
	public Coin(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            of this coin
	 * @param currency
	 *            of this coin
	 */
	public Coin(double value, String currency) {
		super(value, currency);
		this.printCurrency = currency;
		this.printValue = value;
	}

	/**
	 * set currency for printing of this coin
	 * 
	 * @param printCurrency is currency for printing
	 */
	public void setDescription(double printValue, String printCurrency) {
		this.printValue = printValue;
		this.printCurrency = printCurrency;
	}
	
	/**
	 * The description of this coin
	 * @return this coin's description
	 */
	public String toString() {
		return String.format("%.0f-%s",this.printValue,this.printCurrency);
	}

}
