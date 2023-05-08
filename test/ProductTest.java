import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {



    public void setupStange1() throws NegativeAmountException, IOException, DuplicatedProductException {
        Inventory inventory = new Inventory();
        Order order = new Order("Santiago", 2000, LocalDate.now());
        Product product1 = new Product("ProductA", "xxxxA", 1000, 1, Category.BOOKS);
        Product product2 = new Product("ProductB", "xxxxB", 1000, 2, Category.FOOD_AND_DRINKS);
        order.addProduct(product1);
        order.addProduct(product2);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

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
        Product product3 = new Product("ProductD", "xxxxD", 700, 3, Category.ELECTRONICS);
        assertThrows(NegativeAmountException.class, () -> product3.increaseProduct(-2));
    

    }


    @Test
    public void increaseProductExceptionTest() throws NegativeAmountException{
        Product product3 = new Product("ProductC", "xxxxC", 500, 3, Category.FOOD_AND_DRINKS);
        assertThrows(NegativeAmountException.class, () -> product3.increaseProduct(-2));

    }

    @Test
    public void decreaseProductTest() throws NegativeAmountException, DuplicatedProductException, IOException {
        setupStange1();
        Inventory inventory = new Inventory();

        // Crea un nuevo producto para agregar al inventario
        Product product = new Product("ProductC", "xxxxC", 1500, 3, Category.ELECTRONICS);

        // Llama al método addProduct() y verifica si se agregó correctamente
        boolean productAdded = inventory.addProduct(product);
        assertTrue(productAdded);

    }

    @Test
    public void decreaseProductExceptionTest() throws NegativeAmountException,DuplicatedProductException, IOException {
    setupStange1();
        Inventory inventory = new Inventory();
        Product product = new Product("ProductA", "xxxxA", 1000, 5, Category.BOOKS);
        inventory.addProduct(product);
        // Intentar decrementar una cantidad de -4
        Assertions.assertThrows(NegativeAmountException.class, () -> {
            inventory.decreaseProduct(product.getName(), -4);});
        // Verificar que la cantidad del producto no ha cambiado
        Assertions.assertEquals(5, product.getQuantity());
    }

    }

