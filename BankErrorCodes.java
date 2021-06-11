

// This class represents error codes

public enum BankErrorCodes {


	// Invalid account number input entered by user.

	INVALID_ACCOUNT_NUMBER_ENTERED(-1),


	// Account not found in bank.

	ACCOUNT_NOT_FOUND(-2);

	private int errorCode;

	BankErrorCodes(int errorCode) {
		this.errorCode = errorCode;
	}


	// Returns integer value corresponding error code.
	// @return int value.

	public int getErrorCode() {
		return this.errorCode;
	}


}
