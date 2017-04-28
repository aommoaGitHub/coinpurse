package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * One algorithm to withdraw that this class provided is using greedy algorithm.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{

	/*
	 * (non-Javadoc)
	 * @see strategy.WithdrawStrategy#withdraw(double, java.util.List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>();
		double remain = amount;
		for (Valuable val : money) {
			if (remain >= val.getValue()) {
				remain -= val.getValue();
				templist.add(val);
			}
		}
		if (remain != 0)
			return null;
		return templist;
	}

}
