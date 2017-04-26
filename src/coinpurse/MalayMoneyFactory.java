package coinpurse;

/**
 * Factory for creating Malaysian money, both in coin and bank note.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	public final String DEFAULT_CURRENCY = "Ringgit";
	/** value of money that can create in coin and bank note */
	double[] validValues = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
	private static long nextSerialNumber = 1200000;

	/**
	 * Creating money method of Malaysian money.<br>
	 * if value of money is >1 and valid, it creates a banknote in Ringgit.<br>
	 * if value of money is <1 and valid, it creates a coin in Sen.
	 * @param value is used to create Malaysian money.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (!isValid(value, validValues))
			throw new IllegalArgumentException();

		if (value < 1) {
			Coin coin = new Coin(value, DEFAULT_CURRENCY);
			coin.setDescription(value*100, "Sen");
			return coin;
		} else {
			Banknote banknote = new Banknote(value, DEFAULT_CURRENCY);
			banknote.setSerialNumber(++nextSerialNumber);
			return banknote;
		}
	}
	
	/**
	 * Method class for trying creating Malaysian money
	 * @param args isn't use
	 * @throws IllegalAccessException if value isn't valid curreny amount.
	 */
	public static void main(String[] args) throws IllegalAccessException {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable mValuable = factory.createMoney(0.20); 
		System.out.println(mValuable.toString()); //20-Sen
		Valuable mValuable2 = factory.createMoney(1000.0); 
		System.out.println(mValuable2.toString()); //throw IllegalArgumentException
	}
	
	/*
	 * (non-Javadoc)
	 * @see coinpurse.MoneyFactory#getDEFAULT_CURRENCY()
	 */
	@Override
	public String getDEFAULT_CURRENCY() {
		return DEFAULT_CURRENCY;
	}

}
