package JUnitTest;

import Controller.AddProductMessage;
import junit.framework.TestCase;

public class AddProductMessageTest extends TestCase {
    public void test(){
        AddProductMessage test = new AddProductMessage("Portal 2",
                "Video Game", 59.99, 3, 123456);

        assertTrue(test.getName().equals("Portal 2"));

        assertTrue(test.getCategory().equals("Video Game"));

        assertFalse(test.getPrice() == 30.00);

        assertTrue(test.getStock() == 3);

        assertFalse(1234 == test.getInvoiceNumber());
    }
}
