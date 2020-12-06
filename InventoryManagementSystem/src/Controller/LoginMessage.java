package Controller;


public class LoginMessage implements Message {
    int accountNumber;
    String password;

    public LoginMessage(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    int getAccountNumber() { return accountNumber; }
    String getPassword() { return password; }
}
