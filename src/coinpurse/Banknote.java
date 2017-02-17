package coinpurse;
/**
 * a banknote with a monetary value and currency
 * @author Vittunyuta Maeprasart
 *
 */
public class Banknote implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;
	/** Value of the bank note. */
	private final double value;
	/** The currency, of course. */
	private final String currency;
	/** The unique serial number. */
	private final long serialNumber;
	
	/**
	 * A bank note with given value using the default currency.
	 * 
	 * @param value
	 *            of this bank note
	 */
	public Banknote(double value) {
		this(value, DEFAULT_CURRENCY);
	}
	
	/**
	 * A bank note with given value and currency.
	 * 
	 * @param value
	 *            of this bank note
	 * @param currency of this bank note
	 */
	public Banknote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	/**
	 * get value of this bank note
	 * 
	 * @return this bank note's value
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
	 * get currency of this bank note
	 * 
	 * @return this bank note's currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * get serial number of this bank note
	 * 
	 * @return this bank note's serial number 
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	/**
	 * checking 2 bank notes are the same or not
	 * 
	 * @param obj
	 *            is another bank note
	 * @return true when 2 bank note are the same in both value and currency,
	 *         otherwise return false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Banknote b = (Banknote) obj;
		if ((b.value == this.value) && (b.currency.equals(this.currency)))
			return true;
		return false;
	}
	
	/**
	 * The description of this bank note
	 * @return this bank note's description
	 */
	@Override
	public String toString() {
		return this.value + String.format("-%s note [%d]", this.currency,this.serialNumber);
	}
	
	
	

}
