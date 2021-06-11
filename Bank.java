import account.Account;


// This class represents banking application.


public interface Bank {


	//Check if account exists or not.
	// @param accountNumber account number.
	// @return true if account exists else false.

	int accountExists(int accountNumber);

	// This method checks whether a bank account
	// exists or not.
	// @param accountNumber account number.
	//@return Account if account exists else throws an exception.

	Account getAccount(int accountNumber) throws NullPointerException;


	// This method creates a new bank account.
	// @param account
	// @return

	void openAccount(int accountNumber, Account account);


	// This method adds money to a bank account.
	// @param amount amount to be added
	// @param account account to which amount needs to
	// be added.
	// @return interest on amount added.

	double addAmount(double amount, Account account);
}
