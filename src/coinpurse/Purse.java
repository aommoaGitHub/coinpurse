package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A purse contains coins and bank notes. You can insert them, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the purse decides which coin or bank note to remove.
 * 
 * @author Vittunyuta Maeprasart
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of monetary objects the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	/**
	 * Balance is total money in the purse.
	 */
	private double balance;

	/**
	 * Create a purse with a specified capacity.
	 * @param capacity
	 *            is maximum number of monetary objects you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
		this.balance = 0.0;

	}

	/**
	 * Count and return the number of monetary objects in the purse. This is the number of
	 * monetary objects, not their value.
	 * 
	 * @return the number of monetary objects in the purse
	 */
	public int count() {
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return this.money.size() >= this.capacity;
	}

	/**
	 * Insert a monetary objects into the purse. The monetary object is only inserted if the purse has
	 * space for it and the objects has positive value. No worthless monetary objects!
	 * 
	 * @param val
	 *            is a kind of monetary object to insert into purse
	 * @return true if a monetary object inserted, false if can't insert
	 */
	public boolean insert(Valuable val) {
		// if the purse is already full then can't insert anything.
		if (isFull())
			return false;
		//if monetary objects value less than 0 then doesn't insert anything
		if (val.getValue() <= 0)
			return false;

		for (int i = 0; i < count(); i++) {
			if (val.getValue() >= this.money.get(i).getValue()) {
				this.money.add(i, val);
				this.balance += val.getValue();
				return true;
			}
		}
		this.money.add(val);
		this.balance += val.getValue();
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of monetary objects
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of monetary objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0)
			return null;
		if (amount > this.balance)
			return null;
		List<Valuable> templist = new ArrayList<Valuable>();
		double remain = amount;
		for (Valuable val : this.money) {
			if (remain >= val.getValue()) {
				remain -= val.getValue();
				templist.add(val);
			}
		}
		if (remain != 0)
			return null;
		// Success.
		// Remove the monetary objects you want to withdraw from purse,
		// and return them as an array.
		for (Valuable tem : templist) {
			for (int i = 0; i < count(); i++) {
				if (tem.equals(this.money.get(i))) {
					this.balance -= this.money.get(i).getValue();
					this.money.remove(i);
					break;
				}
			}
		}
		Valuable[] arrayMonetary = new Valuable[templist.size()];
		templist.toArray(arrayMonetary);
		return arrayMonetary; 
	}

	/**
	 * Description of the purse
	 * @return the purse's description
	 */
	public String toString() {
		return count() + " items with value " + this.balance;
	}
	
	
}
