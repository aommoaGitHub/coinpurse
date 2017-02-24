package coinpurse;

/**
 * a banknote with a monetary value and currency
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class Banknote extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** The unique serial number. */
	private long serialNumber;

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
	 * @param currency
	 *            of this bank note
	 */
	public Banknote(double value, String currency) {
		super(value, currency);

	}

	/**
	 * set serial number of this bank note
	 * 
	 * @param nextSerialNumber
	 *            is serial of this banknote
	 */
	public void setSerialNumber(long nextSerialNumber) {
		this.serialNumber = nextSerialNumber;
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
	 * The description of this bank note
	 * 
	 * @return this bank note's description
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]",this.getValue(), this.getCurrency(), this.serialNumber);
	}

}
