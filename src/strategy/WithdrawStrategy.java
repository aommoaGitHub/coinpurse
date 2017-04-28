package strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * This class is provide for changing algorithm for withdraw money from the
 * purse.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public interface WithdrawStrategy {

	/**
	 * Find and return a collection of money that will enable the purse to
	 * withdraw the requested amount.
	 * 
	 * @param amount
	 *            is the amount of money to withdraw
	 * @param money
	 *            the contents that are available for possible withdraw. Must
	 *            not be null, but may be an empty list. This list is not
	 *            modified.
	 * @return if a solution is found, return a List containing references from
	 *         the money parameter (List) whose sum equals the amount. If a
	 *         solution is not found, returns null.
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> money);

}
