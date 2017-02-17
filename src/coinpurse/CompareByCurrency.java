package coinpurse;

import java.util.Comparator;

/**
 * Comparator class of monetary objects using their currency.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
class CompareByCurrency implements Comparator<Valuable> {

	/**
	 * compare 2 monetary objects by their currency
	 * 
	 * @param v1
	 *            is the first monetary object
	 * @param v2
	 *            is the second monetary object
	 * @return -1 if o1's currency come first<br>
	 *         0 if both of 2 have same currency<br>
	 *         1 if o1's currency come after
	 */
	@Override
	public int compare(Valuable v1, Valuable v2) {
		return v1.getCurrency().compareTo(v2.getCurrency());
	}

}
