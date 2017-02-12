package coinpurse;

import java.util.Comparator;

/**
 * Comparator class of Coin using their currency.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
class CompareByCurrency implements Comparator<Coin> {

	/**
	 * compare 2 coin by their currency
	 * 
	 * @param o1
	 *            is the first coin
	 * @param o2
	 *            is the second coin
	 * @return -1 if o1's currency come first<br>
	 *         0 if both of 2 have same currency<br>
	 *         1 if o1's currency come after
	 */
	@Override
	public int compare(Coin o1, Coin o2) {
		return o1.getCurrency().compareTo(o2.getCurrency());
	}

}
