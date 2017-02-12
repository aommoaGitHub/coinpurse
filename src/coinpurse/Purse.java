package coinpurse;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Vittunyuta Maeprasart
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money;

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
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
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Coin>();
		this.balance = 0.0;

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
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
	 * Return the capacity of the coin purse.
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
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (isFull())
			return false;
		//if coin value less than 0 then doesn't insert anything
		if (coin.getValue() <= 0)
			return false;

		for (int i = 0; i < count(); i++) {
			if (coin.compareTo(this.money.get(i)) == 1) {
				this.money.add(i, coin);
				this.balance += coin.getValue();
				return true;
			}
		}
		this.money.add(coin);
		this.balance += coin.getValue();
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		if (amount < 0)
			return null;
		if (amount > this.balance)
			return null;
		List<Coin> templist = new ArrayList<Coin>();
		double remain = amount;
		for (Coin coin : this.money) {
			if (remain >= coin.getValue()) {
				remain -= coin.getValue();
				templist.add(coin);
			}
		}
		if (remain != 0)
			return null;
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		for (Coin tem : templist) {
			for (int i = 0; i < count(); i++) {
				if (tem.equals(this.money.get(i))) {
					this.balance -= this.money.get(i).getValue();
					this.money.remove(i);
					break;
				}
			}
		}
		Coin[] arrayCoin = new Coin[templist.size()];
		templist.toArray(arrayCoin);
		return arrayCoin; 
	}

	/**
	 * Description of the purse
	 * @return the purse's description
	 */
	public String toString() {
		return count() + " coins with value " + this.balance;
	}
}
