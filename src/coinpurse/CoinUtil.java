package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some monetary objects utility methods for practice using Lists and Comparator.
 * 
 * @author Vittunyuta Maeprasart
 */
public class CoinUtil {

	/**
	 * Method that examines all the monetary objects in a List and returns only the objects
	 * that have a currency that matches the parameter value.
	 * 
	 * @param monetarylist
	 *            is a List of monetary objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from monetarylist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<? extends Valuable> monetarylist, String currency) {
		List<Valuable> vals = new ArrayList<Valuable>();
		for (Valuable vallist : monetarylist) {
			if (vallist.getCurrency().equals(currency)) {
				vals.add(vallist);
			}
		}
		return vals; // return a list of monetary objects references copied from monetarylist
	}

	/**
	 * Method to sort a list of monetary objects by currency. On return, the list (monetaryObjs)
	 * will be ordered by currency.
	 * 
	 * @param monetaryObjs
	 *            is a List of monetary objects we want to sort.
	 */
	public static void sortByCurrency(List<? extends Valuable> monetaryObjs) {
		Collections.sort(monetaryObjs, new CompareByCurrency());
	}

	/**
	 * Sum monetary objects by currency and print the sum for each currency. Print one line
	 * for the sum of each currency.
	 * 
	 * @param vals
	 *            is a List of monetary objects we want to sum.
	 */
	public static void sumByCurrency(List<? extends Valuable> vals) {
		Map<String, Double> hash = new HashMap<String, Double>();
		for (Valuable val : vals) {
			hash.put(val.getCurrency(), hash.getOrDefault(val.getCurrency(), 0.0) + val.getValue());
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
		System.out.println("Filter monetary objects by currency of " + currency);
		List<Valuable> vals = makeInternationalMonetaryObjs();
		int size = vals.size();
		System.out.print(" INPUT: ");
		printList(vals, " ");
		List<Valuable> rupees = filterByCurrency(vals, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (vals.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort monetary objects by currency");
		vals = makeInternationalMonetaryObjs();
		System.out.print(" INPUT: ");
		printList(vals, " ");
		sortByCurrency(vals);
		System.out.print("RESULT: ");
		printList(vals, " ");

		System.out.println("\nSum monetary objects by currency");
		vals = makeInternationalMonetaryObjs();
		System.out.print("monetary objects = ");
		printList(vals, " ");

		sumByCurrency(vals);

	}

	/**
	 * Make a list of monetary objects containing different currencies.
	 * 
	 * @return a new list of all monetary objects
	 */
	public static List<Valuable> makeInternationalMonetaryObjs() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeMonetaryObjs("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeMonetaryObjs("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeMonetaryObjs("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of monetary objects using given values.
	 * 
	 * @param currency
	 *            of this list of monetary objects
	 * @param values
	 *            of incoming monetary objects
	 * @return a new List containing incoming values and currency
	 */
	public static List<Valuable> makeMonetaryObjs(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			if(value >=20)
				list.add(new Banknote(value, currency));
			else
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
