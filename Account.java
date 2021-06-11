
//package account;

// This class represents and account. An account can be gold checking,
// silver checking, gold savings and silver savings.

public class Account {

    private AccountType accountType;
    private AccountTier accountTier;
    private double currentBalance;

    
 // This constructor creates a new account.
 // @param accountType type of account for example
 //checking or savings
 // @see AccountType

    public Account(AccountType accountType, AccountTier accountTier) {
        this.accountType = accountType;
        this.accountTier = accountTier;
        this.currentBalance = 0;
    }

   // This method returns interest rate for a account.
 // @return 3% for gold and 1% for silver.
 
    public double getInterestRate() {
        return this.accountTier == AccountTier.GOLD ? 0.03 : 0.01;
    }

    
 // Adds money to the bank account .
  //@param amount new amount to be added.
// @return new current balance.
    public double addAmount(double amount) {
        this.currentBalance = this.currentBalance + amount;
        return this.currentBalance;
    }

    
 // Returns current balance.
 // @return current balance bank account.

    public double getBalance() {
        return this.currentBalance;
    }

    
 // Returns type of account i.e checking/savings.
 // @return type of account.
                 
    public AccountType getAccountType() {
        return accountType;
    }

   
       // Returns account bag tier.
           // @return tier like gold, silver.
                 
    public AccountTier getAccountTier() {
        return accountTier;
    }

}
