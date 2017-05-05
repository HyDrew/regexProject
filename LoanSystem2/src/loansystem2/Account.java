// Group 3 Final Project
package loansystem2;

public class Account {
    private String accountNumber;
    private double balance;
    
    public Account (String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
    
    
}
