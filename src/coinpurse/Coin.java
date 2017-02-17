package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Vittunyuta Maeprasart
 */
public class Coin implements Comparable<Coin>, Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of this coin
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
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
		this.value = value;
		this.currency = currency;
	}

	/**
	 * get value of this coin
	 * 
	 * @return this coin's value
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * get currency of this coin
	 * 
	 * @return this coin's currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * checking 2 coins are the same or not
	 * 
	 * @param obj
	 *            is another coin
	 * @return true when 2 coins are the same in both value and currency,
	 *         otherwise return false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin c = (Coin) obj;
		if ((c.value == this.value) && (c.currency.equals(this.currency)))
			return true;
		return false;
	}

	/**
	 * Comparing 2 coins by value
	 * 
	 * @param o
	 *            is another coin
	 * @return -1 if this coin has less value<br>
	 *         0 if they have same value<br>
	 *         1 if this coin has more value
	 * 
	 */
	@Override
	public int compareTo(Coin o) {
		if (o == null)
			return -1;
		return (int) Math.signum(this.value - o.value);
	}

	/**
	 * The description of this coin
	 * @return this coin's description
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}

}
