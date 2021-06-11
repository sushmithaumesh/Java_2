import account.Account;
import error.BankErrorCodes;

import java.util.Scanner;

// This class is responsible for interacting with the user.

public class Atm {


	// This method reads account number typed by user on screen. It also allows
	// user to perform retries while entering account number.
	// @param accountNumber account number entered by user
	// @param scanner read object
	// @param numberOfRetries number of retried allowed
	// @return account number or -1 in case user enters wrong account number
	// and does not want to retry

	public int get5DigitAccountNumberFromUser(int accountNumber,
			final Scanner scanner,
			int numberOfRetries) 
	{
		if (numberOfRetries == 0) {
			return BankErrorCodes.INVALID_ACCOUNT_NUMBER_ENTERED.getErrorCode();
		}
		if (isValidAccountNumber(accountNumber)) {
			return accountNumber;
		} else {
			java.lang.System.out.println("Wrong account number, account number should be of 5 digits\n" +
					"Would you like to try again?\n 1. Yes 2. No");
			int userInput = scanner.nextInt();
			boolean tryAgain = userInput == 1;
			if (tryAgain) {
				java.lang.System.out.println("Please enter your 5 digit account number.");
				accountNumber = scanner.nextInt();
				java.lang.System.out.println("Number of retries left:" + numberOfRetries + "\n");
				numberOfRetries = numberOfRetries - 1;
				return (get5DigitAccountNumberFromUser(accountNumber, scanner, numberOfRetries));
			} else {
				java.lang.System.out.println("Thank you for a being a valued customer. Have a great day.");
				return BankErrorCodes.INVALID_ACCOUNT_NUMBER_ENTERED.getErrorCode();
			}
		}
	}


	// The only condition for validity that we are checking for now
	// is that the account number should be a 5 digit number.
	// @param accountNumber account number.
	// @return true if account number is of 5 digit else false.

	private boolean isValidAccountNumber(final int accountNumber) {
		return !(accountNumber > 99999 || accountNumber < 10000);
	}
}

