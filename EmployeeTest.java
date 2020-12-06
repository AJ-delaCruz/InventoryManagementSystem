package JUnitTest;

import Model.Employee;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
    public void test(){
        Employee test = new Employee(12345, "password");
        assertTrue(12345 == test.getAccountNumber());
        assertTrue("password".equals(test.getPassword()));

    }
}
