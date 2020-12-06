package JUnitTest;

import Model.Product;
import junit.framework.TestCase;

public class ProductTest extends TestCase {
    public void test(){
        Product test = new Product("IPhone", "Electronics", 850.00, 300, 123456);
        assertTrue("IPhone".equals(test.getName()));
        assertTrue(850.00 == test.getPrice());
        assertTrue(test.getStock() == 300);
        assertTrue(test.getInvoiceNumber() == 123456);
    }
}
