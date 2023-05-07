import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.Category;
import model.Inventory;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

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

    public void setupStange4() throws NegativeAmountException, DuplicatedProductException, IOException {
        inventory= new Inventory();
        Product product1= new Product("ProductB" , "xxxxB", 20000,  2 ,Category.TOYS_AND_GAMES, 4);
        Product product2= new Product("ProductC" , "xxxxD", 6000,  2 ,Category.FOOD_AND_DRINKS, 3);
        Product product3= new Product("ProductA" , "xxxxA", 20000,  6 ,Category.FOOD_AND_DRINKS, 4);
        Product product4= new Product("ProductD" , "xxxxd", 6000,  5 ,Category.FOOD_AND_DRINKS, 2);
        Product product5= new Product("ProductE" , "xxxxe", 2000,  2 ,Category.BOOKS, 4);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
        inventory.addProduct(product5);
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


        assertEquals(product1, inventory.getProducts().get(inventory.searchProductByName("Product1")));
        assertEquals(product2, inventory.getProducts().get(inventory.searchProductByName("Product2")));


        assertEquals(-1 , inventory.searchProductByName("Producto4"));
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
    void searchProductSuccessfullyByNameTest() throws NegativeAmountException, IOException, DuplicatedProductException {
        setupStange4();
        String name= "ProductC";
        ArrayList<Product> wantedProducts= inventory.searchProductByValue(name , 0);
        assertEquals(1, wantedProducts.size());
        assertTrue(wantedProducts.contains(inventory.getProducts().get(2)));
    }

    @Test
    void searchProductSuccessfullyByPriceTest() throws NegativeAmountException, IOException, DuplicatedProductException {
        setupStange4();
        String price= "20000";
        ArrayList<Product> wantedProducts= inventory.searchProductByValue(price, 1);
        assertEquals(2 , wantedProducts.size());
        assertEquals(wantedProducts.get(1).getName() , "ProductB");
        assertEquals(wantedProducts.get(0).getName() , "ProductA");
    }

    @Test
    void searchProductSuccessfullyByCategoryTest() throws NegativeAmountException, IOException, DuplicatedProductException {
        setupStange4();
        String category= "3";
        ArrayList<Product> wantedProducts= inventory.searchProductByValue(category, 2);
        assertEquals(Category.FOOD_AND_DRINKS , Category.values()[3]);
        assertEquals(3, wantedProducts.size());
        assertEquals(wantedProducts.get(1).getName() , "ProductC");
        assertEquals(wantedProducts.get(2).getName() , "ProductD");
        assertEquals(wantedProducts.get(0).getName() , "ProductA");
    }

    @Test
    void searchProductSuccessfullyByTimeBoughtTest() throws NegativeAmountException, IOException, DuplicatedProductException {
        setupStange4();
        String timesBought= "4";
        ArrayList<Product> wantedProducts= inventory.searchProductByValue(timesBought, 3);
        assertEquals(3 , wantedProducts.size());
        assertEquals(wantedProducts.get(0).getName() , "ProductA");
        assertEquals(wantedProducts.get(1).getName() , "ProductB");
        assertEquals(wantedProducts.get(2).getName() , "ProductE");

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
