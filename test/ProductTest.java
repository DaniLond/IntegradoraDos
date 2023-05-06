import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.Category;
import model.Inventory;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {


    public void setupStange3() throws NegativeAmountException {
        Product product1= new Product("ProductA" , "xxxxA" , 10000, 6 , Category.BOOKS);
    }

    //Validar que el precio no este negativo
    @Test
    public void validateProductPriceTest() throws NegativeAmountException {
        setupStange3();

        assertThrows(NegativeAmountException.class, ()->{
            new Product("Product D" , "xxxD" , -50000, 2, Category.CLOTHES_AND_ACCESSORIES);
        });
    }

    //validar que la cantidad no este negativa
    @Test
    public void valudateProductQuantityTest() throws NegativeAmountException {
        setupStange3();
        assertThrows(NegativeAmountException.class, ()->{
            new Product("Product E" , "xxxE" , 50000, -3, Category.CLOTHES_AND_ACCESSORIES);
        });
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
