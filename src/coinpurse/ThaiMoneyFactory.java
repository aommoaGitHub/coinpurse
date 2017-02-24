package coinpurse;

/**
 * Factory for creating Thai money, both in coin and bank note.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	public final String DEFAULT_CURRENCY = "Baht";
	/**value of money that can create in coin and bank note */
	double[] validValues = { 0.25, 0.50, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	private static long nextSerialNumber = 1100000;

	/**
	 * Creating money method of Thai money.<br>
	 * if value of money is >1 and valid, it creates a banknote in Baht.<br>
	 * if value of money is <1 and valid, it creates a coin in Sen.
	 * @param value is used to create Thai money.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalAccessException {
		if (!isValid(value, validValues))
			throw new IllegalAccessException();
		if (value < 20) {
			Coin coin = new Coin(value, DEFAULT_CURRENCY);
			if (value < 1)
				coin.setDescription(value * 100.0, "Satang");
			return coin;
		} else {
			Banknote banknote = new Banknote(value, DEFAULT_CURRENCY);
			banknote.setSerialNumber(++nextSerialNumber);
			return banknote;
		}
	}

	/**
	 * Method class for trying creating Thai money
	 * @param args isn't use
	 * @throws IllegalAccessException if value isn't valid curreny amount.
	 */
	public static void main(String[] args) throws IllegalAccessException {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable mValuable = factory.createMoney(0.25); 
		System.out.println(mValuable.toString()); //25-Satang
		Valuable mValuable2 = factory.createMoney(1000.0);
		System.out.println(mValuable2.toString()); //1000-Baht note [1100001]
	}
	
}
