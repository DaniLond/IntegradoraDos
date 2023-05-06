import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.Category;
import model.Inventory;
import model.Product;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class InventoryTest {


    private Inventory inventory;

    public void setupStange1() throws NegativeAmountException, DuplicatedProductException, IOException {
        inventory= new Inventory();
        Product product1= new Product("ProductA" , "xxxxA" , 10000, 6 , Category.BOOKS);
        inventory.addProduct(product1);
    }

    public void setupStange2() throws NegativeAmountException, DuplicatedProductException, IOException {
        inventory= new Inventory();
        Product product1= new Product("ProductB" , "xxxxB", 20000,  2 ,Category.TOYS_AND_GAMES);
        Product product2= new Product("ProductC" , "xxxxc", 6000,  2 ,Category.FOOD_AND_DRINKS);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
    }

    public void setupStange3() throws NegativeAmountException, DuplicatedProductException, IOException {
        inventory= new Inventory();
        Product product1= new Product("Calabozos y dragones" , "xxxxB", 20000,  3 ,Category.TOYS_AND_GAMES);
        Product product2= new Product("Coco-Lemonade" , "xxxxC", 6000,  8 ,Category.FOOD_AND_DRINKS);
        Product product3= new Product("El diario de Ana Frank" , "xxxxA", 30000,  6 ,Category.BOOKS);
        Product product4= new Product("Agus" , "xxxxD", 1000,  5 ,Category.FOOD_AND_DRINKS);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
    }

    //Agregar un producto correctamente
    @Test
    public void addNewProductTest() throws NegativeAmountException, DuplicatedProductException, IOException {
        setupStange1();
        Product product= new Product("Producto F" , "xxxxF" , 53000, 8 , Category.FOOD_AND_DRINKS);
        inventory.addProduct(product);
        assertEquals(inventory.getSize() , 2);
        assertEquals(inventory.getProducts().get(1).getName() , "Producto F" );

    }

    //Verificar que el producto se este buscando correctamente
    @Test
    public void testSearchProduct() throws NegativeAmountException, IOException, DuplicatedProductException {
        setupStange1();
        Product product1 = new Product("Product1", "xxxx1", 20000,  2 ,Category.TOYS_AND_GAMES);
        Product product2 = new Product("Product2", "xxxx2", 50000,  1 ,Category.TOYS_AND_GAMES);

        inventory.addProduct(product1);
        inventory.addProduct(product2);


        assertEquals(product1, inventory.searchProduct("Product1"));
        assertEquals(product2, inventory.searchProduct("Product2"));


        assertNull(inventory.searchProduct("Product 4"));
    }
    //Agregar un product duplicado
    @Test
    public void addDuplicatedProductTest() throws NegativeAmountException, DuplicatedProductException, IOException {
        setupStange1();
        assertThrows(DuplicatedProductException.class , ()-> {
            inventory.addProduct(new Product("ProductA" , "xxxxA" , 10000, 6 , Category.BOOKS));
        });
    }

    @Test
    void searchProductSuccessfullyByNameTest(){
        assertTrue(false);
    }

    @Test
    void searchProductSuccessfullyByPriceTest(){
        assertTrue(false);
    }

    @Test
    void searchProductSuccessfullyByCategoryTest(){
        assertTrue(false);
    }

    @Test
    void searchProductSuccessfullyByTimeBoughtTest(){
        assertTrue(false);
    }

    @Test
    void searchProductNotSuccessfuulyByNameTest(){
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
