package compgc01;

/**
 * A class whose objects represent customers
 * that inherits from user.
 * @author Qiong Peng
 * @since May/05/2021
 */
public class Customer extends User {

    private double accountBalance;
    
    public Customer(String firstName, String lastName, String username, String password, String email, double startingBalance) {
        super(firstName, lastName, username, password, email);
        this.accountBalance = startingBalance;
    }
    
    public double getAccountBalance() {
        return accountBalance;
    }
    
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    public void addToAccountBalance(double addAmount) {
        if (addAmount > 0)
            this.accountBalance += addAmount;
        else System.out.println("Invalid amount. The amount to add has to be positive.");
    }

    /**
     * Returns the user's type as a String.
     * @return Type
     */
    public String getType() {
        return "customer";
    }
}