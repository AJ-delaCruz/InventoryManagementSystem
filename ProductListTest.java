package JUnitTest;
import Model.Product;
import View.ProductList;
import java.util.Iterator;
import Model.LineProduct;
import junit.framework.TestCase;

public class ProductListTest extends TestCase {
    public void test(){
        ProductList test = new ProductList();
        Product productOne = new Product("IPhone",
                "Electronics", 850.00, 300, 123456);
        Product productTwo = new Product("Laptop",
                "Electronics", 1850.00, 500, 123478);
        Product productThree = new Product("Android",
                "Electronics", 750.00, 700, 123446);
        test.addProduct(productOne);
        test.addProduct(productTwo);
        test.addProduct(productThree);

        String text = "Name              Category              Price            Stock            Invoice number\n" +
                "IPhone               Electronics                $850.0             300                 123456\n" +
                "Name              Category              Price            Stock            Invoice number\n" +
                "Laptop               Electronics                $1850.0             500                 123478\n" +
                "Name              Category              Price            Stock            Invoice number\n" +
                "Android               Electronics                $750.0             700                 123446";
        text = text.replaceAll("\\s", "");
        String textTwo = test.formatProduct();
        textTwo = textTwo.replaceAll("\\s", "");
        assertTrue(text.equals(textTwo));

    }
}
