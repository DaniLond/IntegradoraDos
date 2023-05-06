import exceptions.NegativeAmountException;
import model.Category;
import model.Inventory;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class InventoryTest {
    private Inventory inventory;

    public void setupStange1() throws NegativeAmountException {
        inventory= new Inventory();
        Product product1= new Product("ProductA" , "xxxxA" , 10000, 6 , Category.BOOKS);
        //Agregar los productos al inventario
    }

    public void setupStange2() throws NegativeAmountException {
        inventory= new Inventory();
        Product product1= new Product("ProductB" , "xxxxB", 20000,  2 ,Category.TOYS_AND_GAMES);
        Product product2= new Product("ProductC" , "xxxxc", 6000,  2 ,Category.FOOD_AND_DRINKS);
        //Agregar los productos al inventario
    }

    public void setupStange3() throws NegativeAmountException {
        inventory= new Inventory();
        Product product1= new Product("Calabozos y dragones" , "xxxxB", 20000,  3 ,Category.TOYS_AND_GAMES);
        Product product2= new Product("Coco-Lemonade" , "xxxxC", 6000,  8 ,Category.FOOD_AND_DRINKS);
        Product product3= new Product("El diario de Ana Frank" , "xxxxA", 30000,  6 ,Category.BOOKS);
        Product product4= new Product("Agus" , "xxxxD", 1000,  5 ,Category.FOOD_AND_DRINKS);
        //Agregar los productos al inventario
    }

    @Test
    public void addNewProductTest(){
        assertTrue(false);
    }

    @Test
    public void addDuplicatedProductTest(){
        assertTrue(false);
    }

    @Test
    public void removeProductSuccessfullyTest(){
        assertTrue(false);
    }

    @Test
    public void removeNonexistentProductTest(){
        assertTrue(false);
    }

    @Test
    public void searchRangeNumericalValueTest(){
        assertTrue(false);
    }

    @Test
    public void searchRangeStringTypeTest(){
        assertTrue(false);
    }

}
