import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.Category;
import model.Inventory;
import model.Order;
import model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {


    public void setupStange1() throws NegativeAmountException {
        Order order= new Order("Santiago", 2000, LocalDate.now());
        Product product1= new Product("ProductA" , "xxxxA", 1000,  1 ,Category.BOOKS);
        Product product2= new Product("ProductB" , "xxxxB", 1000,  2 , Category.FOOD_AND_DRINKS);
        //Agregar los productos a la lista de order
    }


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
    public void increaseProductTest() throws NegativeAmountException {
        
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
