#CoinPurse Project in OOP2 Lab Course on 10 Feb 2017
CoinPurse has UI allow the user to deposit and withdraw their money from their purse. There are 4 important classes.
* Coin class indicate a coin with monetary value and currency
* ConsoleDigital class is UI for the CoinPurse.
* Main class use for starting the application.
* Purse class is a coin purse contains coins. You can insert coins, withdraw money, check the balance, and check if the purse is full. When you withdraw money, the coin purse decides which coins to remove.

**And some other classes.**
* CoinUtil class has some Coin utility methods for practice using Lists and Comparator.
	- filterByCurrency method
	- sortByCurrency method
	- sumByCurrenc method
* CompareByCurrency class is compare coin class which use in 'sortByCurrency' method in CoinUtil class.
* PurseTest class use JUnit for testing Purse class.
