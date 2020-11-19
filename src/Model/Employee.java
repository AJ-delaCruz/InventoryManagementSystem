package Model;

import java.util.Objects;

public class Employee {
   private int accountNumber;
   private String password;

    public Employee(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return accountNumber == employee.accountNumber &&
                Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, password);
    }
}
