package Model;

import java.util.Objects;

/**
 * Employee Class
 * Represents an Employee
 * account info
 */
public class Employee {
    private int accountNumber;
    private String password;

    /**
     * Constructor for the Employee
     * class
     * @param accountNumber Employees ID number
     * @param password Employees login password
     */
    public Employee(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    /**
     * Return's the account number
     * of the Employee.
     * @return employees account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Return's the password
     * of the employee.
     * @return employees password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Compares an object with a Employee
     * object to see if they are the same.
     * @param o object being compared with.
     * @return if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return accountNumber == employee.accountNumber &&
                Objects.equals(password, employee.password);
    }

    /**
     * Determines the priority of the Employee
     * by account and password.
     * @return the priority
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, password);
    }
}

