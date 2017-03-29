package coinpurse;

/**
 * A class help to enable polymorphism, and defined several kinds of valuable
 * objects that can put in a Purse
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class AbstractValuable implements Valuable {
	protected final double value;
	protected final String currency;

	/**
	 * A valuable object with given value and currency.
	 * 
	 * @param value
	 *            of this object
	 * @param currency
	 *            of this object
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Comparing 2 valuable objects by value
	 * Order 2 valuable by value so that the similar come first
	 * @param o
	 *            is another coin
	 * @return -1 if this coin has less value<br>
	 *         0 if they have same value<br>
	 *         1 if this coin has more value
	 *         
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Valuable val) {
		if (this.currency.equalsIgnoreCase(val.getCurrency())
				|| ((this.currency == null) && (val.getCurrency() == null))) {
			return (int) Math.signum(this.value - val.getValue());
		}
		return -1;
	}

	/**
	 * checking 2 valuable objects are the same or not
	 * 
	 * @param obj
	 *            is another object
	 * @return true when 2 valuable objects are the same in both value and
	 *         currency, otherwise return false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable c = (Valuable) obj;
		if ((c.getValue() == this.value) && (c.getCurrency().equals(this.currency)))
			return true;
		return false;
	}

	/**
	 * @see coinpurse.Valuable#getValue()
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * @see coinpurse.Valuable#getCurrency()
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

}