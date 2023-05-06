import model.Category;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {

    public void setupStange2(){
        Product product1= new Product("ProductB" , "xxxxB", 20000,  2 ,Category.TOYS_AND_GAMES);
        Product product2= new Product("ProductC" , "xxxxc", 6000,  2 ,Category.FOOD_AND_DRINKS);

    }

    @Test
    public void createProductSuccessfully(){
        assertTrue(false);
    }

    @Test
    public void validateProductPriceTest(){
       assertTrue(false);
    }

    @Test
    public void valudateProductQuantityTest(){
        assertTrue(false);
    }

    @Test
    public void increaseProductTest(){
        assertTrue(false);
    }

    @Test
    public void increaseProductExceptionTest(){
        assertTrue(false);
    }

    @Test
    public void decreaseProductTest(){
        assertTrue(false);
    }

    @Test
    public void decreaseProductExceptionTest(){
       assertTrue(false);
    }

}
