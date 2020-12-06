package Controller;

/**
 * LoginMessage Class
 * Sends a message of an employee
 */
public class LoginMessage implements Message {
    int accountNumber;
    String password;

    /**
     * Constructor for the LoginMessage
     * @param accountNumber employees account number
     * @param password employees password
     */
    public LoginMessage(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    /**
     * Returns Employees account number
     * @return Employees account number
     */
    int getAccountNumber() { return accountNumber; }

    /**
     * Returns Employees password
     * @return employees password
     */
    String getPassword() { return password; }
}
