import account.AccountTier;
import account.AccountType;
import actors.Atm;
import bank.Bank;
import bank.BankTeller;
import error.BankErrorCodes;

import java.util.Scanner;

public class MainApplication {

	private static final int RETIRES = 3;

	private static void handleUserInput(int userInput, Account account,
			Bank bank, Scanner scan) {
		switch (userInput) {
			case 1:
				System.out.println("Your balance is:" + account.getBalance());
				break;
			case 2:
				System.out.println("Please enter the amount you want" +
						" to deposit");
				double amount = scan.nextDouble();
				double interestRate = bank.addAmount(amount, account);
				System.out.println("Thanks for depositing money. Your earned " +
						+ interestRate + "$");
				account.addAmount(interestRate);
				System.out.println("Your new balance is:" + account.getBalance());
				break;
			default:
				System.out.println("Invalid option.");
		}
	}

	static int getAccountNumberFromUser(Scanner scanner) {
		Atm atm = new Atm();
		System.out.println("Hello Dear Customer. Please enter your 5 digit account number" +
				" to get started\n");
		//read first value

		int accountNumber = scanner.nextInt();
		return atm.get5DigitAccountNumberFromUser(accountNumber, scanner, RETIRES);
		static void main(String[] args) {
			BankTeller bankTeller = new BankTeller();
			Scanner scan = new Scanner(System.in);

			//intializes bank account
			initializeData(bankTeller);

			//reads account number
			int accountNumber = getAccountNumberFromUser(scan);

			// check if account number is 5 digit
			if (accountNumber != BankErrorCodes.INVALID_ACCOUNT_NUMBER_ENTERED.getErrorCode()) {
				System.out.println("Thank you, getting bank account details. Please wait....");
				int accountExists = bankTeller.accountExists(accountNumber);
				if (!(accountExists == BankErrorCodes.ACCOUNT_NOT_FOUND.getErrorCode())) {
					Account account = bankTeller.getAccount(accountNumber);
					System.out.println("\nAccount Type:" + account.getAccountType());
					System.out.println("Account Tier:" + account.getAccountTier());
					System.out.println("What would you like to do today.\n" +
							"1. Check balance." +
							"\n2. Deposit Money");
					int userInput = scan.nextInt();
					handleUserInput(userInput, account, bankTeller, scan);
				} else {
					System.out.println("Account does not exist.");
				}
			}
		}
	}

	private static void initializeData(BankTeller bankTeller) {
		Account checkingGold = new Account(AccountType.CHECKING, AccountTier.GOLD);
		checkingGold.addAmount(1000);
		Account checkingSilver = new Account(AccountType.CHECKING, AccountTier.SILVER);
		checkingSilver.addAmount(2000);
		Account savingsGold = new Account(AccountType.SAVINGS, AccountTier.GOLD);
		savingsGold.addAmount(3000);
		Account savingsSilver = new Account(AccountType.SAVINGS, AccountTier.SILVER);
		savingsSilver.addAmount(4000);
		bankTeller.openAccount(11111, checkingGold);
		bankTeller.openAccount(22222, checkingSilver);
		bankTeller.openAccount(33333, savingsGold);
		bankTeller.openAccount(44444, savingsSilver);
	}
}
