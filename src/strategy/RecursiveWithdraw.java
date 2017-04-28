package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import coinpurse.Coin;
import coinpurse.Valuable;

/**
 * One algorithm to withdraw that this class provided is using recursion.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see coinpurse.WithdrawStrategy#withdraw(double, java.util.List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		// even if size > 0 but amount is 0, return empty to add selected items in higher level.
		if(amount==0){
			return new ArrayList<Valuable>();
		}
		
		// even if size > 0 but amount is less than 0, return empty to add selected items in higher level.
		if(amount<0)
			return null;
		
		// when it reaches to the lowest level. If amount is 0, return empty list. Otherwise return null;
		if(money.size() == 0){
			if(amount==0){
				return new ArrayList<Valuable>();
			}
			return null;
		}
		
		// these code for create 2 case for withdraw
		// initialize some variable
		Valuable first = money.get(0);
		List<Valuable> list = null;
		List<Valuable> restList = money.subList(1, money.size());
		//case 1: choose the first item
		if ((list = withdraw(amount - first.getValue(), restList)) != null){
			list.add(first);
			return list;
		}
		//case 2: doesn't choose the first item 
		return withdraw(amount, restList);

			
	}

}
