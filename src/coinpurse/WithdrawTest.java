package coinpurse;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import strategy.GreedyWithdraw;
/**
 * This class provides test cases for withdrawing using greedy algorithm
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class WithdrawTest {
	private Purse purse;
	
	/** What to do before each test. */
	@Before
	public void setUp() throws Exception {
		purse = new Purse(10, "Baht");
		purse.setWithdrawStrategy(new GreedyWithdraw());
	}

	/** What to do after each test. */
	@After
	public void tearDown() throws Exception {
		purse = null;
	}
	
	/**
	 * Test withdrawing in normal case
	 */
	@Test
	public void normalWithdraw(){
		purse.insert(new Coin(5));
		purse.insert(new Coin(2));
		purse.insert(new Coin(10));
		purse.insert(new Coin(2));
		purse.insert(new Banknote(50));
		purse.insert(new Coin(2));
		purse.insert(new Coin(2));
		Valuable[] expected1 = { new Coin(10)};
		assertArrayEquals(expected1, purse.withdraw(10));
		// purse remain money = {5, 2, 2, 50, 2, 2}
		Valuable[] expected2 = { new Banknote(50), new Coin(2)};
		assertArrayEquals(expected2, purse.withdraw(52));
		// purse remain money = {5, 2, 2, 2}
		Valuable[] expected3 = purse.withdraw(6);
		assertNull(expected3);
		// purse remain same
		Valuable[] expected4 = purse.withdraw(8);
		assertNull(expected4);
	}
	
	/**
	 * Test withdrawing when purse is empty
	 */
	@Test
	public void withdrawEmpty(){
		Valuable[] expected = purse.withdraw(10);
		assertNull(expected);
	}
	
	/**
	 * Test withdrawing more than purse's balance
	 */
	@Test
	public void withdrawExceedBalance(){
		purse.insert(new Banknote(50));
		Valuable[] expected = purse.withdraw(100);
		assertNull(expected);
	}
}
