package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Vittunyuta Maeprasart
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Coin> filterByCurrency(final List<Coin> coinlist, String currency) {
		List<Coin> coins = new ArrayList<Coin>();
		for (Coin coinl : coinlist) {
			if (coinl.getCurrency().equals(currency)) {
				coins.add(coinl);
			}
		}
		return coins; // return a list of coin references copied from coinlist
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<Coin> coins) {
		Collections.sort(coins, new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency.
	 * 
	 * @param coin
	 *            is a List of Coin objects we want to sum.
	 */
	public static void sumByCurrency(List<Coin> coins) {
		HashMap<String, Double> hash = new HashMap<String, Double>();
		for (Coin coin : coins) {
			if (hash.get(coin.getCurrency()) == null)
				hash.put(coin.getCurrency(), coin.getValue());
			else
				hash.put(coin.getCurrency(), hash.get(coin.getCurrency()) + coin.getValue());
		}
		for (Map.Entry<String, Double> entry : hash.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Coin> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");

		sumByCurrency(coins);

	}

	/**
	 * Make a list of coins containing different currencies.
	 * 
	 * @return a new list of all coins
	 */
	public static List<Coin> makeInternationalCoins() {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of coins using given values.
	 * 
	 * @param currency
	 *            of this list of coins
	 * @param values
	 *            of incoming coins
	 * @return a new List containing incoming values and currency
	 */
	public static List<Coin> makeCoins(String currency, double... values) {
		List<Coin> list = new ArrayList<Coin>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/**
	 * Print the list on the console, on one line.
	 * 
	 * @param items
	 *            is list of elements that you want to print.
	 * @param separator
	 *            is String that will print between 2 elements.
	 * 
	 */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}
