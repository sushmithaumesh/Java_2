import account.Account;
import error.BankErrorCodes;

import java.util.HashMap;

public class BankTeller implements Bank {

	private HashMap<Integer, Account> bankAccounts;

	public BankTeller() {
		bankAccounts = new HashMap<>();
	}

	@Override
		public int accountExists(int accountNumber) {
			return (bankAccounts.containsKey(accountNumber)) ? 1 : BankErrorCodes.ACCOUNT_NOT_FOUND.getErrorCode();
		}

	@Override
		public Account getAccount(int accountNumber) {
			if (bankAccounts.containsKey(accountNumber)) {
				return bankAccounts.get(accountNumber);
			}
			return null;
		}

	@Override
		public void openAccount(int accountNumber, Account account) {
			bankAccounts.put(accountNumber, account);
		}

	@Override
		public double addAmount(double amount, Account account) {
			account.addAmount(amount);
			return amount * account.getInterestRate();
		}
}

